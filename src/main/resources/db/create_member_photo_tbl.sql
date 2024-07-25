DROP TABLE IF EXISTS `TBL_MEMBER_PHOTO`;

CREATE TABLE tbl_member_photo
(
    photo_id   INT          NOT NULL AUTO_INCREMENT COMMENT 'photo_id' PRIMARY KEY,
    photo_path VARCHAR(255) NOT NULL COMMENT 'photo_path',
    photo_name VARCHAR(255) NOT NULL COMMENT 'photo_name',
    member_id  INT          NOT NULL COMMENT 'member_id',
    UNIQUE (member_id)
) COMMENT 'member_photo';