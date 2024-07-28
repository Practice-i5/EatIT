const openBtn = document.querySelector('#add-experience');
const closeBtn = document.querySelector('#close');
const profileModal = document.querySelector('#profile-modal');
const addBtn = document.querySelector('#experience-submit');
const companyName = document.querySelector('#companyName');
const startTime = document.querySelector('#employ-start');
const endTime = document.querySelector('#employ-end');
const experienceDescription = document.querySelector('#experience-desc')
const isEmploy = document.querySelector('#is-employ');
const modalError = document.querySelector('#modal-error');
const modalForm = document.querySelector("#tech-experience-form");
const modalNum= document.querySelector("#modal-num");

function openModal(experienceObj) {

    let now_utc = Date.now()
    let timeOff = new Date().getTimezoneOffset()*60000;
    let today = new Date(now_utc-timeOff).toISOString().split("T")[0];
    console.log(today);
    startTime.setAttribute("max", today);
    endTime.setAttribute("max", today);

    profileModal.classList.add("active");
    console.log(experienceObj);
    if(experienceObj!=null){
        modalNum.value=experienceObj.experienceId;
        if(experienceObj.endDate ==null){
            endTime.disabled=true;
            isEmploy.checked=true;
        } else{
            endTime.value=experienceObj.endDate;
        }
        companyName.value=experienceObj.companyName;
        startTime.value=experienceObj.startDate;
        experienceDescription.value = experienceObj.description;
    }

}

openBtn.addEventListener("click", () => {
        profileModal.classList.add("active");
    });

closeBtn.addEventListener("click", () => {
    closeModal();
    });

addBtn.addEventListener("click", () => {
    console.log(startTime.value)
    console.log(endTime.value)
    console.log(`모달익스아이디: ${modalForm.experienceId}`);
    if(endTime.value!=null && endTime.value!=''){

        if(startTime=='' || startTime.value>endTime.value){
            modalError.textContent="올바른 날짜를 입력해주세요";
            return;
        } else{
            modalError.textContent="변한건 변했는데";
        }
    } else if(!isEmploy.checked){
        modalError.textContent="올바른 날짜를 입력해주세요";
        return;
    }

    if(!modalForm.experienceId || modalForm.experienceId==''){
        console.log(modalNum.value);
        modalForm.experienceId=null;

    }
    modalForm.submit();
});

isEmploy.addEventListener("click", ()=>{
        if(!endTime.disabled){
            endTime.value=null;
        }
        endTime.disabled = !endTime.disabled;
} );

window.addEventListener("click", (event) => {
        if (event.target === profileModal) {
            closeModal();
        }
    });

function closeModal(){
    companyName.value=null;
    startTime.value=null;
    endTime.value=null;
    isEmploy.value=null;
    experienceDescription.value=null;
    modalNum.value=null;
    profileModal.classList.remove("active");
}