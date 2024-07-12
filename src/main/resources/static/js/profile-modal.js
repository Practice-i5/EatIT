const openBtn = document.querySelector('#open-profile');
const openImg = document.querySelector('#open-profile-img');
const openSearch = document.querySelector('#open-profile-search');
const closeBtn = document.querySelector('#profile-close');
const profileModal = document.querySelector('#profile-modal');

openBtn.addEventListener("click", () => {
	profileModal.classList.add("active");
});
openImg.addEventListener("click", () => {
	profileModal.classList.add("active");
});
openSearch.addEventListener("click", () => {
	profileModal.classList.add("active");
});
closeBtn.addEventListener("click", () => {
	profileModal.classList.remove("active");
});