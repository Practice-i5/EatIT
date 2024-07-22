let offset = 0;
const limit = 5;
let isLoading = false;

function loadAlarms() {
    if (isLoading) return;
    isLoading = true;
    $('#loading').show();

    $.get('/alarms', { offset: offset, limit: limit }, function(data) {
        if (data.length > 0) {
            data.forEach(function(alarm) {
                $('#alarm-container').append('<div class="alarm">' + alarm + '</div>');
            });
            offset += limit;
        }
        isLoading = false;
        $('#loading').hide();
    });
}

$(window).scroll(function() {
    if ($(window).scrollTop() + $(window).height() >= $(document).height() - 100) {
        loadAlarms();
    }
});

$(document).ready(function() {
    loadAlarms();
});