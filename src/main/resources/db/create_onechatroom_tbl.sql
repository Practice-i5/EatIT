DROP TABLE IF EXISTS `tbl_onechatroom`;

CREATE TABLE tbl_onechatroom (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 name VARCHAR(255) NOT NULL,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
