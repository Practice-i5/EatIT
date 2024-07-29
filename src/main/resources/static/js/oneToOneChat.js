const chatForm = document.getElementById('chat-form');
const chatMessages = document.querySelector('.chat-messages');
const roomName = document.getElementById('room-name');
const userList = document.getElementById('users');
const leaveButton = document.getElementById('leave-btn'); // 방 나가기 버튼 요소 추가

const { username, room } = Qs.parse(location.search, {
    ignoreQueryPrefix: true
});

// Socket.IO 서버 URL 설정
const nodeServerUrl = "http://192.168.0.30:3001";

// Socket.IO 클라이언트 생성
const socket = io(nodeServerUrl);

socket.emit('joinRoom', { username, room });

socket.on('roomUsers', ({ room, users }) => {
    outputRoomName(room);
    outputUsers(users);
});

socket.on('message', (message) => {
    outputMessage(message);
    chatMessages.scrollTop = chatMessages.scrollHeight;
});

chatForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const msg = e.target.elements.msg.value;
    const chatMessage = {
        username,
        room,
        message: msg
    };

    fetch('/onechatroom/send-message', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(chatMessage)
    })
        .then(response => response.json())
        .then(data => {
            if (data.message) {
                socket.emit('chatMessage', msg);
                e.target.elements.msg.value = '';
                e.target.elements.msg.focus();
            } else {
                console.error('Error sending message:', data.error);
            }
        })
        .catch(error => console.error('Error sending message:', error));
});

leaveButton.addEventListener('click', () => {
    const leaveRoom = confirm('채팅방을 떠나시겠습니까?');
    if (leaveRoom) {
        window.location = '/onechatroom/chat-index'; // 홈으로 리디렉션
    }
});

function outputMessage(message) {
    const div = document.createElement('div');
    div.classList.add('message');
    div.innerHTML = `<p class="meta">${message.username} <span>${message.time}</span></p>
  <p class="text">${message.text}</p>`;
    document.querySelector('.chat-messages').appendChild(div);
}

function outputRoomName(room) {
    roomName.innerText = room;
}

function outputUsers(users) {
    userList.innerHTML = '';
    users.forEach(user => {
        const li = document.createElement('li');
        li.innerText = user.username;
        userList.appendChild(li);
    });
}
