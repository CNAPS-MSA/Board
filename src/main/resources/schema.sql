create table board
(
    id bigint identity ,
    title varchar(255),
    content varchar(1000),
    writer varchar(50) not null,
    createdDate varchar(50) not null,
    category varchar(255) not null,
    hit integer
);
