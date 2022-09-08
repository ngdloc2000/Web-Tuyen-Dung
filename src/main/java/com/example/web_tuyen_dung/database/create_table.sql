use web_tuyen_dung;

create table account
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
    auth_provider     varchar(15)  null,
    constraint client_ibfk_1
        foreign key (user_id) references account (id)
);

create table offer
(
    id                         bigint auto_increment primary key,
    client_id                  bigint        not null,
    offer_name                 varchar(1000) not null,
    offer_type                 tinyint       not null comment 'Loại offer: 0: Tuyển dụng, 1: Chỉ định',
    approval_status            tinyint       not null comment 'Trạng thái phê duyệt: 1: Đang chờ xử lý, 2: Đã phê duyệt, 3: Từ chối, 4: Đã rút',
    number_of_vacancies        int           null,
    recruitment_start_datetime datetime      not null,
    recruitment_end_datetime   datetime      not null,
    work_prefecture_id         varchar(100)  not null comment 'Danh sách các tỉnh của nơi làm việc',
    recruitment_age_min        int           not null,
    recruitment_age_max        int           not null,
    recruitment_notes          varchar(1000) not null,
    interview_datetime         datetime      not null,
    gender                     tinyint(1)    not null comment 'Giới tính: 1: Nữ, 2: Nam, 3: Tất cả',
    cast_preparation_detail    text          null,
    salary                     int           null,
    delete_flg                 tinyint(1)    not null comment 'Client rút thì delete_flg = 1 và approval_status = 4'
)