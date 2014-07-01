DROP table account cascade;
DROP table author cascade;
DROP table category cascade;
DROP table room cascade;
DROP table book cascade;

create table account(
  account_id bigint constraint ac_id primary key, 
  account_name varchar(200) not null constraint ac_name unique,
  account_created timestamp,
  account_modified timestamp
  );

  create table author(
  author_id bigint constraint au_id primary key, 
  author_name varchar(200) not null constraint au_name unique,
  author_created timestamp,
  author_modified timestamp
  );

  create table category(
  category_id bigint constraint ca_id primary key, 
  category_name varchar(200) not null constraint ca_name unique,
  category_created timestamp,
  category_modified timestamp
  );

create table room(
  room_id bigint constraint ro_id primary key, 
  room_name varchar(200) not null constraint ro_name unique,
  room_created timestamp,
  room_modified timestamp
  );

  create table book(
  book_id bigint constraint bo_id primary key,
  book_account_id bigint not null, 
  book_author_id bigint not null,
  book_category_id bigint not null,
  book_room_id bigint not null,
  book_name varchar(200) not null constraint bo_name unique,
  book_created timestamp,
  book_modified timestamp
  );

alter table book 
    add constraint fk_book_account foreign key(book_account_id)
    references account;

alter table book 
    add constraint fk_book_author foreign key(book_author_id)
    references author;

alter table book 
    add constraint fk_book_category foreign key(book_category_id)
    references category;

alter table book 
    add constraint fk_book_room foreign key(book_room_id)
    references room;

  

  