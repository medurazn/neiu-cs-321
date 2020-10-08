create table if not exists VehicleCategory (
    id varchar(3) not null,
    type varchar(20) not null
);

create table if not exists Vehicle (
    id bigInt identity(1, 1),
    make varchar (50) not null,
    model varchar (50) not null,
    color varchar (50) not null,
    year bigInt not null,
    ticket varchar (20) not null,
    location varchar (20) not null,
    plate varchar (20) not null,
    createdAt timestamp not null
);

create table if not exists Vehicle_Categories (
    vehicle bigInt not null,
    category varchar (3) not null
);

alter table Vehicle_Categories
    add foreign key (vehicle) references Vehicle(id);
alter table Vehicle_Categories
    add foreign key (category) references VehicleCategory(id);