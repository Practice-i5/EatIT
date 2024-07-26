let uploadedFiles = [];

document.getElementById('file-input').addEventListener('change', function(event) {
    const newFiles = Array.from(event.target.files);
    const totalFiles = uploadedFiles.length + newFiles.length;

    const fileCountDisplay = document.getElementById('file-count');
    const imagePreview = document.getElementById('image-preview');
    const submitButton = document.getElementById('submit-button');

    if (totalFiles > 1) {
        alert('1개의 이미지만 업로드할 수 있습니다.');
        event.target.value = ''; // 입력 초기화
        return;
    }

    uploadedFiles = uploadedFiles.concat(newFiles);

    fileCountDisplay.textContent = `${uploadedFiles.length}/1`;

    // 기존 이미지를 초기화
    imagePreview.innerHTML = '';

    // 업로드된 이미지 표시
    uploadedFiles.forEach((file, index) => {
        const reader = new FileReader();
        reader.onload = function(e) {
            const imgContainer = document.createElement('div');
            imgContainer.classList.add('image-container');

            const img = document.createElement('img');
            img.src = e.target.result;
            imgContainer.appendChild(img);

            const removeButton = document.createElement('button');
            removeButton.classList.add('remove-button');
            removeButton.innerHTML = '&times;';
            removeButton.addEventListener('click', function() {
                uploadedFiles.splice(index, 1);
                updateImagePreview();
            });
            imgContainer.appendChild(removeButton);

            imagePreview.appendChild(imgContainer);
        };
        reader.readAsDataURL(file);
    });

    // 입력 필드 초기화
    event.target.value = '';

    submitButton.disabled = uploadedFiles.length === 0;
});

function updateImagePreview() {
    const fileCountDisplay = document.getElementById('file-count');
    const imagePreview = document.getElementById('image-preview');
    const submitButton = document.getElementById('submit-button');

    fileCountDisplay.textContent = `${uploadedFiles.length}/5`;
    imagePreview.innerHTML = '';

    uploadedFiles.forEach((file, index) => {
        const reader = new FileReader();
        reader.onload = function(e) {
            const imgContainer = document.createElement('div');
            imgContainer.classList.add('image-container');

            const img = document.createElement('img');
            img.src = e.target.result;
            imgContainer.appendChild(img);

            const removeButton = document.createElement('button');
            removeButton.classList.add('remove-button');
            removeButton.innerHTML = '&times;';
            removeButton.addEventListener('click', function() {
                uploadedFiles.splice(index, 1);
                updateImagePreview();
            });
            imgContainer.appendChild(removeButton);

            imagePreview.appendChild(imgContainer);
        };
        reader.readAsDataURL(file);
    });

    submitButton.disabled = uploadedFiles.length === 0;
}

// script.js
document.addEventListener('DOMContentLoaded', () => {
    const input1 = document.getElementById('hashtag-input1');
    const input2 = document.getElementById('hashtag-input2');
    const hashtagsContainer1 = document.getElementById('hashtags1');
    const hashtagsContainer2 = document.getElementById('hashtags2');
    const hashtags1 = [];
    const hashtags2 = [];

    // 입력 창1 이벤트 리스너
    input1.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            const tagText = input1.value.trim();
            if (tagText && !hashtags1.includes(tagText)) {
                hashtags1.push(tagText);
                input1.value = '';
                renderHashtags(hashtags1, hashtagsContainer1);
            }
        }
    });

    // 입력 창2 이벤트 리스너
    input2.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            const tagText = input2.value.trim();
            if (tagText && !hashtags2.includes(tagText)) {
                hashtags2.push(tagText);
                input2.value = '';
                renderHashtags(hashtags2, hashtagsContainer2);
            }
        }
    });

    function renderHashtags(hashtags, container) {
        container.innerHTML = '';
        hashtags.forEach((tag, index) => {
            const tagElement = document.createElement('span');
            tagElement.classList.add('hashtag');
            tagElement.textContent = tag;
            
            const closeElement = document.createElement('span');
            closeElement.textContent = 'x';
            closeElement.classList.add('close');
            closeElement.addEventListener('click', () => {
                removeHashtag(index, hashtags, container);
            });

            tagElement.appendChild(closeElement);
            container.appendChild(tagElement);
        });
    }

    function removeHashtag(index, hashtags, container) {
        hashtags.splice(index, 1);
        renderHashtags(hashtags, container);
    }
});


// 지도추가
// script.js
let map;
let marker;
let geocoder;
let autocomplete;

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: 37.515133, lng: 127.734086 },
        zoom: 8
    });

    geocoder = new google.maps.Geocoder();

    map.addListener('click', function(event) {
        placeMarkerAndPanTo(event.latLng);
    });
    autocomplete = new google.maps.places.Autocomplete(document.getElementById('meeting-place'));
    autocomplete.addListener('place_changed', onPlaceChanged);

    document.getElementById('meeting-place').addEventListener('keydown', function(event) {
        if (event.key === 'Enter') {
            event.preventDefault();
        }
    });
}

function placeMarkerAndPanTo(latLng) {
    if (marker) {
        marker.setPosition(latLng);
    } else {
        marker = new google.maps.Marker({
            position: latLng,
            map: map
        });
    }
    map.panTo(latLng);
    getPlaceName(latLng);
    document.getElementById('locationLatitude').value = latLng.lat();
    document.getElementById('locationLongitude').value = latLng.lng();
}

function getPlaceName(latLng) {
    geocoder.geocode({ 'location': latLng }, function(results, status) {
        if (status === 'OK') {
            if (results[0]) {
                var placeName = results[0].formatted_address;
                document.getElementById('meeting-place').value = placeName;
            } else {
                console.log('No results found');
            }
        } else {
            console.log('Geocoder failed due to: ' + status);
        }
    });
}

function onPlaceChanged() {
    var place = autocomplete.getPlace();
    if (!place.geometry) {
        console.log("No details available for input: '" + place.name + "'");
        return;
    }

    // If the place has a geometry, then present it on a map.
    if (place.geometry.viewport) {
        map.fitBounds(place.geometry.viewport);
    } else {
        map.setCenter(place.geometry.location);
        map.setZoom(17);
    }

    placeMarkerAndPanTo(place.geometry.location);
}

document.addEventListener('DOMContentLoaded', () => {
    const meetingPlaceInput = document.getElementById('meeting-place');
    const mapElement = document.getElementById('map');
    const showMapButton = document.getElementById('show-map-button');

    showMapButton.addEventListener('click', () => {
        mapElement.style.display = 'block';
        google.maps.event.trigger(map, 'resize'); // 지도 크기 변경 후 재조정
        map.setCenter({ lat: 37.515133, lng: 127.734086 }); // 지도의 중심을 재설정
    });

    initMap();
});
