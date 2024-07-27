
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
    const elementId = 'target_meeting_img_' + meetingId
    // console.log(elementId);
    // fetch("/alarm/meetingImg" + "?meetingId=" + meetingId)
    //     .then(res => {
    //         console.log(res);
    //         res.json()
    //
    //     })
    //     .then(data => {
    //         console.log(data);
    //
    //         const meetingImg = document.getElementById(elementId);
    //         console.log(meetingImg)
    //         meetingImg.src = data.photoPath;
    //
    //     });

    // fetch("/alarm/meetingImg" + "?meetingId=" + meetingId)
    //     .then(res => {
    //         if (!response.ok) {
    //             throw new Error('Network response was not ok');
    //         }
    //         return response.json();
    //
    //     })
    //     .then(data => {
    //         console.log(data); // 각 fetch 요청의 결과를 배열로 출력
    //     })
    //     .catch(error =>{
    //         console.error('Fetch error', error)
    //     })
}

function getMeetingImages(meetingIdList){
    // console.log(meetingIdList)
    fetch("/alarm/meetingImgs" + "?meetingIdList=" + meetingIdList)
        .then(res => res.json())
        .then(data => {
            // console.log(data);
            for (const meetingId of meetingIdList){
                const meetingImg =
                    document.getElementsByClassName('target_meeting_img_' + meetingId);
                // console.log(meetingImg);
                for (const meetingImgElement of meetingImg) {
                    meetingImgElement.src = data[meetingId];
                }
            }

        });
}