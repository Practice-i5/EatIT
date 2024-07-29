DROP TABLE IF EXISTS `TBL_MEETING_PHOTO`;

create table tbl_meeting_photo
(
    photo_id   int          not null auto_increment comment 'photo_id' primary key,
    photo_path varchar(255) not null comment 'photo_path',
    photo_name varchar(255) not null comment 'photo_name',
    meeting_id int          not null comment 'meeting_id',
    UNIQUE (meeting_id)
) comment 'meeting_photo';



INSERT INTO tbl_meeting_photo (photo_id, photo_path, photo_name, meeting_id)
VALUES
    (11, '/img/meeting/meetingImage1.png', 'meetingImage1.png', 1),
    (12, '/img/meeting/meetingImage2.png', 'meetingImage2.png', 2),
    (13, '/img/meeting/meetingImage3.png', 'meetingImage3.png', 3),
    (14, '/img/meeting/meetingImage4.png', 'meetingImage4.png', 4),
    (15, '/img/meeting/meetingImage5.png', 'meetingImage5.png', 5),
    (16, '/img/meeting/meetingImage6.png', 'meetingImage6.png', 6),
    (17, '/img/meeting/meetingImage7.png', 'meetingImage7.png', 7),
    (18, '/img/ade.png', 'ade.png', 8),
    (19, '/img/crople.png', 'crople.png', 9),
    (20, '/img/main1.png', 'main1.png', 10);


