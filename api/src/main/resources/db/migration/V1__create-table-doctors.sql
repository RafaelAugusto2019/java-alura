create table doctor(

id bigint not null auto_increment,
                        name varchar(100) not null,
                        email varchar(100) not null unique,
                        crm varchar(6) not null unique,
                        medical_specialties varchar(100) not null,
                        address_line1 varchar(100) not null,
                        district varchar(100) not null,
                        zip_code varchar(9) not null,
                        address_line2 varchar(100),
                        state char(2) not null,
                        city varchar(100) not null,
                        primary key(id)

);