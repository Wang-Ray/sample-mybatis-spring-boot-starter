drop table if exists country;
drop table if exists city;
drop table if exists hotel;

create table country (id int primary key auto_increment, name varchar);
create table city (id int primary key auto_increment, name varchar, state varchar, country varchar, created_by varchar);
create table hotel (id int primary key auto_increment, name varchar, address varchar, zip varchar, city int);

insert into country (name) values ('US');
insert into city (name, state, country, created_by) values ('San Francisco', 'CA', 'US', 'Angi');
insert into hotel(name, address, zip, city) values ('Conrad Treasury Place', 'William & George Streets', '4001',1);
insert into hotel(name, address, zip, city) values ('Conrad Treasury Place', 'William & George Streets', '4001',1);
insert into hotel(name, address, zip, city) values ('Conrad Treasury Place', 'William & George Streets', '4001',1);
insert into hotel(name, address, zip, city) values ('Conrad Treasury Place', 'William & George Streets', '4001',1);
insert into hotel(name, address, zip, city) values ('Conrad Treasury Place', 'William & George Streets', '4001',1);
insert into hotel(name, address, zip, city) values ('Conrad Treasury Place', 'William & George Streets', '4001',1);
