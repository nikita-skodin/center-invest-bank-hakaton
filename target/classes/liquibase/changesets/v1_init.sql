create table if not exists users
(
    id bigint generated by default as identity primary key,
    username varchar not null unique,
    password varchar not null,
    email varchar not null unique,
    phone_number varchar(25),
    enabled bool not null default false
);

create table if not exists users_roles(
    user_id bigint references users(id) not null,
    role varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users(id) on delete cascade on update no action
);

create table if not exists address(
    id bigint generated by default as identity primary key,
    username varchar not null,
    city varchar not null,
    street varchar not null,
    contact_number varchar not null,
    working_hours varchar not null
)