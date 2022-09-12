use web_tuyen_dung;

create table user
(
    id       bigint auto_increment
        primary key,
    username varchar(500) not null,
    password varchar(500) not null,
    type     varchar(20)  not null,
    status   varchar(20)  not null
);

create table company
(
    id                bigint auto_increment primary key,
    user_id           bigint,
    staff_name        varchar(100)  not null,
    company_name      varchar(100)  not null,
    type_of_business  varchar(100)  null,
    url               varchar(500)  null,
    tel               varchar(100)  null,
    city              varchar(100)  null,
    address           varchar(600)  null,
    description       varchar(1000) null,
    employee_quantity int           null,
    avatar            varchar(500)  null,
    cover_image       varchar(500)  null,
    foreign key (user_id) references user (id)
);

create table candidate
(
    id              bigint auto_increment primary key,
    user_id         bigint,
    full_name       varchar(100) not null,
    avatar          varchar(500) not null,
    birthdate       date         null,
    city            varchar(100) null,
    height          int          null,
    weight          int          null,
    special_skill   varchar(500) null,
    year_exp        int          null,
    tel             varchar(100) null,
    gender          varchar(10)  null,
    image2          varchar(500) null,
    image3          varchar(500) null,
    image4          varchar(500) null,
    youtube_name    varchar(100) null,
    twitter_name    varchar(100) null,
    instagram_name  varchar(100) null,
    is_open_profile boolean      not null,
    foreign key (user_id) references user (id)
);

create table job
(
    id                         bigint auto_increment primary key,
    company_id                 bigint        not null,
    name                       varchar(1000) not null,
    approval_status            varchar(100)  not null comment 'Trạng thái phê duyệt: Đang chờ xử lý, Đã phê duyệt, Từ chối, Đã rút',
    recruitment_start_datetime datetime      not null,
    recruitment_end_datetime   datetime      not null,
    work_place                 varchar(1000) not null comment 'Danh sách các tỉnh của nơi làm việc',
    recruitment_age_min        int           not null,
    recruitment_age_max        int           not null,
    job_description            varchar(1000) not null,
    interview_datetime         datetime      not null,
    gender                     varchar(100)  not null comment 'Giới tính: 1: Nữ, 2: Nam, 3: Tất cả',
    salary                     int           null,
    foreign key (company_id) references company (user_id)
)