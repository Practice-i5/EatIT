DROP TABLE IF EXISTS `TBL_MEMBER_PHOTO`;

create table tbl_member_photo
(
    photo_id  int not null auto_increment comment 'photo_id' primary key,
    photo_path varchar(255) not null comment 'photo_path',
    photo_name varchar(255) not null comment 'photo_name',
    member_id int not null comment 'member_id'
)
    comment 'member_photo';