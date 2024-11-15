CREATE DATABASE IF NOT EXISTS BDBravi;

USE BDBravi;

CREATE TABLE IF NOT EXISTS Setor (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Categoria (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Funcionario (
    fk_Setor_id INTEGER,
    Cargo VARCHAR(50),
    CPF VARCHAR(14) PRIMARY KEY,
    Nome VARCHAR(50),
    Data_de_Nascimento DATE,
    Rua VARCHAR(50),
    Bairro VARCHAR(50),
    CEP VARCHAR(10),
    Numero VARCHAR(50),
    CPF_GERENTE VARCHAR(14),
    FOREIGN KEY (fk_Setor_id) REFERENCES Setor(id),
    FOREIGN KEY (CPF_GERENTE) REFERENCES Funcionario(CPF)
);

CREATE TABLE IF NOT EXISTS Fornecedor (
    categoria VARCHAR(50),
    CNPJ VARCHAR(20) PRIMARY KEY,
    Nome VARCHAR(50),
    Rua VARCHAR(50),
    Bairro VARCHAR(50),
    CEP VARCHAR(10),
    Numero VARCHAR(50),
    Numero2 VARCHAR(50),
    Inscricao_Estadual VARCHAR(50),
    Razao_Social VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Cliente (
    CNPJ VARCHAR(20) PRIMARY KEY,
    Nome VARCHAR(50),
    Rua VARCHAR(50),
    Bairro VARCHAR(50),
    CEP VARCHAR(10),
    Numero VARCHAR(50),
    Numero2 VARCHAR(50),
    Inscricao_Estadual INTEGER,
    Razao_Social VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Produto (
    NSM INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Descrição VARCHAR(50),
    fk_Categoria_id INTEGER,
    FOREIGN KEY (fk_Categoria_id) REFERENCES Categoria(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS _Fornece (
    fk_Produto_NSM INTEGER,
    fk_Fornecedor_CNPJ VARCHAR(20),
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    valor DECIMAL(10, 2),
    FOREIGN KEY (fk_Produto_NSM) REFERENCES Produto (NSM),
    FOREIGN KEY (fk_Fornecedor_CNPJ) REFERENCES Fornecedor (CNPJ)
);

CREATE TABLE IF NOT EXISTS _Compra (
    fk_Cliente_CNPJ VARCHAR(20),
    fk_Produto_NSM INTEGER,
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    valor DECIMAL(10, 2),
    FOREIGN KEY (fk_Cliente_CNPJ) REFERENCES Cliente (CNPJ),
    FOREIGN KEY (fk_Produto_NSM) REFERENCES Produto (NSM)
);

CREATE TABLE IF NOT EXISTS Nota_in (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    fk__Compra_id INTEGER,
    FOREIGN KEY (fk__Compra_id) REFERENCES _Compra (id)
);

CREATE TABLE IF NOT EXISTS Nota_out (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    fk__Fornece_id INTEGER,
    FOREIGN KEY (fk__Fornece_id) REFERENCES _Fornece (id)
);

CREATE TABLE IF NOT EXISTS Categoria_Produto (
    fk_Produto_NSM INTEGER,
    fk_Categoria_id INTEGER,
    PRIMARY KEY (fk_Categoria_id, fk_Produto_NSM),
    FOREIGN KEY (fk_Produto_NSM) REFERENCES Produto (NSM),
    FOREIGN KEY (fk_Categoria_id) REFERENCES Categoria (id)
);

CREATE TABLE IF NOT EXISTS Estoque (
    fk_Setor_id INTEGER,
    qtd INTEGER,
    fk_Produto_NSM INTEGER,
    PRIMARY KEY (fk_Setor_id, fk_Produto_NSM),
    FOREIGN KEY (fk_Setor_id) REFERENCES Setor(id),
    FOREIGN KEY (fk_Produto_NSM) REFERENCES Produto (NSM)
);

CREATE TABLE IF NOT EXISTS Usuario (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    fk_Funcionario_CPF VARCHAR(14) NOT NULL,
    isGerente BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (fk_Funcionario_CPF) REFERENCES Funcionario(CPF) ON DELETE CASCADE
);

DELIMITER //

CREATE TRIGGER after_funcionario_insert
AFTER INSERT ON Funcionario
FOR EACH ROW
BEGIN
    DECLARE cargoGerente BOOLEAN DEFAULT FALSE;

    IF NEW.Cargo = 'Gerente' THEN
        SET cargoGerente = TRUE;
    END IF;

    INSERT INTO Usuario (usuario, senha, fk_Funcionario_CPF, isGerente)
    VALUES (NEW.CPF, NEW.Nome, NEW.CPF, cargoGerente);
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER after_compra_insert
AFTER INSERT ON _Compra
FOR EACH ROW
BEGIN
    DECLARE produto_existe INT;

    SET produto_existe = 0;

    SELECT COUNT(*) INTO produto_existe
    FROM Estoque
    WHERE fk_Produto_NSM = NEW.fk_Produto_NSM;

    IF produto_existe > 0 THEN
        UPDATE Estoque
        SET qtd = qtd - 1
        WHERE fk_Produto_NSM = NEW.fk_Produto_NSM;
    ELSE
        INSERT INTO Estoque (qtd, fk_Produto_NSM, fk_Setor_id)
        VALUES (-1, NEW.fk_Produto_NSM, 1);
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER after_fornece_insert
AFTER INSERT ON _Fornece
FOR EACH ROW
BEGIN
    DECLARE produto_existe INT;

    SET produto_existe = 0;

    SELECT COUNT(*) INTO produto_existe
    FROM Estoque
    WHERE fk_Produto_NSM = NEW.fk_Produto_NSM;

    IF produto_existe > 0 THEN
        UPDATE Estoque
        SET qtd = qtd + 1
        WHERE fk_Produto_NSM = NEW.fk_Produto_NSM;
    ELSE
        INSERT INTO Estoque (qtd, fk_Produto_NSM, fk_Setor_id)
        VALUES (1, NEW.fk_Produto_NSM, 1);
    END IF;

    INSERT INTO Nota_out (data, fk__Fornece_id)
    VALUES (CURDATE(), NEW.id);
END //

DELIMITER ;

-- drop database BDBravi