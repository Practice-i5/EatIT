CREATE TABLE tbl_member_experience (
    experience_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT NOT NULL ,
    company_name VARCHAR(50) NOT NULL ,
    description VARCHAR(255) NOT NULL ,
    start_date DATE NOT NULL ,
    end_date DATE
);