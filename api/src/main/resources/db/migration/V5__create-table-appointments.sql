create table appointments(

    id bigint not null auto_increment,
    cpf varchar(11) not null,
    doctor_id bigint not null,
    date varchar(10) not null,
    time varchar(5) not null,

primary key(id));