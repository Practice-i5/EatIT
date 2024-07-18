function uploadImageManage(){
    const fileDOM = document.querySelector('#img-file');
    const preview = document.querySelector('#img-preview');

    uploadImagePreview(fileDOM, preview);
    uploadImageReset(preview);
}

function uploadImagePreview(fileDOM, preview){
    fileDOM.addEventListener('change', () => {
    const reader = new FileReader();
    reader.onload = ({ target }) => {
        preview.src = target.result;
        console.log("이미지 파일 읽음")
    };
    reader.readAsDataURL(fileDOM.files[0]);
    });
}

function uploadImageReset(preview){
    const DEFAULT_PROFILE_IMG = 'https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg';
    const imgResetBtn = document.querySelector('.reset-img');

    imgResetBtn.addEventListener('click', function(event){
        if (event.preventDefault) event.preventDefault();
        preview.src = DEFAULT_PROFILE_IMG;
        console.log('이미지 초기화 성공');
    });
}

uploadImageManage();