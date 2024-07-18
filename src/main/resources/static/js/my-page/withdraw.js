let withdrawQuest = document.querySelector("#withdraw-quest");
let withdrawDone = document.querySelector("#withdraw-done");
let withdrawSubmit = document.querySelector("#withdraw-submit");

withdrawSubmit.addEventListener("click" ,()=>{
    withdrawDone.classList.remove("unactive");
    withdrawQuest.classList.add("unactive");
})

