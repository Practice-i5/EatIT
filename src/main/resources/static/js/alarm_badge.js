

const alarm_badge = document.getElementById('alarm-badge')
console.log(alarm_badge);

let isBadgeVisible = false;
controlAlarmBadge();


function controlAlarmBadge(){
    if (isBadgeVisible){    //true
        alarm_badge.style.visibility = "visible";
    }else {                 //false
        alarm_badge.style.visibility = "hidden"
    }

}