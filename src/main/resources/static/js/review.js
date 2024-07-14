// 모달 요소와 모달을 여닫는 버튼 요소를 선택
const openModalBtns = document.querySelectorAll('.openModalBtn');
const modals = document.querySelectorAll('.modal');
const submitBtns = document.querySelectorAll('.submit-btn');
const feedbackContainers = document.querySelectorAll('.manager-feedback');

// 각 모달에서 선택된 항목을 저장할 객체
const selectedItems = {};

// 버튼 클릭 시 해당 모달 열기
openModalBtns.forEach((btn, index) => {
    btn.addEventListener('click', () => {
        modals[index].style.display = 'block';
    });
});

// 모달 바깥 영역 클릭 시 모달 닫기
window.onclick = function (event) {
    modals.forEach(modal => {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    });
};

// 모달에서 제출 버튼 클릭 시 처리
submitBtns.forEach((btn, index) => {
    btn.addEventListener('click', function (event) {
        event.preventDefault(); // 기본 동작 방지

        const checkboxes = modals[index].querySelectorAll('.form-checkbox:checked');
        const selectedItemsContainer = feedbackContainers[index].querySelector('.selected-items');
        const modalFeedback = feedbackContainers[index].querySelector('.modal-feedback');

        selectedItemsContainer.innerHTML = ''; // 기존 선택 항목 초기화

        // 선택된 항목들을 저장
        const selectedItemsList = [];
        checkboxes.forEach(checkbox => {
            const labelText = checkbox.nextElementSibling.textContent;
            selectedItemsList.push(labelText);
        });
        selectedItems[index] = selectedItemsList;

        // 모달 닫기
        modals[index].style.display = 'none';

        // 선택한 항목들을 표시
        selectedItemsList.forEach(item => {
            const li = document.createElement('li');
            li.textContent = item;
            selectedItemsContainer.appendChild(li);
        });

        // 선택한 항목들을 평가하기, 신고하기, 차단하기 아래에 표시
        const selectedFeedback = feedbackContainers[index].querySelector('.selected-feedback');
        const modalFeedbackText = modalFeedback.innerHTML;

        selectedFeedback.classList.remove('hidden');
        selectedFeedback.querySelector('.modal-feedback').innerHTML = modalFeedbackText;
    });
});