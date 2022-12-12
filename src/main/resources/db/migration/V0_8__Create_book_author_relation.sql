create table if not exists book_category(
    book_id integer,
    category_id integer,
    constraint fk_book foreign key(book_id) references book(id),
    constraint fk_category foreign key(category_id) references category(id)
);