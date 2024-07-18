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
INSERT INTO `tbl_member` (`member_id`, `email`, `password`, `name`, `nickname`, `login_method`,
                          `phone_number`, `created_date`, `withdrawal_status`)
VALUES (1, 'user1@example.com', 'password1', 'User One', 'user1', 'email', '010-1234-5678',
        '2024-07-01 10:00:00', 'N'),
       (2, 'user2@example.com', 'password2', 'User Two', 'user2', 'email', '010-2345-6789',
        '2024-07-02 11:00:00', 'N'),
       (3, 'user3@example.com', 'password3', 'User Three', 'user3', 'email', '010-3456-7890',
        '2024-07-03 12:00:00', 'N'),
       (4, 'user4@example.com', 'password4', 'User Four', 'user4', 'email', '010-4567-8901',
        '2024-07-04 13:00:00', 'N'),
       (5, 'user5@example.com', 'password5', 'User Five', 'user5', 'email', '010-5678-9012',
        '2024-07-05 14:00:00', 'N'),
       (6, 'user6@example.com', 'password6', 'User Six', 'user6', 'email', '010-6789-0123',
        '2024-07-06 15:00:00', 'N'),
       (7, 'user7@example.com', 'password7', 'User Seven', 'user7', 'email', '010-7890-1234',
        '2024-07-07 16:00:00', 'N'),
       (8, 'user8@example.com', 'password8', 'User Eight', 'user8', 'email', '010-8901-2345',
        '2024-07-08 17:00:00', 'N'),
       (9, 'user9@example.com', 'password9', 'User Nine', 'user9', 'email', '010-9012-3456',
        '2024-07-09 18:00:00', 'N'),
       (10, 'user10@example.com', 'password10', 'User Ten', 'user10', 'email', '010-0123-4567',
        '2024-07-10 19:00:00', 'N');

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
VALUES (1, 'Great event!', '2024-07-01 10:00:00', 1, 2, 1),
       (2, 'Had a wonderful time.', '2024-07-02 11:00:00', 2, 3, 2),
       (3, 'Very informative.', '2024-07-03 12:00:00', 3, 4, 3),
       (4, 'Enjoyed it a lot.', '2024-07-04 13:00:00', 4, 5, 4),
       (5, 'Learned a lot.', '2024-07-05 14:00:00', 5, 6, 5),
       (6, 'Highly recommended.', '2024-07-06 15:00:00', 6, 7, 6),
       (7, 'Will join again.', '2024-07-07 16:00:00', 7, 8, 7),
       (8, 'Amazing experience.', '2024-07-08 17:00:00', 8, 9, 8),
       (9, 'Fun and engaging.', '2024-07-09 18:00:00', 9, 10, 9),
       (10, 'Absolutely loved it.', '2024-07-10 19:00:00', 10, 1, 10);