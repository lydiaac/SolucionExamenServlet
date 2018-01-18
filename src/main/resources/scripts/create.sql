create table IF NOT EXISTS Company(
	id int PRIMARY KEY,
	name varchar(25),
	creationDate date
);

create table IF NOT EXISTS Console(
	id int PRIMARY KEY,
	name varchar(25),
	companyID int;
);

create table IF NOT EXISTS Videogame(
	id int PRIMARY KEY,
	name varchar(25),
	recomendedAge varchar(2),
	releaseDate date
	consoleID int;
);