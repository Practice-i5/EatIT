-- 테이블 생성 스크립트
DROP TABLE IF EXISTS `tbl_admin`;

CREATE TABLE `tbl_admin`
(
    `admin_id`     INT          NOT NULL COMMENT 'admin_id',
    `email`        VARCHAR(255) NOT NULL COMMENT 'email',
    `password`     VARCHAR(255) NOT NULL COMMENT 'password',
    `created_date` DATETIME     NOT NULL COMMENT 'created_date',
    PRIMARY KEY (`admin_id`)
) COMMENT = 'admin';

-- 관리자 테이블 데이터 삽입
INSERT INTO `tbl_admin` (`admin_id`, `email`, `password`, `created_date`)
VALUES (1, 'admin1234@admin.com',
        'ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270', NOW());



DROP TABLE IF EXISTS `TBL_TECH_STACK_TYPE`;

create table tbl_tech_stack_type
(
    stack_code int          not null comment 'stack_code'
        primary key auto_increment,
    stack_name varchar(255) null comment 'stack_name',
    UNIQUE KEY unique_stack_name (stack_name)
) comment 'tech_stack_type';

-- 기술스택종류 테이블 데이터 삽입
INSERT INTO TBL_TECH_STACK_TYPE (stack_name)
VALUES ('Java')
     , ('Python')
     , ('C#')
     , ('C++')
     , ('JavaScript')
     , ('Rust')
     , ('Kotlin')
     , ('Unity')
     , ('Unreal')
     , ('Spring')
     , ('Go')
     , ('FastApi')
     , ('TypeScript')
     , ('React')
     , ('Node.js')
     , ('Babylon.js')
     , ('Django')
     , ('PHP');



DROP TABLE IF EXISTS `tbl_message`;

CREATE TABLE `tbl_message`
(
    `message_id`      INT NOT NULL COMMENT 'message_id',
    `message_order`   INT NOT NULL COMMENT 'message_order',
    `message_type`    VARCHAR(255) COMMENT 'message_type',
    `message_content` TEXT COMMENT 'message_content',
    `member_id`       INT NOT NULL COMMENT 'member_id',
    `chatroom_id`     INT NOT NULL COMMENT 'chatroom_id',
    PRIMARY KEY (`message_id`)
) COMMENT = 'message';

-- 메세지 테이블 데이터 삽입
INSERT INTO `tbl_message` (`message_id`, `message_order`, `message_type`, `message_content`,
                           `member_id`, `chatroom_id`)
VALUES (1, 1, 'text', 'Hello, World!', 1, 1),
       (2, 2, 'text', 'How are you?', 2, 1),
       (3, 3, 'text', 'Good morning!', 3, 2),
       (4, 4, 'text', 'Nice to meet you.', 4, 2),
       (5, 5, 'text', 'What is up?', 5, 3),
       (6, 6, 'text', 'Happy coding!', 6, 3),
       (7, 7, 'text', 'See you later.', 7, 4),
       (8, 8, 'text', 'Goodbye!', 8, 4),
       (9, 9, 'text', 'Take care.', 9, 5),
       (10, 10, 'text', 'Have a nice day!', 10, 5);



DROP TABLE IF EXISTS `tbl_meeting`;

CREATE TABLE `tbl_meeting`
(
    `meeting_id`            INT          NOT NULL AUTO_INCREMENT COMMENT 'meeting_id',
    `title`                 VARCHAR(255) NOT NULL COMMENT 'title',
    `location_name`         VARCHAR(255) NOT NULL COMMENT 'location_name',
    `location_latitude`     DOUBLE       NOT NULL COMMENT 'location_latitude',
    `location_longitude`    DOUBLE       NOT NULL COMMENT 'location_longitude',
    `introduction`          TEXT         NOT NULL COMMENT 'introduction',
    `payment_method`        VARCHAR(255) NOT NULL COMMENT 'payment_method',
    `meeting_type`          VARCHAR(255) NOT NULL COMMENT 'meeting_type',
    `scheduled_date`        DATETIME     NOT NULL COMMENT 'scheduled_date', -- fix type DATE -> DATETIEM
    `exit_restriction_time` TIME         NOT NULL COMMENT 'exit_restriction_time',
    `recruit_member_number` INT          NOT NULL DEFAULT 0 COMMENT 'recruit_member_number',
    `recruitment_number`    INT          NOT NULL COMMENT 'recruitment_number',
    `gender`                VARCHAR(255) NOT NULL COMMENT 'gender',
    `eligible_age`          VARCHAR(255) NOT NULL COMMENT 'eligible_age',
    `created_date`          DATETIME     NOT NULL COMMENT 'created_date',
    `participation_method`  VARCHAR(255) NOT NULL COMMENT 'participation_method',
    `status`                VARCHAR(255) NOT NULL COMMENT 'status',
    `end_date`              DATETIME COMMENT 'end_date',
    `host_member_id`        INT          NOT NULL COMMENT 'host_member_id',
    PRIMARY KEY (`meeting_id`)
) COMMENT = 'meeting';

-- 모임 테이블 데이터 삽입
INSERT INTO `tbl_meeting` (`meeting_id`, `title`, `location_name`, `location_latitude`,
                           `location_longitude`, `introduction`, `payment_method`, `meeting_type`,
                           `scheduled_date`, `exit_restriction_time`, `recruit_member_number`,
                           `recruitment_number`, `gender`, `eligible_age`, `created_date`,
                           `participation_method`, `status`, `end_date`, `host_member_id`)
VALUES (1, 'Study Group', 'Library', 37.5665, 126.9780, 'Study together', 'Free', 'Study',
        '2024-08-01 22:00:00', '22:00:00', 1, 10, 'Mixed', '18-25', '2024-07-01 10:00:00', 'Online',
        'Open', '2024-08-01 22:00:00', 1),
       (2, 'Running Club', 'Park', 37.5665, 126.9780, 'Morning runs', 'Free', 'Sports',
        '2024-08-02 22:00:00', '07:00:00', 3, 20, 'Mixed', '20-30', '2024-07-02 11:00:00',
        'Offline', 'Open', '2024-08-02 07:00:00', 2),
       (3, 'Music Band', 'Studio', 37.5665, 126.9780, 'Play music', 'Paid', 'Music',
        '2024-08-03 22:00:00', '18:00:00', 4, 5, 'Mixed', '18-35', '2024-07-03 12:00:00', 'Offline',
        'Open', '2024-08-03 18:00:00', 3),
       (4, 'Coding Bootcamp', 'Office', 37.5665, 126.9780, 'Learn to code', 'Paid', 'Study',
        '2024-08-04 22:00:00', '09:00:00', 6, 15, 'Mixed', '20-40', '2024-07-04 13:00:00', 'Online',
        'Open', '2024-08-04 09:00:00', 4),
       (5, 'Book Club', 'Cafe', 37.5665, 126.9780, 'Discuss books', 'Free', 'Study',
        '2024-08-05 22:00:00', '15:00:00', 1, 8, 'Mixed', '25-35', '2024-07-05 14:00:00', 'Offline',
        'Open', '2024-08-05 15:00:00', 5),
       (6, 'Yoga Class', 'Gym', 37.5665, 126.9780, 'Yoga practice', 'Paid', 'Sports',
        '2024-08-06 22:00:00', '06:00:00', 6, 12, 'Female', '18-45', '2024-07-06 15:00:00',
        'Offline', 'Open', '2024-08-06 06:00:00', 6),
       (7, 'Photography Workshop', 'Studio', 37.5665, 126.9780, 'Learn photography', 'Paid', 'Art',
        '2024-08-07 22:00:00', '10:00:00', 4, 10, 'Mixed', '18-50', '2024-07-07 16:00:00',
        'Offline', 'Open', '2024-08-07 10:00:00', 7),
       (8, 'Cooking Class', 'Kitchen', 37.5665, 126.9780, 'Cook together', 'Paid', 'Lifestyle',
        '2024-08-08 22:00:00', '17:00:00', 7, 6, 'Mixed', '20-60', '2024-07-08 17:00:00', 'Offline',
        'Open', '2024-08-08 17:00:00', 8),
       (9, 'Language Exchange', 'Cafe', 37.5665, 126.9780, 'Exchange languages', 'Free', 'Study',
        '2024-08-09 22:00:00', '19:00:00', 2, 20, 'Mixed', '18-30', '2024-07-09 18:00:00',
        'Offline', 'Closed', '2024-08-09 19:00:00', 9),
       (10, 'Dance Class', 'Hall', 37.5665, 126.9780, 'Learn to dance', 'Paid', 'Art',
        '2024-08-10 22:00:00', '20:00:00', 2, 6, 'Mixed', '18-40', '2024-07-10 19:00:00',
        'Offline', 'Closed', '2024-08-10 20:00:00', 10),
       (11, 'Language Exchange', 'Cafe', 37.5665, 126.9780, 'Discuss books', 'Free', 'Study',
        '2024-08-09 22:00:00', '19:00:00', 1, 7, 'Mixed', '18-30', '2024-07-09 01:00:00',
        'Offline', 'Closed', '2024-08-09 19:00:00', 1),
       (12, 'Language Exchange', 'Cafe', 37.5665, 126.9780, 'Play music', 'Free', 'Study',
        '2024-08-09 22:00:00', '19:00:00', 1, 8, 'Mixed', '18-30', '2024-07-10 02:00:00',
        'Offline', 'Closed', '2024-08-09 19:00:00', 1),
       (13, 'Language Exchange', 'Cafe', 37.5665, 126.9780, 'Yoga practice', 'Free', 'Study',
        '2024-08-09 22:00:00', '19:00:00', 1, 9, 'Mixed', '18-30', '2024-07-11 03:00:00',
        'Offline', 'Closed', '2024-08-09 19:00:00', 1);



    DROP TABLE IF EXISTS `tbl_meeting_interest_category`;

CREATE TABLE `tbl_meeting_interest_category`
(
    `interests` VARCHAR(255) NOT NULL COMMENT 'interests',
    PRIMARY KEY (`interests`)
) COMMENT = 'meeting_interest_category';

-- 모임관심분야 테이블 데이터 삽입
INSERT INTO `tbl_meeting_interest_category` (`interests`)
VALUES ('Python'),
       ('Swift'),
       ('VisionOS'),
       ('C++'),
       ('Backend'),
       ('Unity'),
       ('UE5'),
       ('AI'),
       ('TA'),
       ('Object-C');



DROP TABLE IF EXISTS `tbl_meeting_interest_relation`;

CREATE TABLE `tbl_meeting_interest_relation`
(
    `relation_id` INT          NOT NULL AUTO_INCREMENT COMMENT 'relation_id',
    `interests`   VARCHAR(255) NOT NULL COMMENT 'interests',
    `meeting_id`  INT          NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`relation_id`)
) COMMENT = 'meeting_interest_relation';

-- 모임관심연관 테이블 데이터 삽입
INSERT INTO `tbl_meeting_interest_relation` (`relation_id`, `interests`, `meeting_id`)
VALUES (1, 'Python', 1),
       (2, 'Swift', 2),
       (3, 'VisionOS', 3),
       (4, 'C++', 4),
       (5, 'Backend', 5),
       (6, 'Unity', 6),
       (7, 'UE5', 7),
       (8, 'AI', 8),
       (9, 'TA', 9),
       (10, 'Object-C', 10),
       (11, 'VisionOS', 6),
       (12, 'VisionOS', 7);



DROP TABLE IF EXISTS `TBL_MEETING_PHOTO`;

create table tbl_meeting_photo
(
    photo_id   int          not null auto_increment comment 'photo_id' primary key,
    photo_path varchar(255) not null comment 'photo_path',
    photo_name varchar(255) not null comment 'photo_name',
    meeting_id int          not null comment 'meeting_id',
    UNIQUE (meeting_id)
) comment 'meeting_photo';

-- 모임사진 테이블 데이터 삽입
INSERT INTO `tbl_meeting_photo` (`photo_id`, `photo_path`, `photo_name`, `meeting_id`)
VALUES (1, '/img/ade.png', 'ade.png', 1),
       (2, '/img/crople.png', 'crople.png', 2),
       (3, '/img/test_image.png', 'test_image.png', 3),
       (4, '/img/ade.png', 'ade.png', 4),
       (5, '/img/ade.png', 'ade.png', 5),
       (6, '/img/ade.png', 'ade.png', 6),
       (7, '/img/ade.png', 'ade.png', 7),
       (8, '/img/ade.png', 'ade.png', 8),
       (9, '/img/ade.png', 'ade.png', 9),
       (10, '/img/ade.png', 'ade.png', 10);



DROP TABLE IF EXISTS `tbl_meeting_participation`;

CREATE TABLE `tbl_meeting_participation`
(
    `participation_id` INT          NOT NULL AUTO_INCREMENT COMMENT 'participation_id',
    `role`             VARCHAR(255) NOT NULL COMMENT 'role',
    `meeting_id`       INT          NOT NULL COMMENT 'meeting_id',
    `member_id`        INT          NOT NULL COMMENT 'member_id',
    PRIMARY KEY (`participation_id`)
) COMMENT = 'meeting_participation';

-- 모임참여 테이블 데이터 삽입
INSERT INTO `tbl_meeting_participation` (`participation_id`, `role`, `meeting_id`, `member_id`)
VALUES (1, 'Host', 1, 1),
       (2, 'Participant', 1, 2),
       (3, 'Participant', 1, 3),
       (4, 'Participant', 1, 4),
       (5, 'Participant', 1, 5),
       (6, 'Host', 2, 3),
       (7, 'Participant', 2, 4),
       (8, 'Host', 3, 5),
       (9, 'Participant', 3, 6),
       (10, 'Host', 4, 7),
       (11, 'Participant', 4, 8),
       (12, 'Host', 5, 9),
       (13, 'Participant', 5, 10);



DROP TABLE IF EXISTS `tbl_notification`;

CREATE TABLE `tbl_notification`
(
    `notification_id`      INT      NOT NULL COMMENT 'notification_id',
    `notification_content` TEXT     NOT NULL COMMENT 'notification_content',
    `created_date`         DATETIME NOT NULL COMMENT 'created_date',
    `member_id`            INT      NOT NULL COMMENT 'member_id',
    `participation_id`     INT      NOT NULL COMMENT 'participation_id',
    `status`               VARCHAR(255) COMMENT 'status',
    PRIMARY KEY (`notification_id`)
) COMMENT = 'notification';

-- 알람 테이블 데이터 삽입
INSERT INTO `tbl_notification` (`notification_id`, `notification_content`, `created_date`,
                                `member_id`, `participation_id`, `status`)
VALUES (1, 'New message', '2024-07-01 10:00:00', 1, 1, 'Unread'),
       (2, 'Event reminder', '2024-07-02 11:00:00', 2, 2, 'Read'),
       (3, 'New message', '2024-07-03 12:00:00', 3, 3, 'Unread'),
       (4, 'Event reminder', '2024-07-04 13:00:00', 4, 4, 'Read'),
       (5, 'New message', '2024-07-05 14:00:00', 5, 5, 'Unread'),
       (6, 'Event reminder', '2024-07-06 15:00:00', 6, 6, 'Read'),
       (7, 'New message', '2024-07-07 16:00:00', 7, 7, 'Unread'),
       (8, 'Event reminder', '2024-07-08 17:00:00', 8, 8, 'Read'),
       (9, 'New message', '2024-07-09 18:00:00', 9, 9, 'Unread'),
       (10, 'Event reminder', '2024-07-10 19:00:00', 10, 10, 'Read');



DROP TABLE IF EXISTS `tbl_bookmark`;

CREATE TABLE `tbl_bookmark`
(
    `bookmark_id` INT AUTO_INCREMENT COMMENT 'bookmark_id',
    `member_id`   INT NOT NULL COMMENT 'member_id',
    `meeting_id`  INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`bookmark_id`)
) COMMENT = 'bookmark';

-- 찜하기 테이블 데이터 삽입
INSERT INTO `tbl_bookmark` (`bookmark_id`, `member_id`, `meeting_id`)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3),
       (4, 4, 4),
       (5, 5, 5),
       (6, 6, 6),
       (7, 7, 7),
       (8, 8, 8),
       (9, 9, 9),
       (10, 10, 10);



DROP TABLE IF EXISTS `TBL_BLOCK`;

CREATE TABLE `TBL_BLOCK`
(
    `block_id`           INT      NOT NULL AUTO_INCREMENT COMMENT 'block_id',
    `block_date`         DATETIME NOT NULL COMMENT 'block_date',
    `blocking_member_id` INT      NOT NULL COMMENT '차단을 하는 사람',
    `blocked_member_id`  INT      NOT NULL COMMENT '차단을 당하는 사람',
    PRIMARY KEY (`block_id`),
    UNIQUE KEY `unique_block` (`blocking_member_id`, `blocked_member_id`)
) COMMENT ='block';

INSERT INTO TBL_BLOCK (block_date, blocking_member_id, blocked_member_id)
VALUES ('2024-06-01 10:00:00', 1, 2),
       ('2024-06-05 14:30:00', 1, 3),
       ('2024-06-10 09:15:00', 1, 5),
       ('2024-06-15 11:00:00', 2, 5),
       ('2024-06-18 16:45:00', 2, 6),
       ('2024-06-22 12:00:00', 3, 7),
       ('2024-06-22 10:30:00', 3, 8),
       ('2024-06-27 18:20:00', 3, 9),
       ('2024-07-03 13:00:00', 4, 10),
       ('2024-07-05 09:45:00', 5, 1),
       ('2024-07-08 11:15:00', 5, 3),
       ('2024-07-12 15:30:00', 6, 2),
       ('2024-07-15 14:00:00', 6, 4),
       ('2024-07-18 17:10:00', 6, 8),
       ('2024-07-20 10:50:00', 7, 9),
       ('2024-07-20 12:30:00', 8, 1),
       ('2024-07-23 16:00:00', 8, 2),
       ('2024-07-24 09:00:00', 9, 10);



DROP TABLE IF EXISTS `tbl_chatroom`;

CREATE TABLE `tbl_chatroom`
(
    `chatroom_id`  INT NOT NULL COMMENT 'chatroom_id',
    `status`       VARCHAR(255) COMMENT 'status',
    `created_date` DATETIME COMMENT 'created_date',
    `meeting_id`   INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`chatroom_id`)
) COMMENT = 'chatroom';

-- 채팅방 테이블 데이터 삽입
INSERT INTO `tbl_chatroom` (`chatroom_id`, `status`, `created_date`, `meeting_id`)
VALUES (1, 'Active', '2024-07-01 10:00:00', 1),
       (2, 'Active', '2024-07-02 11:00:00', 2),
       (3, 'Active', '2024-07-03 12:00:00', 3),
       (4, 'Inactive', '2024-07-04 13:00:00', 4),
       (5, 'Active', '2024-07-05 14:00:00', 5),
       (6, 'Active', '2024-07-06 15:00:00', 6),
       (7, 'Inactive', '2024-07-07 16:00:00', 7),
       (8, 'Active', '2024-07-08 17:00:00', 8),
       (9, 'Active', '2024-07-09 18:00:00', 9),
       (10, 'Inactive', '2024-07-10 19:00:00', 10);



DROP TABLE IF EXISTS `tbl_chat_participation`;

CREATE TABLE `tbl_chat_participation`
(
    `member_id`   INT          NOT NULL COMMENT 'member_id',
    `chatroom_id` INT          NOT NULL COMMENT 'chatroom_id',
    `role`        VARCHAR(255) NOT NULL COMMENT 'role',
    PRIMARY KEY (`member_id`, `chatroom_id`)
) COMMENT = 'chat_participation';

-- 채팅참여 테이블 데이터 삽입
INSERT INTO `tbl_chat_participation` (`member_id`, `chatroom_id`, `role`)
VALUES (1, 1, 'Admin'),
       (2, 1, 'Member'),
       (3, 2, 'Admin'),
       (4, 2, 'Member'),
       (5, 3, 'Admin'),
       (6, 3, 'Member'),
       (7, 4, 'Admin'),
       (8, 4, 'Member'),
       (9, 5, 'Admin'),
       (10, 5, 'Member');



DROP TABLE IF EXISTS `TBL_FOLLOW`;

CREATE TABLE tbl_follow
(
    follow_id   INT      NOT NULL AUTO_INCREMENT COMMENT 'follow_id' PRIMARY KEY,
    follower_id INT      NOT NULL COMMENT '팔로우를 하는 사람',
    followee_id INT      NOT NULL COMMENT '팔로우를 받는 사람',
    follow_date DATETIME NOT NULL COMMENT 'follow_date',
    UNIQUE KEY unique_follow (follower_id, followee_id)
)
    COMMENT 'follow';

-- 팔로우 테이블 데이터 삽입
INSERT INTO tbl_follow (follower_id, followee_id, follow_date)
VALUES (1, 2, '2024-06-23 10:15:30')
     , (1, 4, '2024-06-25 11:30:45')
     , (1, 6, '2024-06-24 09:20:15')
     , (2, 1, '2024-07-02 14:45:00')
     , (2, 5, '2024-07-05 16:10:20')
     , (3, 1, '2024-06-28 08:30:10')
     , (3, 2, '2024-07-10 12:05:55')
     , (4, 5, '2024-07-07 17:25:40')
     , (5, 1, '2024-07-14 19:50:15')
     , (5, 2, '2024-07-17 20:15:30')
     , (6, 7, '2024-07-20 22:00:00')
     , (7, 8, '2024-06-29 07:45:20')
     , (8, 9, '2024-07-21 11:30:45')
     , (9, 10, '2024-07-22 15:20:10')
     , (10, 2, '2024-07-23 13:40:30');



DROP TABLE IF EXISTS `tbl_member`;

CREATE TABLE `tbl_member`
(
    `member_id`           INT           NOT NULL AUTO_INCREMENT COMMENT 'member_id',
    `email`               VARCHAR(255)  NOT NULL COMMENT 'email',
    `password`            VARCHAR(255)  NOT NULL COMMENT 'password',
    `name`                VARCHAR(255)  NOT NULL COMMENT 'name',
    `nickname`            VARCHAR(255)  NOT NULL COMMENT 'nickname',
    `login_method`        VARCHAR(255)  NOT NULL COMMENT 'login_method',
    `phone_number`        VARCHAR(255) COMMENT 'phone_number',
    `created_date`        DATETIME      NOT NULL COMMENT 'created_date',
    `withdrawal_status`   VARCHAR(255)  NOT NULL COMMENT 'withdrawal_status',
    `reported_count`      INT DEFAULT 0 NULL COMMENT '누적 신고 횟수',
    `gender`              VARCHAR(255)  NOT NULL COMMENT 'gender',
    `age`                 INT           NOT NULL COMMENT 'age',
    `is_stopped_by_admin` INT           NOT NULL COMMENT 'is_stopped_by_admin',

    PRIMARY KEY (`member_id`)
) COMMENT = 'member';

-- 회원 테이블 데이터 삽입
INSERT INTO tbl_member (member_id, email, password, name, nickname, login_method, phone_number,
                        created_date, withdrawal_status, reported_count, gender, age,
                        is_stopped_by_admin)
VALUES (1, 'user1@example.com', 'password1', 'User One', 'user1', 'email', '01012345678',
        '2024-07-01 10:00:00', 'N', 1, "F", 19, 0),
       (2, 'user2@example.com', 'password2', 'User Two', 'user2', 'email', '01023456789',
        '2024-07-02 11:00:00', 'N', 2, "F", 29, 0),
       (3, 'user3@example.com', 'password3', 'User Three', 'user3', 'email', '01034567890',
        '2024-07-03 12:00:00', 'N', 3, "M", 24, 0),
       (4, 'user4@example.com', 'password4', 'User Four', 'user4', 'email', '01045678901',
        '2024-07-04 13:00:00', 'N', 4, "F", 33, 0),
       (5, 'user5@example.com', 'password5', 'User Five', 'user5', 'email', '01056789012',
        '2024-07-05 14:00:00', 'N', 5, "M", 35, 0),
       (6, 'user6@example.com', 'password6', 'User Six', 'user6', 'email', '01067890123',
        '2024-07-06 15:00:00', 'N', 6, "F", 43, 0),
       (7, 'user7@example.com', 'password7', 'User Seven', 'user7', 'email', '01078901234',
        '2024-07-07 16:00:00', 'N', 7, "M", 55, 0),
       (8, 'user8@example.com', 'password8', 'User Eight', 'user8', 'email', '01089012345',
        '2024-07-08 17:00:00', 'N', 8, "F", 62, 0),
       (9, 'user9@example.com', 'password9', 'User Nine', 'user9', 'email', '01090123456',
        '2024-07-09 18:00:00', 'N', 9, "M", 26, 0),
       (10, 'user10@example.com', 'password10', 'User Ten', 'user10', 'email', '01001234567',
        '2024-07-10 19:00:00', 'N', 10, "F", 100, 0);



DROP TABLE IF EXISTS `tbl_member_tech_stack`;

CREATE TABLE `tbl_member_tech_stack`
(
    `stack_code` INT NOT NULL COMMENT 'stack_code',
    `member_id`  INT NOT NULL COMMENT 'member_id'
) COMMENT = 'member_tech_stack';

-- 회원기술스택 테이블 데이터 삽입
INSERT INTO `tbl_member_tech_stack` (`stack_code`, `member_id`)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 8),
       (9, 9),
       (10, 10);



DROP TABLE IF EXISTS `TBL_MEMBER_PHOTO`;

CREATE TABLE tbl_member_photo
(
    photo_id   INT          NOT NULL AUTO_INCREMENT COMMENT 'photo_id' PRIMARY KEY,
    photo_path VARCHAR(255) NOT NULL COMMENT 'photo_path',
    photo_name VARCHAR(255) NOT NULL COMMENT 'photo_name',
    member_id  INT          NOT NULL COMMENT 'member_id',
    UNIQUE (member_id)
) COMMENT 'member_photo';

-- 회원사진 테이블 데이터 삽입
INSERT INTO tbl_member_photo (photo_path, photo_name, member_id)
VALUES ('https://drive.google.com/thumbnail?id=1lae75gYaxba4Jf_zXqrNKUoe4w57TuNE&sz=w300',
        'rainbow.jpg', 1),
       ('https://drive.google.com/thumbnail?id=1wnMVXMgV1zm-HPg7_7zQnUUDJcNIoYNx&sz=w300',
        'voodoo.jpg', 2),
       ('https://drive.google.com/thumbnail?id=1wnMVXMgV1zm-HPg7_7zQnUUDJcNIoYNx&sz=w300',
        'user3.jpg', 3),
       ('https://drive.google.com/thumbnail?id=10dVyCi7JOmh25HmLvt9IWuH9xfjBwinN&sz=w300',
        'rabbit.png', 4),
       ('https://drive.google.com/thumbnail?id=1zNbaC_tEsqZ2S6M5OA7myn3l_SzvRWJn&sz=w300',
        'al_nassr.svg', 5),
       ('https://drive.google.com/thumbnail?id=1FZQ9JgaNE1zriEtcPz1co4KyZoQ9vH_o&sz=w300',
        'bocchi.webp', 6);


DROP TABLE IF EXISTS `tbl_review`;

CREATE TABLE `tbl_review`
(
    `review_id`      INT NOT NULL COMMENT 'review_id',
    `review_content` TEXT COMMENT 'review_content',
    `created_date`   DATETIME COMMENT 'created_date',
    `reviewer_id`    INT NOT NULL COMMENT 'reviewer_id',
    `reviewee_id`    INT NOT NULL COMMENT 'reviewee_id',
    `meeting_id`     INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`review_id`)
) COMMENT = 'review';

-- 후기 테이블 데이터 삽입
INSERT INTO `tbl_review` (`review_id`, `review_content`, `created_date`, `reviewer_id`,
                          `reviewee_id`, `meeting_id`)
VALUES (1, '훌륭한 이벤트입니다!', '2024-07-01 10:00:00', 1, 2, 1),
       (2, '즐거운 시간을 보냈습니다.', '2024-07-02 11:00:00', 2, 3, 2),
       (3, '매우 유익합니다.', '2024-07-03 12:00:00', 3, 4, 3),
       (4, '많이 즐겼습니다.', '2024-07-04 13:00:00', 4, 5, 4),
       (5, '많은 것을 배웠습니다.', '2024-07-05 14:00:00', 5, 6, 5),
       (6, '다시 가입합니다.', '2024-07-06 15:00:00', 6, 7, 6),
       (7, '매너가 좋았습니다.', '2024-07-07 16:00:00', 7, 8, 7),
       (8, '놀라운 경험.', '2024-07-08 17:00:00', 8, 9, 8),
       (9, '재미 있고 매력적입니다.', '2024-07-09 18:00:00', 9, 10, 9),
       (10, '정말 마음에 들었어요.', '2024-07-10 19:00:00', 10, 1, 10),
       (11, '이번 행사에서는 실망스러웠습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (12, '즐거운 시간을 보내지 못했습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (13, '유용한 정보가 부족했습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (14, '그다지 매력적이지는 않았습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (15, '시간 낭비처럼 느껴졌습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (16, '추천할 가치가 없습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (17, '다시는 참석하지 않겠습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (18, '지루하다고 느꼈습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (19, '전혀 감동받지 않았습니다.', '2024-07-10 19:00:00', 10, 1, 10),
       (20, '같이 있기 부끄럽습니다.', '2024-07-10 19:00:00', 10, 1, 10);


-- 알람 테이블 테이블 생성
DROP TABLE IF EXISTS `tbl_alarm`;

CREATE TABLE `tbl_alarm`
(
    `alarm_id`    INT NOT NULL COMMENT '알림번호',
    `alarm_detail`    VARCHAR(300) NOT NULL COMMENT '알림내용',
    `alarm_date`    DATETIME NOT NULL COMMENT '생성날짜',
    `member_id`    INTEGER NOT NULL COMMENT '회원번호',
    `participation_id`    INTEGER NOT NULL COMMENT '참여번호',
    `alarm_status`    VARCHAR(12) NOT NULL COMMENT '상태',
    `alarm_checked`    BOOLEAN NOT NULL COMMENT '확인여부',
    `meeting_id`    INTEGER NOT NULL COMMENT '모임번호',
    PRIMARY KEY ( `alarm_id` )
) COMMENT = '알람';


INSERT INTO `tbl_alarm` (`alarm_id`, `alarm_detail`, `alarm_date`, `member_id`, `participation_id`, `alarm_status`, `alarm_checked`, `meeting_id`)
VALUES
    (1, '안녕하세요, 홍길동입니다.', '2023-07-01 12:00:00', 1, 1, '승인대기', true, 1),
    (2, '안녕하세요, 이순신입니다.', '2023-07-02 12:00:00', 2, 2, '승인', true, 2),
    (3, '안녕하세요, 강감찬입니다.', '2023-07-03 12:00:00', 3, 3, '거절', true, 3),
    (4, '안녕하세요, 김유신입니다.', '2023-07-04 12:00:00', 4, 4, '승인대기', true, 4),
    (5, '안녕하세요, 장보고입니다.', '2023-07-05 12:00:00', 5, 5, '승인', true, 5),
    (6, '안녕하세요, 유관순입니다.', '2023-07-06 12:00:00', 6, 6, '거절', true, 6),
    (7, '안녕하세요, 세종대왕입니다.', '2023-07-07 12:00:00', 7, 7, '승인대기', true, 7),
    (8, '안녕하세요, 홍길동입니다.', '2023-07-08 12:00:00', 1, 8, '승인', true, 8),
    (9, '안녕하세요, 이순신입니다.', '2023-07-09 12:00:00', 2, 9, '거절', true, 9),
    (10, '안녕하세요, 강감찬입니다.', '2023-07-10 12:00:00', 3, 10, '승인대기', true, 10),
    (11, '안녕하세요, 김유신입니다.', '2023-07-11 12:00:00', 4, 11, '승인', false, 1),
    (12, '안녕하세요, 장보고입니다.', '2023-07-12 12:00:00', 5, 12, '거절', false, 2),
    (13, '안녕하세요, 유관순입니다.', '2023-07-13 12:00:00', 6, 13, '승인대기', false, 3),
    (14, '안녕하세요, 세종대왕입니다.', '2023-07-14 12:00:00', 7, 14, '승인', false, 4),
    (15, '안녕하세요, 홍길동입니다.', '2023-07-15 12:00:00', 1, 15, '거절', false, 5),
    (16, '안녕하세요, 이순신입니다.', '2023-07-16 12:00:00', 2, 16, '승인대기', false, 6),
    (17, '안녕하세요, 강감찬입니다.', '2023-07-17 12:00:00', 3, 17, '승인', false, 7),
    (18, '안녕하세요, 김유신입니다.', '2023-07-18 12:00:00', 4, 18, '거절', false, 8),
    (19, '안녕하세요, 장보고입니다.', '2023-07-19 12:00:00', 5, 19, '승인대기', false, 9),
    (20, '안녕하세요, 유관순입니다.', '2023-07-20 12:00:00', 6, 20, '승인', false, 10),
    (21, '안녕하세요, 세종대왕입니다.', '2023-07-21 12:00:00', 7, 21, '거절', false, 1),
    (22, '안녕하세요, 홍길동입니다.', '2023-07-22 12:00:00', 1, 22, '승인대기', false, 2),
    (23, '안녕하세요, 이순신입니다.', '2023-07-23 12:00:00', 2, 23, '승인', false, 3),
    (24, '안녕하세요, 강감찬입니다.', '2023-07-24 12:00:00', 3, 24, '거절', false, 4),
    (25, '안녕하세요, 김유신입니다.', '2023-07-25 12:00:00', 4, 25, '승인대기', false, 5),
    (26, '안녕하세요, 장보고입니다.', '2023-07-26 12:00:00', 5, 26, '승인', false, 6),
    (27, '안녕하세요, 유관순입니다.', '2023-07-27 12:00:00', 6, 27, '거절', false, 7),
    (28, '안녕하세요, 세종대왕입니다.', '2023-07-28 12:00:00', 7, 28, '승인대기', false, 8),
    (29, '안녕하세요, 홍길동입니다.', '2023-07-29 12:00:00', 1, 29, '승인', false, 9),
    (30, '안녕하세요, 이순신입니다.', '2023-07-30 12:00:00', 2, 30, '거절', false, 10),
    (31, '안녕하세요, 강감찬입니다.', '2023-07-31 12:00:00', 3, 31, '승인대기', false, 1),
    (32, '안녕하세요, 김유신입니다.', '2023-08-01 12:00:00', 4, 32, '승인', false, 2),
    (33, '안녕하세요, 장보고입니다.', '2023-08-02 12:00:00', 5, 33, '거절', false, 3),
    (34, '안녕하세요, 유관순입니다.', '2023-08-03 12:00:00', 6, 34, '승인대기', false, 4),
    (35, '안녕하세요, 세종대왕입니다.', '2023-08-04 12:00:00', 7, 35, '승인', false, 5),
    (36, '안녕하세요, 홍길동입니다.', '2023-08-05 12:00:00', 1, 36, '거절', false, 6),
    (37, '안녕하세요, 이순신입니다.', '2023-08-06 12:00:00', 2, 37, '승인대기', false, 7),
    (38, '안녕하세요, 강감찬입니다.', '2023-08-07 12:00:00', 3, 38, '승인', false, 8),
    (39, '안녕하세요, 김유신입니다.', '2023-08-08 12:00:00', 4, 39, '거절', false, 9),
    (40, '안녕하세요, 장보고입니다.', '2023-08-09 12:00:00', 5, 40, '승인대기', false, 10),
    (41, '안녕하세요, 유관순입니다.', '2023-08-10 12:00:00', 6, 41, '승인', false, 1),
    (42, '안녕하세요, 세종대왕입니다.', '2023-08-11 12:00:00', 7, 42, '거절', false, 2),
    (43, '안녕하세요, 홍길동입니다.', '2023-08-12 12:00:00', 1, 43, '승인대기', false, 3),
    (44, '안녕하세요, 이순신입니다.', '2023-08-13 12:00:00', 2, 44, '승인', false, 4),
    (45, '안녕하세요, 강감찬입니다.', '2023-08-14 12:00:00', 3, 45, '거절', false, 5),
    (46, '안녕하세요, 김유신입니다.', '2023-08-15 12:00:00', 4, 46, '승인대기', false, 6),
    (47, '안녕하세요, 장보고입니다.', '2023-08-16 12:00:00', 5, 47, '승인', false, 7),
    (48, '안녕하세요, 유관순입니다.', '2023-08-17 12:00:00', 6, 48, '거절', false, 8),
    (49, '안녕하세요, 세종대왕입니다.', '2023-08-18 12:00:00', 7, 49, '승인대기', false, 9),
    (50, '안녕하세요, 홍길동입니다.', '2023-08-19 12:00:00', 1, 50, '승인', false, 10);
