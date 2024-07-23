

const alarm_badge = document.getElementById('alarm-badge')

switchAlarmBadge();

function switchAlarmBadge(){

    if (isAlarmExist() === "true"){
        alarm_badge.style.visibility = "visible";
    }else {
        alarm_badge.style.visibility = "hidden"
    }

}

function isAlarmExist(){
    let receive;
    const alarmCheckElement = document.getElementById('alarmCheck');
    receive = alarmCheckElement.innerText;
    return receive;
}
