
function getAlarmDeatil(alarmId) {
    // console.log(alarmId);

    fetch("/alarm/alarmDetail" + "?alarmId=" + alarmId)
        .then(res => res.json())
        .then(data => {
            // console.log(data);
            const memberName = document.getElementById('alarm-userName');
            memberName.innerText = data.memberName;
            const meetingName = document.getElementById('alarm-meetingName');
            meetingName.innerText = data.meetingName + "에 참가신청 하셨습니다";
            const alarmDetail = document.getElementById('alarm-detail-introduce');
            alarmDetail.innerText = data.alarmDetail;

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