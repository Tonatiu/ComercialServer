create database if not exists BigComercial;
use BigComercial;

create table if not exists Product(
	id int not null auto_increment,
	name varchar(50),
	price double,
	primary key(id)
);

create table if not exists Stock(
	id int not null auto_increment,
	id_Product int not null,
	existances int,
	primary key(id),
	foreign key(id_Product) references Product(id)
);

create table if not exists Movement(
	id int not null auto_increment,
	id_Product int not null,
	movemet_date datetime,
	tipe boolean,
	quantity int,
	primary key(id),
	foreign key(id_Product) references Product(id)
);

create table if not exists Users(
	id int not null auto_increment,
	email varchar(50),
	name varchar(50),
	passwd varchar(50),
	primary key(id)
);

DELIMITER $$
create trigger movementTrigger after insert on Movement
	for each row
	begin
		if new.tipe then
			update Stock set 
				Stock.existances = Stock.existances + new.quantity
				where Stock.id_Product = new.id_Product;
		else
			update Stock set 
				Stock.existances = Stock.existances - new.quantity
				where Stock.id_Product = new.id_Product;
		end if;
	end;
	$$
DELIMITER ;
	