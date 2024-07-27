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

// Socket.IO 클라이언트 생성
const socket = io("http://localhost:3001");

// 방에 참여
socket.emit('joinRoom', { username, room });

// 서버로부터 방 정보와 사용자 목록을 받습니다.
socket.on('roomUsers', ({ room, users }) => {
    outputRoomName(room);
    outputUsers(users);
});

// 서버로부터 메시지를 받습니다.
socket.on('message', (message) => {
    console.log(message);
    outputMessage(message);

    // 스크롤을 최신 메시지로 이동
    chatMessages.scrollTop = chatMessages.scrollHeight;
});

// 메시지 전송 폼 제출 이벤트 처리
chatForm.addEventListener('submit', (e) => {
    e.preventDefault();

    // 입력된 메시지 텍스트 가져오기
    const msg = e.target.elements.msg.value;

    // 서버로 메시지 전송
    socket.emit('chatMessage', msg);

    // 입력 필드 초기화
    e.target.elements.msg.value = '';
    e.target.elements.msg.focus();
});

// 방 이름을 DOM에 출력
function outputRoomName(room) {
    roomName.innerText = room;
}

// 사용자 목록을 DOM에 출력
function outputUsers(users) {
    userList.innerHTML = '';
    users.forEach(user => {
        const li = document.createElement('li');
        li.innerText = user.username;
        userList.appendChild(li);
    });
}

// 메시지를 DOM에 출력
function outputMessage(message) {
    const div = document.createElement('div');
    div.classList.add('message');
    div.innerHTML = `<p class="meta">${message.username} <span>${message.time}</span></p>
    <p class="text">${message.text}</p>`;
    chatMessages.appendChild(div);
}
