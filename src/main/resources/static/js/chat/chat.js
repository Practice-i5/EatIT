var socket = io("http://192.168.0.15:3000");
var messages = document.getElementById("messages");

var userId = null;

// 세션에서 사용자 정보를 가져오는 함수
function getSessionUser() {
  return fetch("http://192.168.0.15:8888/login/getSessionUser") // Spring 서버의 API 주소
    .then((response) => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.text(); // 먼저 텍스트로 읽기
    })
    .then((text) => {
      if (!text) {
        return {}; // 비어있는 응답 처리
      }
      return JSON.parse(text); // JSON 파싱
    })
    .then((data) => {
      console.log(data);
      if (data && data.member_id) {
        userId = data.member_id / 1;
        sessionStorage.setItem("userId", userId); // 세션 스토리지에 사용자 ID 저장
      }
    })
    .catch((error) => {
      console.error("Error fetching session user:", error);
    });
}

// 세션 스토리지에서 사용자 ID 가져오기 함수
function getUserIdFromSessionStorage() {
  return sessionStorage.getItem("userId");
}

(function () {
  $("form").submit(function (e) {
    e.preventDefault(); // prevents page reloading

    let li = document.createElement("li");
    let userId = getUserIdFromSessionStorage(); // 세션 스토리지에서 사용자 ID 가져오기

    socket.emit("chat message", {
      message: $("#message").val(),
      sender: userId,
    });

    messages.appendChild(li).append($("#message").val());
    let span = document.createElement("span");
    messages.appendChild(span).append("by " + userId + ": " + "just now");

    $("#message").val("");

    return false;
  });

  socket.on("received", (data) => {
    let li = document.createElement("li");
    let span = document.createElement("span");
    var messages = document.getElementById("messages");
    messages.appendChild(li).append(data.message);
    messages.appendChild(span).append("by " + data.sender + ": " + "just now");
  });

  // // 초기화 시 사용자 정보 가져오기
  // getSessionUser();
})();
getSessionUser();
// fetching initial chat messages from the database
(function () {
  fetch("http://192.168.0.15:3000/chats")
    .then((data) => data.json())
    .then((json) => {
      json.map((data) => {
        let li = document.createElement("li");
        let span = document.createElement("span");
        messages.appendChild(li).append(data.message);
        messages
          .appendChild(span)
          .append("by " + data.sender + ": " + formatTimeAgo(data.createdAt));
      });
    });
})();

//is typing...

let messageInput = document.getElementById("message");
let typing = document.getElementById("typing");

//isTyping event
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

//stop typing
messageInput.addEventListener("keyup", () => {
  socket.emit("stopTyping", "");
});

socket.on("notifyStopTyping", () => {
  typing.innerText = "";
});
