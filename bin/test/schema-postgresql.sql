CREATE TABLE IF NOT EXISTS livro (
	id serial PRIMARY KEY,
	nome varchar(300),
	edicao varchar(20),
	valor real
);

CREATE TABLE IF NOT EXISTS editora (
	idEdit serial PRIMARY KEY,
	nomeEdit varchar(300),
	telefone varchar(20),
	emailEdit varchar(50)
);

CREATE TABLE IF NOT EXISTS autor (
	idAut serial PRIMARY KEY,
	nomeAut varchar(300),
	emailAut varchar(50)
);