const chatNamespace = io("/chat", {
    auth: {
        token: 123456,
    },
});


// Query DOM
const messageInput = document.getElementById("messageInput");
const chatForm = document.getElementById("chatForm");
const chatBox = document.getElementById("chat-box");
const feedback = document.getElementById("feedback");
const onlineUsers = document.getElementById("online-users-list");
const chatContainer = document.getElementById("chatContainer");






// start: Sidebar
/**
 * 왼쪽 하단 클릭하면
 */
document.querySelector('.chat-sidebar-profile-toggle').addEventListener('click', function(e) {
    e.preventDefault();
    this.parentElement.classList.toggle('active');
});

document.addEventListener('click', function(e) {
    if(!e.target.matches('.chat-sidebar-profile, .chat-sidebar-profile *')) {
        document.querySelector('.chat-sidebar-profile').classList.remove('active');
    }
});
// end: Sidebar

// start: Conversation
/**
 * 클릭시 delete, forward toggle activce기능
 */
document.querySelectorAll('.conversation-item-dropdown-toggle').forEach(function(item) {
    item.addEventListener('click', function(e) {
        e.preventDefault();
        if(this.parentElement.classList.contains('active')) {
            this.parentElement.classList.remove('active');
        } else {
            document.querySelectorAll('.conversation-item-dropdown').forEach(function(i) {
                i.classList.remove('active');
            });
            this.parentElement.classList.add('active');
        }
    });
});

/**
 * 외부를 클릭 시 delete, forward toggle deactivce기능
 */
document.addEventListener('click', function(e) {
    if(!e.target.matches('.conversation-item-dropdown, .conversation-item-dropdown *')) {
        document.querySelectorAll('.conversation-item-dropdown').forEach(function(i) {
            i.classList.remove('active');
        });
    }
});

/**
 * 텍스트 입력 시 행 조절
 */
document.querySelectorAll('.conversation-form-input').forEach(function(item) {
    item.addEventListener('input', function() {
        this.rows = this.value.split('\n').length;
    });
});

/**
 * 클릭시 대화 오픈
 */
document.querySelectorAll('[data-conversation]').forEach(function(item) {
    item.addEventListener('click', function(e) {
        e.preventDefault();
        document.querySelectorAll('.conversation').forEach(function(i) {
            i.classList.remove('active');
        });
        document.querySelector(this.dataset.conversation).classList.add('active');
    });
});

/**
 * 클릭시 대화 close
 */
document.querySelectorAll('.conversation-back').forEach(function(item) {
    item.addEventListener('click', function(e) {
        e.preventDefault();
        this.closest('.conversation').classList.remove('active');
        document.querySelector('.conversation-default').classList.add('active');
    });
});
// end: Conversation


/**
 * 클릭시 1대1채팅, 단톡방 오픈
 */
// document.querySelectorAll('.chat-toggle').forEach(function(item) {
//     item.addEventListener('click', function(e) {
//         e.preventDefault();
//         const target = this.dataset.target;
//
//         // 모든 chat-content를 숨김
//         document.querySelectorAll('.chat-content').forEach(function(content) {
//             content.style.display = 'none';
//         });
//
//         // 선택된 chat-content를 표시
//         const targetElement = document.querySelector(target);
//         if (targetElement) {
//             targetElement.style.display = 'block';
//         }
//
//         // 1대1 채팅 버튼을 클릭했을 때 초기 상태로 설정
//
//     });
// });

// *******************************************************서버로부터의 이벤트 리스닝

chatNamespace.on("chat message", (data) => {
    feedback.innerHTML = "";
    chatBox.innerHTML += `<li class="conversation-item-wrapper">
                      <div class="conversation-item-box">
                        <div class="conversation-item-text">
                          <p>
                            ${data.message}  <!--보내는 메세지 -->
                          </p>
                          <div class="conversation-item-time">${data.date}</div><!--보내는 시간 -->
                        </div>
                        <div class="conversation-item-dropdown">
                          <button
                                  type="button"
                                  class="conversation-item-dropdown-toggle"
                          >
                            <i class="ri-more-2-line"></i>
                          </button>
                          <ul class="conversation-item-dropdown-list">
                            <li>
                              <a href="#"
                              ><i class="ri-share-forward-line"></i>
                                Forward</a
                              >
                            </li>
                            <li>
                              <a href="#"
                              ><i class="ri-delete-bin-line"></i> Delete</a
                              >
                            </li>
                          </ul>
                        </div>
                      </div>
                    </li>`;
    chatContainer.scrollTop =
        chatContainer.scrollHeight - chatContainer.clientHeight;
});

//*******************************************************타이핑 이벤트
messageInput.addEventListener("keypress", (e) => {
    chatNamespace.emit("typing", { name: nickname, roomNumber });
});

chatNamespace.on("typing", (data) => {
    if (roomNumber == data.roomNumber) {
        feedback.innerHTML = data;
    }
});

//*******************************************************공용 채팅 메시지 전송 이벤트
chatForm.addEventListener("submit", (e) => {
    e.preventDefault();
    if (messageInput.value) {
        chatNamespace.emit("chat message", {
            message: messageInput.value,
            nickname,
            roomNumber,
        });
        messageInput.value = "";
    }
});