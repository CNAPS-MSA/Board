drop table if exists board cascade ;
drop table if exists comment;
create table board
(
    id bigint auto_increment primary key not null,
    title varchar(255),
    content varchar(1000),
    writer_name varchar(50) not null,
    writer_id bigint not null,
    created_date varchar(50) not null,
    category varchar(25) not null,
    hit integer
);

create table comment
(
    id bigint auto_increment primary key not null,
    content varchar(500),
    writer_id bigint not null,
    writer_name varchar(50) not null ,
    created_date varchar(50) not null,
    board_id bigint not null,
    foreign key (board_id) references board (id)
    on delete cascade
);
