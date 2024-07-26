var socket = io("http://localhost:3000");
var messages = document.getElementById("messages");

// 사용자 ID를 세션에서 가져오는 함수
function getSessionUser(callback) {
  return fetch("http://localhost:8888/login/getSessionUser", { credentials: 'include' }) // 세션 정보를 포함하여 요청
      .then((response) => response.json())
      .then((data) => {
        if (data && data.nickname) {
          sessionStorage.setItem("userId", data.nickname); // 세션 스토리지에 사용자 ID 저장
          callback(data.nickname);
        } else {
          callback('익명');
        }
      })
      .catch((error) => {
        console.error("Error fetching session user:", error);
        callback('익명');
      });
}

// 클라이언트 초기화 시 사용자 정보를 가져옴
let userId = null;
getSessionUser((id) => {
  userId = id;

  $("form").submit(function (e) {
    e.preventDefault(); // 페이지 리로딩 방지

    let div = document.createElement("div");
    div.className = "message-container right"; // 메시지를 오른쪽에 정렬

    let li = document.createElement("li");
    li.className = "message right appeared";

    let messageDiv = document.createElement("div");
    messageDiv.className = "text_wrapper";
    let messageText = document.createElement("div");
    messageText.className = "text";
    messageText.textContent = $("#message").val();

    let span = document.createElement("span");
    span.className = "timestamp";
    span.dataset.time = new Date().toISOString();
    span.textContent = "by " + (userId || '익명') + ": " + formatTimeAgo(span.dataset.time);

    messageDiv.appendChild(messageText);
    messageDiv.appendChild(span);
    li.appendChild(messageDiv);
    div.appendChild(li);

    socket.emit("chat message", {
      message: $("#message").val(),
      sender: userId || '익명', // userId가 없을 경우 '익명'으로 설정
      createdAt: span.dataset.time,
      roomId: roomId // roomId 추가
    });

    messages.appendChild(div);

    $("#message").val("");

    // 스크롤을 가장 아래로 이동
    div.scrollIntoView({ behavior: "smooth" });

    return false;
  });

  socket.on("received", (data) => {
    let div = document.createElement("div");
    div.className = data.sender === userId ? "message-container right" : "message-container left"; // 메시지를 오른쪽 또는 왼쪽에 정렬

    let li = document.createElement("li");
    li.className = data.sender === userId ? "message right appeared" : "message left appeared";

    let messageDiv = document.createElement("div");
    messageDiv.className = "text_wrapper";
    let messageText = document.createElement("div");
    messageText.className = "text";
    messageText.textContent = data.message;

    let span = document.createElement("span");
    span.className = "timestamp";
    span.dataset.time = data.createdAt;
    span.textContent = "by " + data.sender + ": " + formatTimeAgo(span.dataset.time);

    messageDiv.appendChild(messageText);
    messageDiv.appendChild(span);
    li.appendChild(messageDiv);
    div.appendChild(li);

    messages.appendChild(div);

    // 스크롤을 가장 아래로 이동
    div.scrollIntoView({ behavior: "smooth" });
  });

  // 타이핑 이벤트 설정
  let messageInput = document.getElementById("message");
  let typing = document.getElementById("typing");
  let typingTimeout;

  // isTyping 이벤트
  messageInput.addEventListener("input", () => {
    clearTimeout(typingTimeout);
    if (messageInput.value) {
      socket.emit("typing", {
        user: sessionStorage.getItem("userId"),
        message: "is typing...",
      });
    }
  });

  socket.on("notifyTyping", (data) => {
    typing.innerText = data.user + " " + data.message;
    console.log(data.user + data.message);
  });

  // 타이핑 멈춤 이벤트
  messageInput.addEventListener("input", () => {
    clearTimeout(typingTimeout);
    typingTimeout = setTimeout(() => {
      socket.emit("stopTyping", "");
    }, 2000); // 1초 동안 입력이 없으면 stopTyping 이벤트 발생
  });

  socket.on("notifyStopTyping", () => {
    typing.innerText = "";
  });
});

// formatTimeAgo 함수 정의
function formatTimeAgo(dateString) {
  const date = new Date(dateString);
  const now = new Date();
  const diff = now - date;
  const minutes = Math.floor(diff / 60000);
  if (minutes < 1) return 'just now';
  if (minutes < 60) return `${minutes} minutes ago`;
  const hours = Math.floor(minutes / 60);
  if (hours < 24) return `${hours} hours ago`;
  const days = Math.floor(hours / 24);
  return `${days} days ago`;
}

// 초기 채팅 메시지를 데이터베이스에서 가져오기
(function () {
  fetch(`http://localhost:3000/chats/rooms/${roomId}/messages`, {
    headers: {
      "username": sessionStorage.getItem("userId")
    }
  }) // Node.js 서버와 연결하여 초기 채팅 메시지를 가져옴
      .then(data => data.json())
      .then(json => {
        json.forEach(data => {
          let div = document.createElement("div");
          div.className = data.sender === userId ? "message-container right" : "message-container left"; // 메시지를 오른쪽 또는 왼쪽에 정렬

          let li = document.createElement("li");
          li.className = data.sender === userId ? "message right appeared" : "message left appeared";

          let messageDiv = document.createElement("div");
          messageDiv.className = "text_wrapper";
          let messageText = document.createElement("div");
          messageText.className = "text";
          messageText.textContent = data.message;

          let span = document.createElement("span");
          span.className = "timestamp";
          span.dataset.time = new Date(data.createdAt).toISOString(); // 날짜 형식 수정
          span.textContent = "by " + data.sender + ": " + formatTimeAgo(span.dataset.time);

          messageDiv.appendChild(messageText);
          messageDiv.appendChild(span);
          li.appendChild(messageDiv);
          div.appendChild(li);

          messages.appendChild(div);
        });
      })
      .catch((error) => {
        console.error("Error fetching initial messages:", error);
      });
})();

// 주기적으로 메시지 시간을 업데이트하는 함수
function updateTimestamps() {
  console.log("Updating timestamps..."); // 콘솔 로그 추가
  const timestamps = document.getElementsByClassName('timestamp');
  Array.from(timestamps).forEach(span => {
    const time = span.dataset.time;
    span.textContent = span.textContent.replace(/: .*/, `: ${formatTimeAgo(time)}`);
  });
}

// 30초마다 타임스탬프 업데이트
setInterval(updateTimestamps, 30000);

// 새로운 채팅방 만들기 요청
function createChatRoom(roomName) {
  fetch("http://localhost:3000/chats/createRoom", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ roomName: roomName })
  })
      .then(response => response.json())
      .then(data => {
        console.log("채팅방 생성됨:", data);
        // 새로운 채팅방이 생성된 후 필요한 동작 수행
      })
      .catch((error) => {
        console.error("채팅방 생성 중 오류 발생:", error);
      });
}

// 새로운 채팅방 만들기 버튼 클릭 시
document.getElementById("createChatRoomButton").addEventListener("click", () => {
  const roomName = document.getElementById("chatRoomNameInput").value;
  createChatRoom(roomName);
});
