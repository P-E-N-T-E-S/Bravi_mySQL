CREATE DATABASE IF NOT EXISTS BDBravi;

USE BDBravi;

CREATE TABLE IF NOT EXISTS Funcionario (
    Setor VARCHAR(50),
    Cargo VARCHAR(50),
    CPF VARCHAR(14) PRIMARY KEY,
    Nome VARCHAR(50),
    Data_de_Nascimento DATE,
    Rua VARCHAR(50),
    Bairro VARCHAR(50),
    CEP INTEGER,
    Numero INTEGER,
    CPF_GERENTE VARCHAR(14)
);

CREATE TABLE IF NOT EXISTS Fornecedor (
    categoria VARCHAR(50),
    CNPJ VARCHAR(50) PRIMARY KEY,
    Rua VARCHAR(50),
    Bairro VARCHAR(50),
    CEP INTEGER,
    Numero INTEGER,
    Inscricao_Estadual INTEGER,
    Razao_Social VARCHAR(50)  -- Alterado para VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Cliente (
    CNPJ VARCHAR(50) PRIMARY KEY,
    Rua VARCHAR(50),
    Bairro VARCHAR(50),
    CEP INTEGER,
    Numero INTEGER,
    Inscricao_Estadual INTEGER,
    Razao_Social VARCHAR(50)  -- Alterado para VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Produto (
    NSM INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Descrição VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS _Fornece (
    fk_Produto_NSM INTEGER,
    fk_Fornecedor_CNPJ VARCHAR(50),  -- Corrigido para VARCHAR(50)
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE
);

CREATE TABLE IF NOT EXISTS _Compra (
    fk_Cliente_CNPJ VARCHAR(50),  -- Alterado para VARCHAR(50)
    fk_Produto_NSM INTEGER,
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE
);

CREATE TABLE IF NOT EXISTS Nota_in (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    fk__Compra_id INTEGER
);

CREATE TABLE IF NOT EXISTS Nota_out (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    fk__Fornece_id INTEGER
);

CREATE TABLE IF NOT EXISTS Categoria (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Telefone (
    Telefone_PK INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fk_Funcionario_CPF VARCHAR(14)
);

CREATE TABLE IF NOT EXISTS Categoria_Produto (
    fk_Produto_NSM INTEGER,
    fk_Categoria_id INTEGER,
    PRIMARY KEY (fk_Categoria_id, fk_Produto_NSM)
);

CREATE TABLE IF NOT EXISTS Estoque (
    setor INTEGER,
    qtd INTEGER,
    fk_Produto_NSM INTEGER,
    PRIMARY KEY (setor, fk_Produto_NSM)
);

ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_2
    FOREIGN KEY (CPF_GERENTE)
    REFERENCES Funcionario (CPF);

ALTER TABLE _Fornece ADD CONSTRAINT FK_Fornece_1
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM);

ALTER TABLE _Fornece ADD CONSTRAINT FK_Fornece_2
    FOREIGN KEY (fk_Fornecedor_CNPJ)
    REFERENCES Fornecedor (CNPJ);

ALTER TABLE _Compra ADD CONSTRAINT FK_Compra_1
    FOREIGN KEY (fk_Cliente_CNPJ)
    REFERENCES Cliente (CNPJ);

ALTER TABLE _Compra ADD CONSTRAINT FK_Compra_2
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM);

ALTER TABLE Nota_in ADD CONSTRAINT FK_Nota_in_2
    FOREIGN KEY (fk__Compra_id)
    REFERENCES _Compra (id);

ALTER TABLE Nota_out ADD CONSTRAINT FK_Nota_out_2
    FOREIGN KEY (fk__Fornece_id)
    REFERENCES _Fornece (id);

ALTER TABLE Categoria_Produto ADD CONSTRAINT FK_Categoria_Produto_1
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM);

ALTER TABLE Categoria_Produto ADD CONSTRAINT FK_Categoria_Produto_2
    FOREIGN KEY (fk_Categoria_id)
    REFERENCES Categoria (id);

ALTER TABLE Estoque ADD CONSTRAINT FK_Estoque_2
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM);

SHOW TABLES;
