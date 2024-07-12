const openBtn = document.querySelector('#open-review');
const openImg = document.querySelector('#open-review-img');
const openSearch = document.querySelector('#open-review-search');
const closeBtn = document.querySelector('#review-close');
const reviewModal = document.querySelector('#review-modal');

openBtn.addEventListener("click", () => {
	reviewModal.classList.add("active");
});
openImg.addEventListener("click", () => {
	reviewModal.classList.add("active");
});
openSearch.addEventListener("click", () => {
	reviewModal.classList.add("active");
});
closeBtn.addEventListener("click", () => {
	reviewModal.classList.remove("active");
});