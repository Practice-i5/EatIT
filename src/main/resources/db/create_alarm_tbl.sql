DROP TABLE IF EXISTS `tbl_alarm`;

CREATE TABLE `tbl_alarm`
(
    `alarm_id`    INT NOT NULL auto_increment COMMENT '알림번호',
    `alarm_detail`    VARCHAR(255) NOT NULL COMMENT '알림내용',
    `alarm_date`    DATETIME NOT NULL COMMENT '생성날짜',
    `member_id`    INT NOT NULL COMMENT '회원번호',
    `participation_id`    INT NOT NULL COMMENT '참여번호',
    `alarm_status`    VARCHAR(12) COMMENT '상태',
    `alarm_checked`    BOOLEAN COMMENT '확인여부',
    PRIMARY KEY ( `alarm_id` )
) COMMENT = '알람';

INSERT INTO `tbl_alarm` (`alarm_id`, `alarm_detail`, `alarm_date`, `member_id`, `participation_id`, `alarm_status`, `alarm_checked`)
VALUES
    (1, '참가신청', '2023-07-01 12:00:00', 1, 1, '승인대기', true),
    (2, '참가신청', '2023-07-02 12:00:00', 2, 2, '승인', true),
    (3, '참가신청', '2023-07-03 12:00:00', 3, 3, '거절', true),
    (4, '참가신청', '2023-07-04 12:00:00', 4, 4, '승인대기', true),
    (5, '참가신청', '2023-07-05 12:00:00', 5, 5, '승인', true),
    (6, '참가신청', '2023-07-06 12:00:00', 6, 6, '거절', true),
    (7, '참가신청', '2023-07-07 12:00:00', 7, 7, '승인대기', true),
    (8, '참가신청', '2023-07-08 12:00:00', 1, 8, '승인', true),
    (9, '참가신청', '2023-07-09 12:00:00', 2, 9, '거절', true),
    (10, '참가신청', '2023-07-10 12:00:00', 3, 10, '승인대기', true),
    (11, '참가신청', '2023-07-11 12:00:00', 4, 1, '승인', false),
    (12, '참가신청', '2023-07-12 12:00:00', 5, 2, '거절', false),
    (13, '참가신청', '2023-07-13 12:00:00', 6, 3, '승인대기', false),
    (14, '참가신청', '2023-07-14 12:00:00', 7, 4, '승인', false),
    (15, '참가신청', '2023-07-15 12:00:00', 1, 5, '거절', false),
    (16, '참가신청', '2023-07-16 12:00:00', 2, 6, '승인대기', false),
    (17, '참가신청', '2023-07-17 12:00:00', 3, 7, '승인', false),
    (18, '참가신청', '2023-07-18 12:00:00', 4, 8, '거절', false),
    (19, '참가신청', '2023-07-19 12:00:00', 5, 9, '승인대기', false),
    (20, '참가신청', '2023-07-20 12:00:00', 6, 10, '승인', false),
    (21, '참가신청', '2023-07-21 12:00:00', 7, 1, '거절', false),
    (22, '참가신청', '2023-07-22 12:00:00', 1, 2, '승인대기', false),
    (23, '참가신청', '2023-07-23 12:00:00', 2, 3, '승인', false),
    (24, '참가신청', '2023-07-24 12:00:00', 3, 4, '거절', false),
    (25, '참가신청', '2023-07-25 12:00:00', 4, 5, '승인대기', false),
    (26, '참가신청', '2023-07-26 12:00:00', 5, 6, '승인', false),
    (27, '참가신청', '2023-07-27 12:00:00', 6, 7, '거절', false),
    (28, '참가신청', '2023-07-28 12:00:00', 7, 8, '승인대기', false),
    (29, '참가신청', '2023-07-29 12:00:00', 1, 9, '승인', false),
    (30, '참가신청', '2023-07-30 12:00:00', 2, 10, '거절', false),
    (31, '참가신청', '2023-07-31 12:00:00', 3, 1, '승인대기', false),
    (32, '참가신청', '2023-08-01 12:00:00', 4, 2, '승인', false),
    (33, '참가신청', '2023-08-02 12:00:00', 5, 3, '거절', false),
    (34, '참가신청', '2023-08-03 12:00:00', 6, 4, '승인대기', false),
    (35, '참가신청', '2023-08-04 12:00:00', 7, 5, '승인', false),
    (36, '참가신청', '2023-08-05 12:00:00', 1, 6, '거절', false),
    (37, '참가신청', '2023-08-06 12:00:00', 2, 7, '승인대기', false),
    (38, '참가신청', '2023-08-07 12:00:00', 3, 8, '승인', false),
    (39, '참가신청', '2023-08-08 12:00:00', 4, 9, '거절', false),
    (40, '참가신청', '2023-08-09 12:00:00', 5, 10, '승인대기', false),
    (41, '참가신청', '2023-08-10 12:00:00', 6, 1, '승인', false),
    (42, '참가신청', '2023-08-11 12:00:00', 7, 2, '거절', false),
    (43, '참가신청', '2023-08-12 12:00:00', 1, 3, '승인대기', false),
    (44, '참가신청', '2023-08-13 12:00:00', 2, 4, '승인', false),
    (45, '참가신청', '2023-08-14 12:00:00', 3, 5, '거절', false),
    (46, '참가신청', '2023-08-15 12:00:00', 4, 6, '승인대기', false),
    (47, '참가신청', '2023-08-16 12:00:00', 5, 7, '승인', false),
    (48, '참가신청', '2023-08-17 12:00:00', 6, 8, '거절', false),
    (49, '참가신청', '2023-08-18 12:00:00', 7, 9, '승인대기', false),
    (50, '참가신청', '2023-08-19 12:00:00', 1, 10, '승인', false);
