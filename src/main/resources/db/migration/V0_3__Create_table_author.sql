create table if not exists author
(
    id     serial,
    name    varchar(250),
    birth_date timestamp without time zone,
    particularity varchar(250),
    primary key (id)
);