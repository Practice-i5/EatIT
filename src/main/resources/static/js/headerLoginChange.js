
document.addEventListener('DOMContentLoaded', function () {
    // 서버에서 세션 사용자 정보를 가져오는 함수
    function getSessionUser() {
        return fetch('/login/getSessionUser', {
            method: 'GET',
            credentials: 'include', // 세션 정보를 포함하여 요청
        })
            .then(response => response.json())
            .then(data => data)
            .catch(error => {
                console.error('Error:', error);
                return null;
            });
    }

    async function updateButtons() {
        const loginButton = document.getElementById('loginButton');
        const signupButton = document.getElementById('signupButton');

        const user = await getSessionUser();

        if (user && user.email) { // 로그인한 사용자가 있을 경우
            loginButton.textContent = '로그아웃';
            loginButton.setAttribute('href', '/login/logout'); // 로그아웃 URL로 업데이트
            signupButton.textContent = '마이페이지';
            signupButton.setAttribute('href', '/my-page'); // 마이페이지 URL로 업데이트
        } else { // 로그인한 사용자가 없을 경우
            loginButton.textContent = '로그인';
            loginButton.setAttribute('href', '/login/loginMain');
            signupButton.textContent = '회원가입';
            signupButton.setAttribute('href', '/login/join');
        }
    }

    updateButtons();

    // 알림 버튼 이벤트
    document.querySelector('.btn-notification').addEventListener('click', function () {
        const notificationDot = this.querySelector('.notification-dot');
        notificationDot.style.display = notificationDot.style.display === 'none' ? 'block' : 'none';
        alert('새 알림이 있습니다.');
    });

    // 로그인 버튼 클릭 시 login.html로 이동
    document.getElementById('loginButton').addEventListener('click', function (event) {
        if (this.textContent === '로그아웃') {
            event.preventDefault();
            fetch('/login/logout', {
                method: 'GET',
                credentials: 'include', // 세션 정보를 포함하여 요청
            })
                .then(() => {
                    localStorage.removeItem('isLoggedIn');
                    window.location.href = '/';
                })
                .catch(error => console.error('Error:', error));
        }
    });

    // 회원가입 버튼 클릭 시 join.html로 이동
    document.getElementById('signupButton').addEventListener('click', function () {
        if (this.textContent !== '마이페이지') {
            window.location.href = '/login/join';
        } else {
            window.location.href = '/my-page'; // 실제 마이페이지 URL로 업데이트
        }
    });
});
