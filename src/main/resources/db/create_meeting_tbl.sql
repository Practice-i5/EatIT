DROP TABLE IF EXISTS `tbl_meeting`;

CREATE TABLE `tbl_meeting`
(
    `meeting_id` INT NOT NULL AUTO_INCREMENT COMMENT 'meeting_id',
    `title` VARCHAR(255) NOT NULL COMMENT 'title',
    `location_name` VARCHAR(255) NOT NULL COMMENT 'location_name',
    `location_latitude` DOUBLE NOT NULL COMMENT 'location_latitude',
    `location_longitude` DOUBLE NOT NULL COMMENT 'location_longitude',
    `introduction` TEXT NOT NULL COMMENT 'introduction',
    `payment_method` VARCHAR(255) NOT NULL COMMENT 'payment_method',
    `meeting_type` VARCHAR(255) NOT NULL COMMENT 'meeting_type',
    `interests` VARCHAR(255) NOT NULL COMMENT 'interests',
    `scheduled_date` DATETIME NOT NULL COMMENT 'scheduled_date', -- fix type DATE -> DATETIEM
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