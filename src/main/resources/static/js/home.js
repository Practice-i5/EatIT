(function ($) {
    "use strict";

    // 스피너 초기화 함수
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();

    // 고정된 네비게이션 바 설정
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

    // 상단으로 이동 버튼 설정
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({ scrollTop: 0 }, 1500, 'easeInOutExpo');
        return false;
    });

    // 후기 캐러셀 설정
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 2000,
        center: false,
        dots: true,
        loop: true,
        margin: 25,
        nav: true,
        navText: [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsiveClass: true,
        responsive: {
            0: {
                items: 1
            },
            576: {
                items: 1
            },
            768: {
                items: 1
            },
            992: {
                items: 2
            },
            1200: {
                items: 2
            }
        }
    });

    // 채소 캐러셀 설정
    $(".vegetable-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1500,
        center: false,
        dots: true,
        loop: true,
        margin: 25,
        nav: true,
        navText: [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsiveClass: true,
        responsive: {
            0: {
                items: 1
            },
            576: {
                items: 1
            },
            768: {
                items: 2
            },
            992: {
                items: 3
            },
            1200: {
                items: 4
            }
        }
    });

    // 모달 비디오 설정
    $(document).ready(function () {
        var $videoSrc;
        $('.btn-play').click(function () {
            $videoSrc = $(this).data("src");
        });

        $('#videoModal').on('shown.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc + "?autoplay=1&amp;modestbranding=1&amp;showinfo=0");
        });

        $('#videoModal').on('hide.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc);
        });
    });

    // 상품 수량 설정
    $('.quantity button').on('click', function () {
        var button = $(this);
        var oldValue = button.parent().parent().find('input').val();
        var newVal;
        if (button.hasClass('btn-plus')) {
            newVal = parseFloat(oldValue) + 1;
        } else {
            newVal = oldValue > 0 ? parseFloat(oldValue) - 1 : 0;
        }
        button.parent().parent().find('input').val(newVal);
    });

})(jQuery);

// 알림, 로그인, 회원가입 버튼 부분 - 헤더
document.addEventListener('DOMContentLoaded', function () {
    // 알림 버튼 이벤트
    document.querySelector('.btn-notification').addEventListener('click', function () {
        const notificationDot = this.querySelector('.bg-danger');
        notificationDot.style.display = notificationDot.style.display === 'none' ? 'block' : 'none';
        alert('새 알림이 있습니다.');
    });

    // 로그인 버튼 클릭 시 login.html로 이동
    document.getElementById('loginButton').addEventListener('click', function () {
        window.location.href = 'login.html';
    });

    // 회원가입 버튼 클릭 시 join.html로 이동
    document.getElementById('signupButton').addEventListener('click', function () {
        window.location.href = 'join.html';
    });
});

// 찜하기 버튼 클릭 시 상태 변경 및 페이지 이동
function toggleFavorite(event) {
    event.preventDefault(); // 기본 이벤트(링크 이동) 방지

    const heartIcon = event.target;

    if (heartIcon.classList.contains('far')) {
        heartIcon.classList.remove('far');
        heartIcon.classList.add('fas');
    } else {
        heartIcon.classList.remove('fas');
        heartIcon.classList.add('far');
    }

    // 찜하기 클릭 시 like-page로 이동
    window.location.href = 'like-page.html';
}

// 공유 버튼 클릭 시 링크 공유
function shareContent(event) {
    event.preventDefault(); // 기본 이벤트(링크 이동) 방지

    const url = window.location.href;
    if (navigator.share) {
        navigator.share({
            title: '체험 공유',
            url: url
        }).catch(console.error);
    } else {
        alert('공유 기능을 지원하지 않는 브라우저입니다.');
    }
}

// 채팅 버튼 스크롤에 따라 움직이도록 설정
window.addEventListener('scroll', function () {
    const chatButton = document.querySelector('.chat-button');
    const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    chatButton.style.top = `${20 + scrollTop}px`;
});

// Initialize Bootstrap tooltips if needed
var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl);
});
