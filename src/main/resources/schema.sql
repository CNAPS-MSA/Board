drop table if exists board cascade ;
drop table if exists comment;
create table board
(
    id bigint auto_increment primary key not null,
    title varchar(255),
    content varchar(1000),
    writerName varchar(50) not null,
    writerId bigint not null,
    createdDate varchar(50) not null,
    category varchar(25) not null,
    hit integer
);

create table comment
(
    id bigint auto_increment primary key not null,
    content varchar(500),
    writerId bigint not null,
    writerName varchar(50) not null ,
    createdDate varchar(50) not null,
    boardId bigint not null,
    foreign key (boardId) references board (id)

);
