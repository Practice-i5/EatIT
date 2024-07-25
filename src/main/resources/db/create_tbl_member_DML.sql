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

DROP TABLE IF EXISTS `tbl_tech_stack_type`;

CREATE TABLE `tbl_tech_stack_type`
(
    `stack_code` INT NOT NULL COMMENT 'stack_code',
    `stack_name` VARCHAR(255) COMMENT 'stack_name',
    PRIMARY KEY (`stack_code`)
) COMMENT = 'tech_stack_type';

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

DROP TABLE IF EXISTS `tbl_meeting`;

CREATE TABLE `tbl_meeting`
(
    `meeting_id`            INT          NOT NULL COMMENT 'meeting_id',
    `title`                 VARCHAR(255) NOT NULL COMMENT 'title',
    `location_name`         VARCHAR(255) NOT NULL COMMENT 'location_name',
    `location_latitude` DOUBLE NOT NULL COMMENT 'location_latitude',
    `location_longitude` DOUBLE NOT NULL COMMENT 'location_longitude',
    `introduction`          TEXT         NOT NULL COMMENT 'introduction',
    `payment_method`        VARCHAR(255) NOT NULL COMMENT 'payment_method',
    `meeting_type`          VARCHAR(255) NOT NULL COMMENT 'meeting_type',
    `scheduled_date`        DATE         NOT NULL COMMENT 'scheduled_date',
    `exit_restriction_time` TIME         NOT NULL COMMENT 'exit_restriction_time',
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

DROP TABLE IF EXISTS `tbl_meeting_interest_category`;

CREATE TABLE `tbl_meeting_interest_category`
(
    `category_type` VARCHAR(255) NOT NULL COMMENT 'category_type',
    PRIMARY KEY (`category_type`)
) COMMENT = 'meeting_interest_category';

DROP TABLE IF EXISTS `tbl_meeting_interest_relation`;

CREATE TABLE `tbl_meeting_interest_relation`
(
    `relation_id`   INT          NOT NULL COMMENT 'relation_id',
    `category_type` VARCHAR(255) NOT NULL COMMENT 'category_type',
    `meeting_id`    INT          NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`relation_id`)
) COMMENT = 'meeting_interest_relation';

DROP TABLE IF EXISTS `tbl_meeting_photo`;

CREATE TABLE `tbl_meeting_photo`
(
    `photo_id`   INT          NOT NULL COMMENT 'photo_id',
    `photo_url`  VARCHAR(255) NOT NULL COMMENT 'photo_url',
    `meeting_id` INT          NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`photo_id`)
) COMMENT = 'meeting_photo';

DROP TABLE IF EXISTS `tbl_meeting_participation`;

CREATE TABLE `tbl_meeting_participation`
(
    `participation_id` INT          NOT NULL COMMENT 'participation_id',
    `role`             VARCHAR(255) NOT NULL COMMENT 'role',
    `meeting_id`       INT          NOT NULL COMMENT 'meeting_id',
    `member_id`        INT          NOT NULL COMMENT 'member_id',
    PRIMARY KEY (`participation_id`)
) COMMENT = 'meeting_participation';

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

DROP TABLE IF EXISTS `tbl_bookmark`;

CREATE TABLE `tbl_bookmark`
(
    `bookmark_id` INT AUTO_INCREMENT COMMENT 'bookmark_id',
    `member_id`   INT NOT NULL COMMENT 'member_id',
    `meeting_id`  INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`bookmark_id`)
) COMMENT = 'bookmark';

DROP TABLE IF EXISTS `tbl_block`;

CREATE TABLE `tbl_block`
(
    `block_id`           INT      NOT NULL COMMENT 'block_id',
    `block_date`         DATETIME NOT NULL COMMENT 'block_date',
    `blocking_member_id` INT      NOT NULL COMMENT 'blocking_member_id',
    `blocked_member_id`  INT      NOT NULL COMMENT 'blocked_member_id',
    PRIMARY KEY (`block_id`)
) COMMENT = 'block';

DROP TABLE IF EXISTS `tbl_chatroom`;

CREATE TABLE `tbl_chatroom`
(
    `chatroom_id`  INT NOT NULL COMMENT 'chatroom_id',
    `status`       VARCHAR(255) COMMENT 'status',
    `created_date` DATETIME COMMENT 'created_date',
    `meeting_id`   INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`chatroom_id`)
) COMMENT = 'chatroom';

DROP TABLE IF EXISTS `tbl_chat_participation`;

CREATE TABLE `tbl_chat_participation`
(
    `member_id`   INT          NOT NULL COMMENT 'member_id',
    `chatroom_id` INT          NOT NULL COMMENT 'chatroom_id',
    `role`        VARCHAR(255) NOT NULL COMMENT 'role',
    PRIMARY KEY (`member_id`, `chatroom_id`)
) COMMENT = 'chat_participation';

DROP TABLE IF EXISTS `tbl_follow`;

CREATE TABLE `tbl_follow`
(
    `follow_id`    INT NOT NULL COMMENT 'follow_id',
    `following_id` INT NOT NULL COMMENT 'following_id',
    `follower_id`  INT NOT NULL COMMENT 'follower_id',
    PRIMARY KEY (`follow_id`)
) COMMENT = 'follow';

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

DROP TABLE IF EXISTS `tbl_tech_stack_type`;

CREATE TABLE `tbl_tech_stack_type`
(
    `stack_code` INT NOT NULL COMMENT 'stack_code',
    `stack_name` VARCHAR(255) COMMENT 'stack_name',
    PRIMARY KEY (`stack_code`)
) COMMENT = 'tech_stack_type';

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

DROP TABLE IF EXISTS `tbl_meeting`;

CREATE TABLE `tbl_meeting`
(
    `meeting_id`            INT          NOT NULL COMMENT 'meeting_id',
    `title`                 VARCHAR(255) NOT NULL COMMENT 'title',
    `location_name`         VARCHAR(255) NOT NULL COMMENT 'location_name',
    `location_latitude` DOUBLE NOT NULL COMMENT 'location_latitude',
    `location_longitude` DOUBLE NOT NULL COMMENT 'location_longitude',
    `introduction`          TEXT         NOT NULL COMMENT 'introduction',
    `payment_method`        VARCHAR(255) NOT NULL COMMENT 'payment_method',
    `meeting_type`          VARCHAR(255) NOT NULL COMMENT 'meeting_type',
    `scheduled_date`        DATE         NOT NULL COMMENT 'scheduled_date',
    `exit_restriction_time` TIME         NOT NULL COMMENT 'exit_restriction_time',
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

DROP TABLE IF EXISTS `tbl_meeting_interest_category`;

CREATE TABLE `tbl_meeting_interest_category`
(
    `category_type` VARCHAR(255) NOT NULL COMMENT 'category_type',
    PRIMARY KEY (`category_type`)
) COMMENT = 'meeting_interest_category';

DROP TABLE IF EXISTS `tbl_meeting_interest_relation`;

CREATE TABLE `tbl_meeting_interest_relation`
(
    `relation_id`   INT          NOT NULL COMMENT 'relation_id',
    `category_type` VARCHAR(255) NOT NULL COMMENT 'category_type',
    `meeting_id`    INT          NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`relation_id`)
) COMMENT = 'meeting_interest_relation';

DROP TABLE IF EXISTS `tbl_meeting_photo`;

CREATE TABLE `tbl_meeting_photo`
(
    `photo_id`   INT          NOT NULL COMMENT 'photo_id',
    `photo_url`  VARCHAR(255) NOT NULL COMMENT 'photo_url',
    `meeting_id` INT          NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`photo_id`)
) COMMENT = 'meeting_photo';

DROP TABLE IF EXISTS `tbl_meeting_participation`;

CREATE TABLE `tbl_meeting_participation`
(
    `participation_id` INT          NOT NULL COMMENT 'participation_id',
    `role`             VARCHAR(255) NOT NULL COMMENT 'role',
    `meeting_id`       INT          NOT NULL COMMENT 'meeting_id',
    `member_id`        INT          NOT NULL COMMENT 'member_id',
    PRIMARY KEY (`participation_id`)
) COMMENT = 'meeting_participation';

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

DROP TABLE IF EXISTS `tbl_bookmark`;

CREATE TABLE `tbl_bookmark`
(
    `bookmark_id` INT AUTO_INCREMENT COMMENT 'bookmark_id',
    `member_id`   INT NOT NULL COMMENT 'member_id',
    `meeting_id`  INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`bookmark_id`)
) COMMENT = 'bookmark';

DROP TABLE IF EXISTS `tbl_block`;

CREATE TABLE `tbl_block`
(
    `block_id`           INT      NOT NULL COMMENT 'block_id',
    `block_date`         DATETIME NOT NULL COMMENT 'block_date',
    `blocking_member_id` INT      NOT NULL COMMENT 'blocking_member_id',
    `blocked_member_id`  INT      NOT NULL COMMENT 'blocked_member_id',
    PRIMARY KEY (`block_id`)
) COMMENT = 'block';

DROP TABLE IF EXISTS `tbl_chatroom`;

CREATE TABLE `tbl_chatroom`
(
    `chatroom_id`  INT NOT NULL COMMENT 'chatroom_id',
    `status`       VARCHAR(255) COMMENT 'status',
    `created_date` DATETIME COMMENT 'created_date',
    `meeting_id`   INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`chatroom_id`)
) COMMENT = 'chatroom';

DROP TABLE IF EXISTS `tbl_chat_participation`;

CREATE TABLE `tbl_chat_participation`
(
    `member_id`   INT          NOT NULL COMMENT 'member_id',
    `chatroom_id` INT          NOT NULL COMMENT 'chatroom_id',
    `role`        VARCHAR(255) NOT NULL COMMENT 'role',
    PRIMARY KEY (`member_id`, `chatroom_id`)
) COMMENT = 'chat_participation';

DROP TABLE IF EXISTS `tbl_follow`;

CREATE TABLE `tbl_follow`
(
    `follow_id`    INT NOT NULL COMMENT 'follow_id',
    `following_id` INT NOT NULL COMMENT 'following_id',
    `follower_id`  INT NOT NULL COMMENT 'follower_id',
    PRIMARY KEY (`follow_id`)
) COMMENT = 'follow';

DROP TABLE IF EXISTS `tbl_member`;

CREATE TABLE `tbl_member`
(
    `member_id`           INT          NOT NULL AUTO_INCREMENT COMMENT 'member_id',
    `email`               VARCHAR(255) NOT NULL COMMENT 'email',
    `password`            VARCHAR(255) NOT NULL COMMENT 'password',
    `name`                VARCHAR(255) NOT NULL COMMENT 'name',
    `nickname`            VARCHAR(255) NOT NULL COMMENT 'nickname',
    `login_method`        VARCHAR(255) NOT NULL COMMENT 'login_method',
    `phone_number`        VARCHAR(255) COMMENT 'phone_number',
    `created_date`        DATETIME     NOT NULL COMMENT 'created_date',
    `withdrawal_status`   VARCHAR(255) NOT NULL COMMENT 'withdrawal_status',
    `reported_count`      INT DEFAULT 0 NULL COMMENT '누적 신고 횟수',
    `gender`              VARCHAR(255) NOT NULL COMMENT 'gender',
    `age`                 INT          NOT NULL COMMENT 'age',
    `is_stopped_by_admin` INT          NOT NULL COMMENT 'is_stopped_by_admin',

    PRIMARY KEY (`member_id`)
) COMMENT = 'member';

DROP TABLE IF EXISTS `tbl_member_tech_stack`;

CREATE TABLE `tbl_member_tech_stack`
(
    `stack_code` INT NOT NULL COMMENT 'stack_code',
    `member_id`  INT NOT NULL COMMENT 'member_id'
) COMMENT = 'member_tech_stack';

DROP TABLE IF EXISTS `tbl_member_photo`;

CREATE TABLE `tbl_member_photo`
(
    `photo_id`  INT          NOT NULL COMMENT 'photo_id',
    `photo_url` VARCHAR(255) NOT NULL COMMENT 'photo_url',
    `member_id` INT          NOT NULL COMMENT 'member_id',
    PRIMARY KEY (`photo_id`)
) COMMENT = 'member_photo';

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


-- 예시 데이터 삽입 스크립트

-- 관리자 테이블 데이터 삽입
INSERT INTO `tbl_admin` (`admin_id`, `email`, `password`, `created_date`)
VALUES (1, 'admin1@example.com', 'password1', '2024-01-01 10:00:00'),
       (2, 'admin2@example.com', 'password2', '2024-01-02 11:00:00');

-- 기술스택종류 테이블 데이터 삽입
INSERT INTO `tbl_tech_stack_type` (`stack_code`, `stack_name`)
VALUES (1, 'JavaScript'),
       (2, 'Python'),
       (3, 'Java'),
       (4, 'C#'),
       (5, 'Ruby'),
       (6, 'PHP'),
       (7, 'Swift'),
       (8, 'Kotlin'),
       (9, 'Go'),
       (10, 'Rust');

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

-- 모임 테이블 데이터 삽입
INSERT INTO `tbl_meeting` (`meeting_id`, `title`, `location_name`, `location_latitude`,
                           `location_longitude`, `introduction`, `payment_method`, `meeting_type`,
                           `scheduled_date`, `exit_restriction_time`, `recruitment_number`,
                           `gender`, `eligible_age`, `created_date`, `participation_method`,
                           `status`, `end_date`, `host_member_id`)
VALUES (1, 'Study Group', 'Library', 37.5665, 126.9780, 'Study together', 'Free', 'Study',
        '2024-08-01', '22:00:00', 10, 'Mixed', '18-25', '2024-07-01 10:00:00', 'Online', 'Open',
        '2024-08-01 22:00:00', 1),
       (2, 'Running Club', 'Park', 37.5665, 126.9780, 'Morning runs', 'Free', 'Sports',
        '2024-08-02', '07:00:00', 20, 'Mixed', '20-30', '2024-07-02 11:00:00', 'Offline', 'Open',
        '2024-08-02 07:00:00', 2),
       (3, 'Music Band', 'Studio', 37.5665, 126.9780, 'Play music', 'Paid', 'Music', '2024-08-03',
        '18:00:00', 5, 'Mixed', '18-35', '2024-07-03 12:00:00', 'Offline', 'Open',
        '2024-08-03 18:00:00', 3),
       (4, 'Coding Bootcamp', 'Office', 37.5665, 126.9780, 'Learn to code', 'Paid', 'Study',
        '2024-08-04', '09:00:00', 15, 'Mixed', '20-40', '2024-07-04 13:00:00', 'Online', 'Open',
        '2024-08-04 09:00:00', 4),
       (5, 'Book Club', 'Cafe', 37.5665, 126.9780, 'Discuss books', 'Free', 'Study', '2024-08-05',
        '15:00:00', 8, 'Mixed', '25-35', '2024-07-05 14:00:00', 'Offline', 'Open',
        '2024-08-05 15:00:00', 5),
       (6, 'Yoga Class', 'Gym', 37.5665, 126.9780, 'Yoga practice', 'Paid', 'Sports', '2024-08-06',
        '06:00:00', 12, 'Female', '18-45', '2024-07-06 15:00:00', 'Offline', 'Open',
        '2024-08-06 06:00:00', 6),
       (7, 'Photography Workshop', 'Studio', 37.5665, 126.9780, 'Learn photography', 'Paid', 'Art',
        '2024-08-07', '10:00:00', 10, 'Mixed', '18-50', '2024-07-07 16:00:00', 'Offline', 'Open',
        '2024-08-07 10:00:00', 7),
       (8, 'Cooking Class', 'Kitchen', 37.5665, 126.9780, 'Cook together', 'Paid', 'Lifestyle',
        '2024-08-08', '17:00:00', 6, 'Mixed', '20-60', '2024-07-08 17:00:00', 'Offline', 'Open',
        '2024-08-08 17:00:00', 8),
       (9, 'Language Exchange', 'Cafe', 37.5665, 126.9780, 'Exchange languages', 'Free', 'Study',
        '2024-08-09', '19:00:00', 20, 'Mixed', '18-30', '2024-07-09 18:00:00', 'Offline', 'Open',
        '2024-08-09 19:00:00', 9),
       (10, 'Dance Class', 'Hall', 37.5665, 126.9780, 'Learn to dance', 'Paid', 'Art', '2024-08-10',
        '20:00:00', 15, 'Mixed', '18-40', '2024-07-10 19:00:00', 'Offline', 'Open',
        '2024-08-10 20:00:00', 10);

-- 모임관심분야 테이블 데이터 삽입
INSERT INTO `tbl_meeting_interest_category` (`category_type`)
VALUES ('Technology'),
       ('Sports'),
       ('Music'),
       ('Art'),
       ('Lifestyle'),
       ('Education'),
       ('Fitness'),
       ('Health'),
       ('Travel'),
       ('Food');

-- 모임관심연관 테이블 데이터 삽입
INSERT INTO `tbl_meeting_interest_relation` (`relation_id`, `category_type`, `meeting_id`)
VALUES (1, 'Education', 1),
       (2, 'Fitness', 2),
       (3, 'Music', 3),
       (4, 'Education', 4),
       (5, 'Education', 5),
       (6, 'Fitness', 6),
       (7, 'Art', 7),
       (8, 'Lifestyle', 8),
       (9, 'Education', 9),
       (10, 'Art', 10);

-- 모임사진 테이블 데이터 삽입
INSERT INTO `tbl_meeting_photo` (`photo_id`, `photo_url`, `meeting_id`)
VALUES (1, 'photo1.jpg', 1),
       (2, 'photo2.jpg', 2),
       (3, 'photo3.jpg', 3),
       (4, 'photo4.jpg', 4),
       (5, 'photo5.jpg', 5),
       (6, 'photo6.jpg', 6),
       (7, 'photo7.jpg', 7),
       (8, 'photo8.jpg', 8),
       (9, 'photo9.jpg', 9),
       (10, 'photo10.jpg', 10);

-- 모임참여 테이블 데이터 삽입
INSERT INTO `tbl_meeting_participation` (`participation_id`, `role`, `meeting_id`, `member_id`)
VALUES (1, 'Host', 1, 1),
       (2, 'Participant', 1, 2),
       (3, 'Host', 2, 3),
       (4, 'Participant', 2, 4),
       (5, 'Host', 3, 5),
       (6, 'Participant', 3, 6),
       (7, 'Host', 4, 7),
       (8, 'Participant', 4, 8),
       (9, 'Host', 5, 9),
       (10, 'Participant', 5, 10);

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

-- 차단 테이블 데이터 삽입
INSERT INTO `tbl_block` (`block_id`, `block_date`, `blocking_member_id`, `blocked_member_id`)
VALUES (1, '2024-07-01 10:00:00', 1, 2),
       (2, '2024-07-02 11:00:00', 2, 3),
       (3, '2024-07-03 12:00:00', 3, 4),
       (4, '2024-07-04 13:00:00', 4, 5),
       (5, '2024-07-05 14:00:00', 5, 6),
       (6, '2024-07-06 15:00:00', 6, 7),
       (7, '2024-07-07 16:00:00', 7, 8),
       (8, '2024-07-08 17:00:00', 8, 9),
       (9, '2024-07-09 18:00:00', 9, 10),
       (10, '2024-07-10 19:00:00', 10, 1);

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

-- 팔로우 테이블 데이터 삽입
INSERT INTO `tbl_follow` (`follow_id`, `following_id`, `follower_id`)
VALUES (1, 1, 2),
       (2, 2, 3),
       (3, 3, 4),
       (4, 4, 5),
       (5, 5, 6),
       (6, 6, 7),
       (7, 7, 8),
       (8, 8, 9),
       (9, 9, 10),
       (10, 10, 1);

-- 회원 테이블 데이터 삽입
INSERT INTO `tbl_member` (`member_id`, `email`, `password`, `name`, `nickname`, `login_method`, `phone_number`,
                          `created_date`, `withdrawal_status`, `reported_count`, `gender`, `age`, `is_stopped_by_admin`)
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

-- 회원사진 테이블 데이터 삽입
INSERT INTO `tbl_member_photo` (`photo_id`, `photo_url`, `member_id`)
VALUES (1, 'user1_photo.jpg', 1),
       (2, 'user2_photo.jpg', 2),
       (3, 'user3_photo.jpg', 3),
       (4, 'user4_photo.jpg', 4),
       (5, 'user5_photo.jpg', 5),
       (6, 'user6_photo.jpg', 6),
       (7, 'user7_photo.jpg', 7),
       (8, 'user8_photo.jpg', 8),
       (9, 'user9_photo.jpg', 9),
       (10, 'user10_photo.jpg', 10);

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