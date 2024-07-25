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

document.addEventListener('DOMContentLoaded', function() {
    // 초기 상태에서 1대1 채팅을 보이도록 설정
    document.querySelector('#1on1chat').style.display = 'block';
    document.querySelector('#groupChat').style.display = 'none';
});

/**
 * 클릭시 1대1채팅, 단톡방 오픈
 */
document.querySelectorAll('.chat-toggle').forEach(function(item) {
    item.addEventListener('click', function(e) {
        e.preventDefault();
        const target = this.dataset.target;

        // 모든 chat-content를 숨김
        document.querySelectorAll('.chat-content').forEach(function(content) {
            content.style.display = 'none';
        });

        // 선택된 chat-content를 표시
        const targetElement = document.querySelector(target);
        if (targetElement) {
            targetElement.style.display = 'block';
        }

        // 1대1 채팅 버튼을 클릭했을 때 초기 상태로 설정

    });
});

