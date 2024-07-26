// var socket = io("http://localhost:3001");

// 채팅 폼 요소를 가져옵니다.
const chatForm = document.getElementById('chat-form');
// 채팅 메시지 영역 요소를 가져옵니다.
const chatMessages = document.querySelector('.chat-messages');
// 방 이름 표시 요소를 가져옵니다.
const roomName = document.getElementById('room-name');
// 사용자 목록 표시 요소를 가져옵니다.
const userList = document.getElementById('users');

// URL에서 사용자 이름과 방 이름을 가져옵니다.
const { username, room } = Qs.parse(location.search, {
    ignoreQueryPrefix: true,
});

// Socket.IO 서버와의 연결을 생성합니다.
const socketIO = io("http://localhost:3001");

// // WebSocket 서버와의 연결을 생성합니다.
// const webSocket = new WebSocket('ws://localhost:8888/ws/chat');

// Socket.IO 채팅방에 참여합니다.
socketIO.emit('joinRoom', { username, room });

// Socket.IO 서버로부터 방 정보와 사용자 목록을 받습니다.
socketIO.on('roomUsers', ({ room, users }) => {
    outputRoomName(room); // 방 이름을 DOM에 출력합니다.
    outputUsers(users); // 사용자 목록을 DOM에 출력합니다.
});

// Socket.IO 서버로부터 메시지를 받습니다.
socketIO.on('message', (message) => {
    console.log(message);
    outputMessage(message); // 메시지를 DOM에 출력합니다.

    // 채팅 메시지 영역을 스크롤하여 최신 메시지가 보이도록 합니다.
    chatMessages.scrollTop = chatMessages.scrollHeight;
});

// socket.emit("chat message", {
//     message: $("#message").val(),
//     sender: userId || '익명', // userId가 없을 경우 '익명'으로 설정
// });

// 메시지 전송 폼의 제출 이벤트를 처리합니다.
chatForm.addEventListener('submit', (e) => {
    e.preventDefault(); // 폼의 기본 제출 동작을 막습니다.

    // 입력된 메시지 텍스트를 가져옵니다.
    let msg = e.target.elements.msg.value;

    msg = msg.trim(); // 메시지 양끝의 공백을 제거합니다.

    if (!msg) {
        return false; // 메시지가 비어 있으면 전송을 중단합니다.
    }

    // 서버로 메시지를 전송합니다 (Socket.IO).
    socketIO.emit('chatMessage', msg);

    // WebSocket을 통해 메시지 전송
    const message = {
        roomId: room,
        username: username,  // 로그인된 사용자명으로 설정
        content: msg
    };
    webSocket.send(JSON.stringify(message));

    // 입력 필드를 초기화합니다.
    e.target.elements.msg.value = '';
    e.target.elements.msg.focus(); // 입력 필드에 포커스를 맞춥니다.
});

// WebSocket 서버로부터 메시지를 수신할 때마다 호출
webSocket.onmessage = function(event) {
    const message = JSON.parse(event.data);
    outputMessage(message);
    chatMessages.scrollTop = chatMessages.scrollHeight;
};

// 메시지를 DOM에 출력하는 함수입니다.
function outputMessage(message) {
    const div = document.createElement('div');
    div.classList.add('message');
    const p = document.createElement('p');
    p.classList.add('meta');
    p.innerText = message.username;
    p.innerHTML += `<span>${message.time || new Date().toLocaleTimeString()}</span>`;
    div.appendChild(p);
    const para = document.createElement('p');
    para.classList.add('text');
    para.innerText = message.text || message.content;
    div.appendChild(para);
    document.querySelector('.chat-messages').appendChild(div);
}

// 방 이름을 DOM에 출력하는 함수입니다.
function outputRoomName(room) {
    roomName.innerText = room;
}

// 사용자 목록을 DOM에 출력하는 함수입니다.
function outputUsers(users) {
    userList.innerHTML = '';
    users.forEach((user) => {
        const li = document.createElement('li');
        li.innerText = user.username;
        userList.appendChild(li);
    });
}

// 사용자가 채팅방을 떠나기 전에 확인 메시지를 띄웁니다.
document.getElementById('leave-btn').addEventListener('click', () => {
    const leaveRoom = confirm('채팅방을 떠나시겠습니까?');
    if (leaveRoom) {
        window.location = '../index.html'; // 확인 시, 인덱스 페이지로 이동합니다.
    }
});

// 로그인된 사용자 정보 가져오기
fetch('/login/getSessionUser')
    .then(response => response.json())
    .then(data => {
        const username = data.username;
    });
