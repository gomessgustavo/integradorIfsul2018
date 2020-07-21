CREATE DATABASE projeto_vendas;

USE projeto_vendas;

CREATE TABLE endereco (
id_endereco BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
cep VARCHAR(11) NOT NULL UNIQUE,
uf VARCHAR(2) NOT NULL, 
estado VARCHAR(45) NOT NULL,
cidade VARCHAR(45) NOT NULL,
bairro VARCHAR(45) NOT NULL,
rua VARCHAR (50) NOT NULL,
numero INT NOT NULL,
PRIMARY KEY (id_endereco)
);

CREATE TABLE telefone (
id_telefone BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
ddd VARCHAR(3) NOT NULL,
numero VARCHAR(10) NOT NULL, 
PRIMARY KEY (id_telefone)
);

CREATE TABLE distribuidor (
id_distribuidor BIGINT UNIQUE NOT NULL AUTO_INCREMENT, 
nome_distribuidor VARCHAR(100) NOT NULL,
email_distribuidor VARCHAR(50) NOT NULL,
senha VARCHAR(200) NOT NULL,
id_endereco BIGINT NOT NULL UNIQUE,
id_telefone BIGINT NOT NULL UNIQUE,
PRIMARY KEY (id_distribuidor),
FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco),
FOREIGN KEY (id_telefone) REFERENCES telefone (id_telefone)
);

CREATE TABLE cliente (
id_cliente BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome_cliente VARCHAR(100) NOT NULL,
email_cliente VARCHAR(50) NOT NULL,
pedido VARCHAR(5000) NOT NULL,
cnpj VARCHAR(20) NOT NULL,
foto_cliente VARCHAR(200), 
id_endereco BIGINT NOT NULL UNIQUE,
id_telefone BIGINT NOT NULL UNIQUE,
PRIMARY KEY (id_cliente),
FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco),
FOREIGN KEY (id_telefone) REFERENCES telefone (id_telefone)
);

CREATE TABLE produto (
id_produto BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
nome_produto VARCHAR(30) NOT NULL,
foto_produto VARCHAR(200), 
preco BIGINT NOT NULL,
categoria VARCHAR(30) NOT NULL,
id_cliente BIGINT NOT NULL,
id_distribuidor BIGINT NOT NULL,
PRIMARY KEY (id_produto),
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
FOREIGN KEY (id_distribuidor) REFERENCES distribuidor (id_distribuidor)
);

CREATE TABLE distribuidor_cliente (
id_distribuidor_cliente BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
id_cliente BIGINT NOT NULL,
id_distribuidor BIGINT NOT NULL,
PRIMARY KEY (id_distribuidor_produto),
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
FOREIGN KEY (id_distribuidor) REFERENCES distribuidor (id_distribuidor)
);

CREATE TABLE produto_cliente (
id_produto_cliente BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
id_produto BIGINT NOT NULL,
id_cliente BIGINT NOT NULL,
PRIMARY KEY (id_produto_cliente),
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);
