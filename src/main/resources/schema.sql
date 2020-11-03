drop table if exists board;
create table board
(
    id bigint auto_increment primary key not null,
    title varchar(255),
    content varchar(1000),
    writer varchar(50) not null,
    createdDate varchar(50) not null,
    category varchar(255) not null,
    hit integer
);
