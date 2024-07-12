(function ($) {
    "use strict";

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner(0);


    // Fixed Navbar
    $(window).scroll(function () {
        if ($(window).width() < 992) {
            if ($(this).scrollTop() > 55) {
                $('.fixed-top').addClass('shadow');
            } else {
                $('.fixed-top').removeClass('shadow');
            }
        } else {
            if ($(this).scrollTop() > 55) {
                $('.fixed-top').addClass('shadow').css('top', -55);
            } else {
                $('.fixed-top').removeClass('shadow').css('top', 0);
            }
        } 
    });
    
    
   // Back to top button
   $(window).scroll(function () {
    if ($(this).scrollTop() > 300) {
        $('.back-to-top').fadeIn('slow');
    } else {
        $('.back-to-top').fadeOut('slow');
    }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Testimonial carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 2000,
        center: false,
        dots: true,
        loop: true,
        margin: 25,
        nav : true,
        navText : [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsiveClass: true,
        responsive: {
            0:{
                items:1
            },
            576:{
                items:1
            },
            768:{
                items:1
            },
            992:{
                items:2
            },
            1200:{
                items:2
            }
        }
    });


    // vegetable carousel
    $(".vegetable-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1500,
        center: false,
        dots: true,
        loop: true,
        margin: 25,
        nav : true,
        navText : [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsiveClass: true,
        responsive: {
            0:{
                items:1
            },
            576:{
                items:1
            },
            768:{
                items:2
            },
            992:{
                items:3
            },
            1200:{
                items:4
            }
        }
    });


    // Modal Video
    $(document).ready(function () {
        var $videoSrc;
        $('.btn-play').click(function () {
            $videoSrc = $(this).data("src");
        });
        console.log($videoSrc);

        $('#videoModal').on('shown.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc + "?autoplay=1&amp;modestbranding=1&amp;showinfo=0");
        })

        $('#videoModal').on('hide.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc);
        })
    });



    // Product Quantity
    $('.quantity button').on('click', function () {
        var button = $(this);
        var oldValue = button.parent().parent().find('input').val();
        if (button.hasClass('btn-plus')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        button.parent().parent().find('input').val(newVal);
    });

})(jQuery);

// 프로필 누르는 이벤트 - 메인 관심 개발 분야 목록 페이지
document.querySelector('.heart').addEventListener('click', function() {
    alert('Liked!');
});

document.querySelector('.share').addEventListener('click', function() {
    alert('Shared!');
});

//알림 로그인 회원가입 버튼 부분 - 헤더
document.addEventListener('DOMContentLoaded', function() {
    // 알림 버튼 이벤트
    document.querySelector('.btn-notification').addEventListener('click', function() {
        const notificationDot = this.querySelector('.bg-danger');
        notificationDot.style.display = notificationDot.style.display === 'none' ? 'block' : 'none';
        alert('새 알림이 있습니다.');
    });

    // 로그인 버튼 클릭 시 login.html로 이동
    document.getElementById('loginButton').addEventListener('click', function() {
        window.location.href = 'login.html';
    });

    // 회원가입 버튼 클릭 시 join.html로 이동
    document.getElementById('signupButton').addEventListener('click', function() {
        window.location.href = 'join.html';
    });
});

// main.js 파일 내부
document.addEventListener('DOMContentLoaded', function() {
    // 전체보기 버튼 클릭 이벤트 처리
    document.getElementById('showAllButton').addEventListener('click', function() {
        alert('전체보기 버튼을 클릭했습니다!');
    });
});

//로그인 , 회원가입

// 찜 기능, 하트 버튼
let favorited = false; 

function toggleFavorite(event) {
    event.preventDefault(); // 기본 이벤트(링크 이동) 방지

    favorited = !favorited;
    const heartIcon = document.getElementById('heartIcon');

    if (favorited) {
        heartIcon.classList.remove('far');
        heartIcon.classList.add('fas');
        heartIcon.classList.add('text-danger');
    } else {
        heartIcon.classList.remove('fas');
        heartIcon.classList.remove('text-danger');
        heartIcon.classList.add('far');
    }
}


