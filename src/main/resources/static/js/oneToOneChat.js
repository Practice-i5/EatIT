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

// 메시지 전송 폼의 제출 이벤트를 처리합니다.
chatForm.addEventListener('submit', (e) => {
    e.preventDefault(); // 폼의 기본 제출 동작을 막습니다.

    // 입력된 메시지 텍스트를 가져옵니다.
    let msg = e.target.elements.msg.value;

    msg = msg.trim(); // 메시지 양끝의 공백을 제거합니다.

    if (!msg) {
        return false; // 메시지가 비어 있으면 전송을 중단합니다.
    }

    // 서버로 메시지를 전송합니다 (Spring Boot).
    fetch('/send-message', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            room: room,
            message: msg
        })
    }).then(response => {
        if (response.ok) {
            console.log('Message sent to Node.js server and saved to MongoDB');
        } else {
            console.error('Failed to send message');
        }
    });

    // 입력 필드를 초기화합니다.
    e.target.elements.msg.value = '';
    e.target.elements.msg.focus(); // 입력 필드에 포커스를 맞춥니다.
});
