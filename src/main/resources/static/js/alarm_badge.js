

const alarm_badge = document.getElementById('alarm-badge')

// switchAlarmBadge();
alarmCheckFetch();

// function switchAlarmBadge(){
//     const isAlarmExist = alarmCheckFetch();
//     console.log(isAlarmExist);
//     if (isAlarmExist === "true"){
//         console.log("visible")
//         alarm_badge.style.visibility = "visible";
//     }else {
//         console.log("hidden")
//         alarm_badge.style.visibility = "hidden"
//     }
//
// }

// function isAlarmExist(){
//     let receive;
//     const alarmCheckElement = document.getElementById('alarmCheck');
//     receive = alarmCheckElement.innerText;
//     // console.log(receive);
//     return receive;
// }

function  alarmCheckFetch() {
    fetch("/alarm/alarmCheck")
        .then(res => res.json())
        .then(data => {
            if (data.toString() === "true"){
                // console.log("visible")
                alarm_badge.style.visibility = "visible";
            }else {
                // console.log("hidden")
                alarm_badge.style.visibility = "hidden"
            }
        }).catch(err =>{
            console.log(err)
    })
}