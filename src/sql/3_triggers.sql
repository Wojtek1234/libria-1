drop function account_insert_function() cascade;
drop function account_update_function() cascade;
drop function author_insert_function() cascade;
drop function author_update_function() cascade;
drop function book_insert_function() cascade;
drop function book_update_function() cascade;
drop function category_insert_function() cascade;
drop function category_update_function() cascade;
drop function room_insert_function() cascade;
drop function room_update_function() cascade;


create function account_insert_function() returns trigger AS $account_insert_function$

begin 
if NEW.account_created is NULL then 
NEW.account_created := localtimestamp; 
end if; 
  if NEW.account_modified  is NULL then
    NEW.account_modified  := localtimestamp; 
  end if; 

return new;
end;
$account_insert_function$ LANGUAGE plpgsql;

create  trigger account_INSERT
before insert on account
for each row execute procedure account_insert_function(); 

create function account_update_function() returns trigger AS $account_update_function$

begin 
if NEW.account_created is NULL then 
NEW.account_created := localtimestamp; 
else
    NEW.account_modified  := localtimestamp; 
  end if; 

return new;
end;
$account_update_function$ LANGUAGE plpgsql;

create  trigger account_update
before update on account
for each row execute procedure account_update_function(); 

create function author_insert_function() returns trigger AS $author_insert_function$

begin 
if NEW.author_created is NULL then 
NEW.author_created := localtimestamp; 
end if; 
  if NEW.author_modified  is NULL then
    NEW.author_modified  := localtimestamp; 
  end if; 

return new;
end;
$author_insert_function$ LANGUAGE plpgsql;

create  trigger author_INSERT
before insert on author
for each row execute procedure author_insert_function(); 

create function author_update_function() returns trigger AS $author_update_function$

begin 
if NEW.author_created is NULL then 
NEW.author_created := localtimestamp; 
else
    NEW.author_modified  := localtimestamp; 
  end if; 

return new;
end;
$author_update_function$ LANGUAGE plpgsql;

create  trigger author_update
before update on author
for each row execute procedure author_update_function(); 

create function book_insert_function() returns trigger AS $book_insert_function$

begin 
if NEW.book_created is NULL then 
NEW.book_created := localtimestamp; 
end if; 
  if NEW.book_modified  is NULL then
    NEW.book_modified  := localtimestamp; 
  end if; 

return new;
end;
$book_insert_function$ LANGUAGE plpgsql;

create  trigger book_INSERT
before insert on book
for each row execute procedure book_insert_function(); 

create function book_update_function() returns trigger AS $book_update_function$

begin 
if NEW.book_created is NULL then 
NEW.book_created := localtimestamp; 
else
    NEW.book_modified  := localtimestamp; 
  end if; 

return new;
end;
$book_update_function$ LANGUAGE plpgsql;

create  trigger book_update
before update on book
for each row execute procedure book_update_function(); 

create function category_insert_function() returns trigger AS $category_insert_function$

begin 
if NEW.category_created is NULL then 
NEW.category_created := localtimestamp; 
end if; 
  if NEW.category_modified  is NULL then
    NEW.category_modified  := localtimestamp; 
  end if; 

return new;
end;
$category_insert_function$ LANGUAGE plpgsql;

create  trigger category_INSERT
before insert on category
for each row execute procedure category_insert_function(); 

create function category_update_function() returns trigger AS $category_update_function$

begin 
if NEW.category_created is NULL then 
NEW.category_created := localtimestamp; 
else
    NEW.category_modified  := localtimestamp; 
  end if; 

return new;
end;
$category_update_function$ LANGUAGE plpgsql;

create  trigger category_update
before update on category
for each row execute procedure category_update_function(); 

create function room_insert_function() returns trigger AS $room_insert_function$

begin 
if NEW.room_created is NULL then 
NEW.room_created := localtimestamp; 
end if; 
  if NEW.room_modified  is NULL then
    NEW.room_modified  := localtimestamp; 
  end if; 

return new;
end;
$room_insert_function$ LANGUAGE plpgsql;

create  trigger room_INSERT
before insert on room
for each row execute procedure room_insert_function(); 

create function room_update_function() returns trigger AS $room_update_function$

begin 
if NEW.room_created is NULL then 
NEW.room_created := localtimestamp; 
else
    NEW.room_modified  := localtimestamp; 
  end if; 

return new;
end;
$room_update_function$ LANGUAGE plpgsql;

create  trigger room_update
before update on room
for each row execute procedure room_update_function(); 