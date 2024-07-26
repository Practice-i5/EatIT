
function getAlarmDeatil(alarmId) {

    fetch("/alarm/alarmDetail" + "?alarmId=" + alarmId)
        .then(res => res.json())
        .then(data => {
            const alarmModalLabel = document.getElementById('alarmModalLabel');

            console.log(data);

            alarmModalLabel.innerText = data.meetingName;

        });
}

function getUserImage(userId) {
    fetch("/alarm/userImg" + "?userId=" + userId)
        .then(res => res.json())
        .then(data => {
            const alarmModalLabel = document.getElementById('alarmModalLabel');

            console.log(data);

        });
}

function getMeetingImage(meetingId) {
    fetch("/alarm/meetingImg" + "?meetingId=" + meetingId)
        .then(res => res.json())
        .then(data => {
            const alarmModalLabel = document.getElementById('alarmModalLabel');

            console.log(data);

        });
}