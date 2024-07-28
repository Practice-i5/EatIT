CREATE DATABASE eatitdb;

USE eatitdb;

CREATE TABLE tbl_groupChatroom (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tbl_chatmessages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT NOT NULL,
    sender VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    timestamp BIGINT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES tbl_groupChatroom(id)
);
