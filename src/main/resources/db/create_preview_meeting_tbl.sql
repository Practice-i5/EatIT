DROP TABLE preview_meeting;

CREATE TABLE preview_meeting (
                            meeting_id INT PRIMARY KEY,
                            title VARCHAR(255),
                            location_name VARCHAR(255),
                            meeting_image_url VARCHAR(255),
                            host_image_url VARCHAR(255),
                            status VARCHAR(50),
                            scheduled_date TIMESTAMP,
                            recruit_member_number INT,
                            recruitment_number INT
);
