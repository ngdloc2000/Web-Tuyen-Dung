use web_tuyen_dung;

create table user
(
    id       bigint auto_increment
        primary key,
    email    varchar(500) not null,
    password varchar(500) not null,
    type_id  int          not null comment 'Loại người dùng: 0: Admin, 1: client, 2: model',
    status   int          not null comment 'Trạng thái người dùng: 0: Đang chờ xác minh, 1: Đã kích hoạt, 2: Chặn',
    constraint email
        unique (email, status)
);

create table client
(
    user_id           bigint auto_increment
        primary key,
    staff_name        varchar(100) not null,
    company_name      varchar(100) not null,
    type_of_business  int          null,
    url               varchar(500) null,
    tel               varchar(100) null,
    prefecture_id     int          null,
    address           varchar(600) null,
    description       longtext     null,
    employee_quantity tinyint      null comment 'SL nhân viên: 0: 50-100, 1: 100-250, 2: 250-500, 3: 500+',
    avatar            varchar(500) null,
    cover_image       varchar(500) null,
    constraint client_ibfk_1
        foreign key (user_id) references user (id)
);
