create table patients(

    cpf varchar(11) not null unique,
    name varchar(100) not null,
    email varchar(100) not null unique,
    enable TINYINT,
    phone_number varchar(14) not null,
    address_line1 varchar(100) not null,
    district varchar(100) not null,
    zip_code varchar(9) not null,
    address_line2 varchar(100),
    state char(2) not null,
    city varchar(100) not null,

primary key(cpf));