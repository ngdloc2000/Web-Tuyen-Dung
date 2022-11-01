DROP TABLE IF EXISTS users;
create table users
(
    id       bigint primary key generated always as
        IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999 CACHE 1 ),
    username varchar(500) not null,
    password varchar(500) not null,
    type     varchar(20)  not null,
    status   varchar(20)  not null
);

DROP TABLE IF EXISTS company;
create table company
(
    id                bigint primary key generated always as
        IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999 CACHE 1 ),
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
    cover_image       varchar(500)  null
);

DROP TABLE IF EXISTS candidate;
create table candidate
(
    id              bigint primary key generated always as
        IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999 CACHE 1 ),
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
    is_open_profile boolean      not null
);

DROP TABLE IF EXISTS job;
create table job
(
    id                         bigint primary key generated always as
        IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999 CACHE 1 ),
    company_id                 bigint        not null,
    name                       varchar(1000) not null,
    approval_status            varchar(100)  not null,
    recruitment_start_datetime timestamp     not null,
    recruitment_end_datetime   timestamp     not null,
    work_place                 varchar(1000) not null,
    recruitment_age_min        int           not null,
    recruitment_age_max        int           not null,
    job_description            varchar(1000) not null,
    gender                     varchar(100)  not null,
    salary                     int           null
)