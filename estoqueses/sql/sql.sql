CREATE DATABASE db_prods
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

USE db_prods;

CREATE TABLE produtos(
	id int NOT NULL AUTO_INCREMENT,
	nome VARCHAR(60) NOT NULL, -- Não pode ser null
	descricao VARCHAR(120),
    especificacao VARCHAR(80),
	marca VARCHAR(15) NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    quantidade INT NOT NULL,
    unidade VARCHAR(20) NOT NULL,
    preco DECIMAL(15, 2) NOT NULL,
	PRIMARY KEY (id) -- Define o ID como chave primária
)DEFAULT CHARSET = utf8;

CREATE TABLE marca (
	id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(35) NOT NULL,
    descricao VARCHAR(120),
    PRIMARY KEY (id)
)DEFAULT CHARSET = utf8;