create table IF NOT EXISTS Company(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(25),
	creationDate date,
	PRIMARY KEY (id)
);

create table IF NOT EXISTS Console(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(25),
	companyId int,
	PRIMARY KEY (id)
);

create table IF NOT EXISTS Videogame(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(25),
	recomendedAge varchar(2),
	releaseDate date,
	consoleId int,
	PRIMARY KEY (id)
);