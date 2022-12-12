alter table book 
drop column author,
add column author_id integer;

alter table book  
add constraint fk_book_author foreign key(author_id) references author(id);