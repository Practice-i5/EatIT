
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
            });
            const refuseBtn = document.getElementById('refuse_btn');
            refuseBtn.addEventListener('click', ev => {
                location.href="refuse" + "?alarmId=" + alarmId
            });
            getUserImage(data.memberId);
        });
}

function getUserImage(userId) {
    fetch("/alarm/userImg" + "?userId=" + userId)
        .then(res => res.json())
        .then(data => {
            const alarmModalLabel = document.getElementById('user-profile-image');

            // console.log(data.photoPath);
            alarmModalLabel.src = data.photoPath;

        });
}

function getMeetingImage(meetingId) {
    console.log(meetingId)
    const elementId = 'target_meeting_img_' + meetingId
    fetch("/alarm/meetingImg" + "?meetingId=" + meetingId)
        .then(res => res.json())
        .then(data => {
            const meetingImg = document.getElementById(elementId);

            console.log(data);
            meetingImg.src = data.photoPath;

        });
}
