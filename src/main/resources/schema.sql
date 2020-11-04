drop table if exists board;
create table board
(
    id bigint auto_increment primary key not null,
    title varchar(255),
    content varchar(1000),
    writer_id bigint not null,
    createdDate varchar(50) not null,
    category varchar(25) not null,
    hit integer
);
