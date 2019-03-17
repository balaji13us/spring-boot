create table student1
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);


create table USER
(
   ID BIGINT not null,
   PROXY varchar(255) not null,
   FIRST_NAME varchar(200) not null,
   LAST_NAME varchar(200) not null,
   FULL_NAME varchar(600) not null,
   TITLE varchar(10) ,
   EMAIL varchar(200) ,
   
   primary key(ID)
);