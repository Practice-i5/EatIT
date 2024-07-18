const openBtn = document.querySelector('#add-experience');
const closeBtn = document.querySelector('#close');
const profileModal = document.querySelector('#profile-modal');
const addBtn = document.querySelector('#experience-submit');
const endTime = document.querySelector('#employ-end');
const isEmploy = document.querySelector('#is-employ');    

openBtn.addEventListener("click", () => {
        profileModal.classList.add("active");
    });

closeBtn.addEventListener("click", () => {
        profileModal.classList.remove("active");
    });

addBtn.addEventListener("click", () => {
        profileModal.classList.remove("active");
    });

isEmploy.addEventListener("click", ()=>{
        endTime.disabled = !endTime.disabled;
} );

window.addEventListener("click", (event) => {
        if (event.target === profileModal) {
            profileModal.classList.remove("active");
        }
    });