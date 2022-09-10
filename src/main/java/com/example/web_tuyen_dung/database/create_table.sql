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
    staff_name        varchar(100) not null,
    company_name      varchar(100) not null,
    type_of_business  int          null,
    url               varchar(500) null,
    tel               varchar(100) null,
    prefecture_id     int          null,
    address           varchar(600) null,
    description       longtext     null,
    employee_quantity int          null,
    avatar            varchar(500) null,
    cover_image       varchar(500) null,
    foreign key (user_id) references user (id)
);

create table candidate
(
    id                    bigint auto_increment primary key,
    user_id               bigint,
    full_name             varchar(100) not null,
    avatar                varchar(500) not null,
    birthdate             date         null,
    current_prefecture_id int          null,
    height                int          null,
    weight                int          null,
    special_skill         varchar(500) null,
    year_exp              int          null,
    tel                   varchar(100) null,
    gender                varchar(10)  null,
    image2                varchar(500) null,
    image3                varchar(500) null,
    image4                varchar(500) null,
    youtube_name          varchar(100) null,
    twitter_name          varchar(100) null,
    instagram_name        varchar(100) null,
    is_open_profile       boolean      not null,
    foreign key (user_id) references user (id)
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