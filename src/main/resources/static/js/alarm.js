
function getAlarmDeatil(alarmId) {

    fetch("/alarmDetail" + "?memberId=" + alarmId)
        .then(res => res.json())
        .then(data => {
            const alarmModalLabel = document.getElementById('alarmModalLabel');

            alarmModalLabel.innerText = data;

        });
}
