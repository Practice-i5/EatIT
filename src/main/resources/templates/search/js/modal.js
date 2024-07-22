document.addEventListener("DOMContentLoaded", () => {
	const openBtn = document.querySelector('#open');
	const openImg = document.querySelector('#open-img');
	const openSearch = document.querySelector('#open-search');
	const closeBtn = document.querySelector('#close');
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

	window.addEventListener("click", (event) => {
		if (event.target === profileModal) {
			profileModal.classList.remove("active");
		}
	});
});