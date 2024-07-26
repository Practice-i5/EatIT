const openImg = document.querySelector('#open-img');
const openSearch = document.querySelector('#open-search');
const prfCloseBtn = document.querySelector('#profile-close');
const profileModal = document.querySelector('#profile-modal');
const openRct = document.querySelector('#open-rct');
const rctCloseBtn = document.querySelector('#recruit-close');
const rctModal = document.querySelector('#recruit-modal');


openImg.addEventListener("click", () => {
    profileModal.classList.add("active");
});

openSearch.addEventListener("click", () => {
    profileModal.classList.add("active");
});

prfCloseBtn.addEventListener("click", () => {
    profileModal.classList.remove("active");
});

openRct.addEventListener("click", () => {
    rctModal.classList.add("active");
});

rctCloseBtn.addEventListener("click", () => {
    rctModal.classList.remove("active");
});


// function toggleReportBtns() {
//
//     const btns = document.getElementsByClassName("report-button");
//
//     if (btns[0].style.display !== "none") {
//         btns[0].style.display = "none"
//     } else {
//         btns[0].style.display = "flex"
//     }
//
//     if (btns[1].style.display !== "none") {
//         btns[1].style.display = "none"
//     } else {
//         btns[1].style.display = "flex"
//     }
// }