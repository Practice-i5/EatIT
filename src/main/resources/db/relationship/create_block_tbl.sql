DROP TABLE IF EXISTS `TBL_BLOCK`;

CREATE TABLE `TBL_BLOCK`
(
    `block_id`           INT      NOT NULL AUTO_INCREMENT COMMENT 'block_id',
    `block_date`         DATETIME NOT NULL COMMENT 'block_date',
    `blocking_member_id` INT      NOT NULL COMMENT '차단을 하는 사람',
    `blocked_member_id`  INT      NOT NULL COMMENT '차단을 당하는 사람',
    PRIMARY KEY (`block_id`),
    UNIQUE KEY `unique_block` (`blocking_member_id`, `blocked_member_id`)
) COMMENT='block';