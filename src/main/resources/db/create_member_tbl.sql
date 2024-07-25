-- create_member_tbl.sql

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