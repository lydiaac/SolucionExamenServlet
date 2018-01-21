create table IF NOT EXISTS Company(
	name varchar(25) PRIMARY KEY,
	creationDate date
);

create table IF NOT EXISTS Console(
	name varchar(25) PRIMARY KEY,
	company varchar(25)
);

create table IF NOT EXISTS Videogame(
	name varchar(25) PRIMARY KEY,
	recomendedAge varchar(2),
	releaseDate date,
	company varchar(25)
);