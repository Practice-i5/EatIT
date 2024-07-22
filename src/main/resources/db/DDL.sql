-- 테이블 생성 스크립트
DROP TABLE IF EXISTS `tbl_admin`;

CREATE TABLE `tbl_admin`
(
    `admin_id` INT NOT NULL COMMENT 'admin_id',
    `email` VARCHAR(255) NOT NULL COMMENT 'email',
    `password` VARCHAR(255) NOT NULL COMMENT 'password',
    `created_date` DATETIME NOT NULL COMMENT 'created_date',
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
    `message_id` INT NOT NULL COMMENT 'message_id',
    `message_order` INT NOT NULL COMMENT 'message_order',
    `message_type` VARCHAR(255) COMMENT 'message_type',
    `message_content` TEXT COMMENT 'message_content',
    `member_id` INT NOT NULL COMMENT 'member_id',
    `chatroom_id` INT NOT NULL COMMENT 'chatroom_id',
    PRIMARY KEY (`message_id`)
) COMMENT = 'message';

DROP TABLE IF EXISTS `tbl_meeting`;

CREATE TABLE `tbl_meeting`
(
    `meeting_id` INT NOT NULL COMMENT 'meeting_id',
    `title` VARCHAR(255) NOT NULL COMMENT 'title',
    `location_name` VARCHAR(255) NOT NULL COMMENT 'location_name',
    `location_latitude` DOUBLE NOT NULL COMMENT 'location_latitude',
    `location_longitude` DOUBLE NOT NULL COMMENT 'location_longitude',
    `introduction` TEXT NOT NULL COMMENT 'introduction',
    `payment_method` VARCHAR(255) NOT NULL COMMENT 'payment_method',
    `meeting_type` VARCHAR(255) NOT NULL COMMENT 'meeting_type',
    `scheduled_date` DATE NOT NULL COMMENT 'scheduled_date',
    `exit_restriction_time` TIME NOT NULL COMMENT 'exit_restriction_time',
    `recruitment_number` INT NOT NULL COMMENT 'recruitment_number',
    `gender` VARCHAR(255) NOT NULL COMMENT 'gender',
    `eligible_age` VARCHAR(255) NOT NULL COMMENT 'eligible_age',
    `created_date` DATETIME NOT NULL COMMENT 'created_date',
    `participation_method` VARCHAR(255) NOT NULL COMMENT 'participation_method',
    `status` VARCHAR(255) NOT NULL COMMENT 'status',
    `end_date` DATETIME COMMENT 'end_date',
    `host_member_id` INT NOT NULL COMMENT 'host_member_id',
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
    `relation_id` INT NOT NULL COMMENT 'relation_id',
    `category_type` VARCHAR(255) NOT NULL COMMENT 'category_type',
    `meeting_id` INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`relation_id`)
) COMMENT = 'meeting_interest_relation';

DROP TABLE IF EXISTS `tbl_meeting_photo`;

CREATE TABLE `tbl_meeting_photo`
(
    `photo_id` INT NOT NULL COMMENT 'photo_id',
    `photo_url` VARCHAR(255) NOT NULL COMMENT 'photo_url',
    `meeting_id` INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`photo_id`)
) COMMENT = 'meeting_photo';

DROP TABLE IF EXISTS `tbl_meeting_participation`;

CREATE TABLE `tbl_meeting_participation`
(
    `participation_id` INT NOT NULL COMMENT 'participation_id',
    `role` VARCHAR(255) NOT NULL COMMENT 'role',
    `meeting_id` INT NOT NULL COMMENT 'meeting_id',
    `member_id` INT NOT NULL COMMENT 'member_id',
    PRIMARY KEY (`participation_id`)
) COMMENT = 'meeting_participation';

DROP TABLE IF EXISTS `tbl_notification`;

CREATE TABLE `tbl_notification`
(
    `notification_id` INT NOT NULL COMMENT 'notification_id',
    `notification_content` TEXT NOT NULL COMMENT 'notification_content',
    `created_date` DATETIME NOT NULL COMMENT 'created_date',
    `member_id` INT NOT NULL COMMENT 'member_id',
    `participation_id` INT NOT NULL COMMENT 'participation_id',
    `status` VARCHAR(255) COMMENT 'status',
    PRIMARY KEY (`notification_id`)
) COMMENT = 'notification';

DROP TABLE IF EXISTS `tbl_bookmark`;

CREATE TABLE `tbl_bookmark`
(
    `bookmark_id` INT AUTO_INCREMENT COMMENT 'bookmark_id',
    `member_id` INT NOT NULL COMMENT 'member_id',
    `meeting_id` INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`bookmark_id`)
) COMMENT = 'bookmark';

DROP TABLE IF EXISTS `tbl_block`;

CREATE TABLE `tbl_block`
(
    `block_id` INT NOT NULL COMMENT 'block_id',
    `block_date` DATETIME NOT NULL COMMENT 'block_date',
    `blocking_member_id` INT NOT NULL COMMENT 'blocking_member_id',
    `blocked_member_id` INT NOT NULL COMMENT 'blocked_member_id',
    PRIMARY KEY (`block_id`)
) COMMENT = 'block';

DROP TABLE IF EXISTS `tbl_chatroom`;

CREATE TABLE `tbl_chatroom`
(
    `chatroom_id` INT NOT NULL COMMENT 'chatroom_id',
    `status` VARCHAR(255) COMMENT 'status',
    `created_date` DATETIME COMMENT 'created_date',
    `meeting_id` INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`chatroom_id`)
) COMMENT = 'chatroom';

DROP TABLE IF EXISTS `tbl_chat_participation`;

CREATE TABLE `tbl_chat_participation`
(
    `member_id` INT NOT NULL COMMENT 'member_id',
    `chatroom_id` INT NOT NULL COMMENT 'chatroom_id',
    `role` VARCHAR(255) NOT NULL COMMENT 'role',
    PRIMARY KEY (`member_id`, `chatroom_id`)
) COMMENT = 'chat_participation';

DROP TABLE IF EXISTS `tbl_follow`;

CREATE TABLE `tbl_follow`
(
    `follow_id` INT NOT NULL COMMENT 'follow_id',
    `following_id` INT NOT NULL COMMENT 'following_id',
    `follower_id` INT NOT NULL COMMENT 'follower_id',
    PRIMARY KEY (`follow_id`)
) COMMENT = 'follow';

DROP TABLE IF EXISTS `tbl_member`;

CREATE TABLE `tbl_member`
(
    `member_id` INT NOT NULL COMMENT 'member_id',
    `email` VARCHAR(255) NOT NULL COMMENT 'email',
    `password` VARCHAR(255) NOT NULL COMMENT 'password',
    `name` VARCHAR(255) NOT NULL COMMENT 'name',
    `nickname` VARCHAR(255) NOT NULL COMMENT 'nickname',
    `login_method` VARCHAR(255) NOT NULL COMMENT 'login_method',
    `phone_number` VARCHAR(255) COMMENT 'phone_number',
    `created_date` DATETIME NOT NULL COMMENT 'created_date',
    `withdrawal_status` VARCHAR(255) NOT NULL COMMENT 'withdrawal_status',
    `reported_count` INT DEFAULT 0 NULL COMMENT '누적 신고 횟수',
    PRIMARY KEY (`member_id`)
) COMMENT = 'member';

DROP TABLE IF EXISTS `tbl_member_tech_stack`;

CREATE TABLE `tbl_member_tech_stack`
(
    `stack_code` INT NOT NULL COMMENT 'stack_code',
    `member_id` INT NOT NULL COMMENT 'member_id'
) COMMENT = 'member_tech_stack';

DROP TABLE IF EXISTS `tbl_member_photo`;

CREATE TABLE `tbl_member_photo`
(
    `photo_id` INT NOT NULL COMMENT 'photo_id',
    `photo_url` VARCHAR(255) NOT NULL COMMENT 'photo_url',
    `member_id` INT NOT NULL COMMENT 'member_id',
    PRIMARY KEY (`photo_id`)
) COMMENT = 'member_photo';

DROP TABLE IF EXISTS `tbl_review`;

CREATE TABLE `tbl_review`
(
    `review_id` INT NOT NULL COMMENT 'review_id',
    `review_content` TEXT COMMENT 'review_content',
    `created_date` DATETIME COMMENT 'created_date',
    `reviewer_id` INT NOT NULL COMMENT 'reviewer_id',
    `reviewee_id` INT NOT NULL COMMENT 'reviewee_id',
    `meeting_id` INT NOT NULL COMMENT 'meeting_id',
    PRIMARY KEY (`review_id`)
) COMMENT = 'review';