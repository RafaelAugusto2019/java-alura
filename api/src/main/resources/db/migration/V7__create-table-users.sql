create table users(

    id bigint not null auto_increment,
    user varchar(11) not null unique,
    password varchar(255) not null,

primary key(id));