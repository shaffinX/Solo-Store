create table users(
	id serial primary key,
	name varchar(255),
	email varchar(255),
	password varchar(1000),
	role varchar(255)
)
create table store(
	storeid serial primary key,
	stname varchar(255),
	stdesc varchar(1000),
	id int,
	foreign key (id) references users(id)
 )
 create table products(
	prodid serial primary key,
	prodname varchar(255),
	pdesc varchar(1000),
	price int,
	img bytea,
	storeid int,
	foreign key (storeid) references store(storeid)
 )
 create table reviews(
	review varchar(1000),
	prodid int,
	foreign key (prodid) references products(prodid)
 )
 create table orders(
	orderid serial primary key,
	date date,
	prodid int,
	foreign key (prodid) references products(prodid),
	customerid int,
	foreign key (customerid) references users(id)
 )

drop table orders
update products v
select * from users