create table if not exists author
(
    id     serial,
    name    varchar,
    birth_date timestamp without time zone,
    particularity varchar,
    primary key (id)
);