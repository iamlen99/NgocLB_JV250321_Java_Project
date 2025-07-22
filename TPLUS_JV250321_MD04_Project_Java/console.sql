create schema academy_db;

use academy_db;

create table admin
(
    id       int auto_increment primary key,
    username varchar(50)  not null unique,
    password varchar(255) not null
);

create table student
(
    id        int auto_increment primary key,
    name      varchar(100) not null,
    dob       date         not null,
    email     varchar(100) not null unique,
    sex       bit          not null,
    phone     varchar(20),
    password  varchar(255) not null,
    create_at date
);

DELIMITER $$
create trigger auto_set_create_at_in_student
    before insert
    on student
    for each row
begin
    if new.create_at is null then
        set new.create_at = current_date;
    end if;
end $$
DELIMITER ;

create table course
(
    id         int auto_increment primary key,
    name       varchar(100) not null,
    duration   int          not null check ( duration > 0 ),
    instructor varchar(100) not null,
    create_at  date
);

DELIMITER $$
create trigger auto_set_create_at_in_course
    before insert
    on course
    for each row
begin
    if new.create_at is null then
        set new.create_at = current_date;
    end if;
end $$
DELIMITER ;

create table enrollment
(
    id         int auto_increment primary key,
    student_id       int not null,
    course_id       int not null,
    registered_at  datetime default current_timestamp,
    status enum('WAITING', 'DENIED', 'CANCEL', 'CONFIRM') default 'WAITING',
    foreign key (student_id) references student (id) on delete cascade ,
    foreign key (course_id) references course (id) on delete cascade
);

INSERT INTO admin (username, password) VALUES
                                           ('admin1', 'admin123'),
                                           ('superadmin', 'securepass');

INSERT INTO student (name, dob, email, sex, phone, password)
VALUES
    ('Nguyen Van A', '2000-01-01', 'a.nguyen@example.com', 1, '0912345678', 'pass123'),
    ('Tran Thi B', '1999-05-20', 'b.tran@example.com', 0, '0987654321', 'abcxyz'),
    ('Le Van C', '2001-07-15', 'c.le@example.com', 1, '0909090909', 'qwerty');

INSERT INTO course (name, duration, instructor)
VALUES
    ('Java Programming', 60, 'Mr. Dinh'),
    ('Web Development', 45, 'Ms. Hoa'),
    ('Database Design', 30, 'Mr. Tuan');

INSERT INTO enrollment (student_id, course_id, status)
VALUES
    (1, 1, 'CONFIRM'),
    (1, 2, 'WAITING'),
    (2, 1, 'CANCEL'),
    (3, 3, 'CONFIRM');
