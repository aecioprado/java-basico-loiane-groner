-- ddl
-- script de criação do banco de dados e da tabela aluno

create database if not exists digital_innovation_one_jdbc;


create table if not exists aluno (
id serial not null,
nome varchar(80) not null,
idade integer not null check(idade>0),
estado varchar(2) not null
);
