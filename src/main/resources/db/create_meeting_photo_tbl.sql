DROP TABLE IF EXISTS `TBL_MEETING_PHOTO`;

create table tbl_meeting_photo
(
    photo_id   int          not null auto_increment comment 'photo_id' primary key,
    photo_path varchar(255) not null comment 'photo_path',
    photo_name varchar(255) not null comment 'photo_name',
    meeting_id int          not null comment 'meeting_id'
) comment 'meeting_photo';