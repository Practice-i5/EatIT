var socket = io("http://localhost:3000");
var messages = document.getElementById("messages");

// 사용자 ID를 세션에서 가져오는 함수
function getSessionUser(callback) {
  return fetch("http://localhost:8888/login/getSessionUser", { credentials: 'include' }) // 세션 정보를 포함하여 요청
      .then((response) => response.json())
      .then((data) => {
        if (data && data.member_id) {
          sessionStorage.setItem("userId", data.member_id); // 세션 스토리지에 사용자 ID 저장
          callback(data.member_id);
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
    span.textContent = "by " + (userId || '익명') + ": " + "just now";

    messageDiv.appendChild(messageText);
    messageDiv.appendChild(span);
    li.appendChild(messageDiv);
    div.appendChild(li);

    socket.emit("chat message", {
      message: $("#message").val(),
      sender: userId || '익명', // userId가 없을 경우 '익명'으로 설정
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
    span.textContent = "by " + data.sender + ": " + "just now";

    messageDiv.appendChild(messageText);
    messageDiv.appendChild(span);
    li.appendChild(messageDiv);
    div.appendChild(li);

    var messages = document.getElementById("messages");
    messages.appendChild(div);

    // 스크롤을 가장 아래로 이동
    div.scrollIntoView({ behavior: "smooth" });
  });

  // 타이핑 이벤트 설정
  let messageInput = document.getElementById("message");
  let typing = document.getElementById("typing");

  // isTyping 이벤트
  messageInput.addEventListener("keypress", () => {
    socket.emit("typing", {
      user: sessionStorage.getItem("userId"),
      message: "is typing...",
    });
  });

  socket.on("notifyTyping", (data) => {
    typing.innerText = data.user + " " + data.message;
    console.log(data.user + data.message);
  });

  // 타이핑 멈춤 이벤트
  messageInput.addEventListener("keyup", () => {
    socket.emit("stopTyping", "");
  });

  socket.on("notifyStopTyping", () => {
    typing.innerText = "";
  });
});

// 초기 채팅 메시지를 데이터베이스에서 가져오기
(function () {
  fetch("http://localhost:3000/chats")// Node.js 서버와 연결하여 초기 채팅 메시지를 가져옴
      .then(data => {
        return data.json();
      })
      .then(json => {
        json.map(data => {
          let li = document.createElement("li");
          let span = document.createElement("span");
          messages.appendChild(li).append(data.message);
          messages
              .appendChild(span)
              .append("by " + data.sender + ": " + formatTimeAgo(data.createdAt));
        });
      });
})();

