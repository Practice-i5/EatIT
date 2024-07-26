
function getAlarmDeatil(alarmId) {
    console.log(alarmId);

    fetch("/alarm/alarmDetail" + "?alarmId=" + alarmId)
        .then(res => res.json())
        .then(data => {
            // console.log(data);
            const memberName = document.getElementById('alarm-userName');
            memberName.innerText = data.memberName;
            const meetingName = document.getElementById('alarm-meetingName');
            meetingName.innerText = data.meetingName;
            const alarmDetail = document.getElementById('alarm-detail-introduce');
            alarmDetail.innerText = data.alarmDetail;
            const accptBtn = document.getElementById('accept_btn');
            accptBtn.addEventListener('click', ev => {
                location.href="accept" + "?alarmId=" + alarmId
            })
            const refuseBtn = document.getElementById('refuse_btn');
            refuseBtn.addEventListener('click', ev => {
                location.href="refuse" + "?alarmId=" + alarmId
            })
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
