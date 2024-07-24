DROP TABLE IF EXISTS `TBL_FOLLOW`;

CREATE TABLE tbl_follow
(
    follow_id INT NOT NULL AUTO_INCREMENT COMMENT 'follow_id' PRIMARY KEY,
    follower_id INT NOT NULL COMMENT '팔로우를 하는 사람',
    followee_id INT NOT NULL COMMENT '팔로우를 받는 사람',
    follow_date DATETIME NOT NULL COMMENT 'follow_date',
    UNIQUE KEY unique_follow (follower_id, followee_id)
)
    COMMENT 'follow';