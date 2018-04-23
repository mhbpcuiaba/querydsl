drop table customer if exists
create table customer (
  id integer not null,
  name varchar(255) not null,
  gender char not null,
  primary key (id)
);