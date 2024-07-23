DROP TABLE IF EXISTS `TBL_TECH_STACK_TYPE`

create table tbl_tech_stack_type
(
    stack_code int not null comment 'stack_code'
        primary key auto_increment,
    stack_name varchar(255) null comment 'stack_name',
    UNIQUE KEY unique_stack_name (stack_name)
)
    comment 'tech_stack_type';

