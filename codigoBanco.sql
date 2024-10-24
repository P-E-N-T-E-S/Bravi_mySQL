/* Lógico_1: */

CREATE TABLE Funcionario (
    Setor VARCHAR,
    Cargo VARCHAR,
    CPF VARCHAR PRIMARY KEY,
    Nome VARCHAR,
    Data_de_Nascimento DATE,
    Rua VARCHAR,
    Bairro VARCHAR,
    CEP INTEGER,
    Numero INTEGER,
    CPF_GERENTE VARCHAR
);

CREATE TABLE Fornecedor (
    categoria VARCHAR,
    CNPJ INTEGER PRIMARY KEY,
    Rua VARCHAR,
    Bairro VARCHAR,
    CEP INTEGER,
    Numero INTEGER,
    Inscricao_Estadual INTEGER,
    Razao_Social INTEGER
);

CREATE TABLE Cliente (
    CNPJ INTEGER PRIMARY KEY,
    Rua VARCHAR,
    Bairro VARCHAR,
    CEP INTEGER,
    Numero INTEGER,
    Inscricao_Estadual INTEGER,
    Razao_Social INTEGER
);

CREATE TABLE Produto (
    NSM INTEGER PRIMARY KEY,
    Nome VARCHAR,
    Descrição VARCHAR
);

CREATE TABLE _Fornece (
    fk_Produto_NSM INTEGER,
    fk_Fornecedor_CNPJ INTEGER,
    id INTEGER PRIMARY KEY,
    data DATE
);

CREATE TABLE _Compra (
    fk_Cliente_CNPJ INTEGER,
    fk_Produto_NSM INTEGER,
    id INTEGER PRIMARY KEY,
    data DATE
);

CREATE TABLE Nota_in (
    id INTEGER PRIMARY KEY,
    data DATE,
    fk__Compra_id INTEGER
);

CREATE TABLE Nota_out (
    id INTEGER PRIMARY KEY,
    data DATE,
    fk__Fornece_id INTEGER
);

CREATE TABLE Categoria (
    id INTEGER PRIMARY KEY,
    nome VARCHAR
);

CREATE TABLE Telefone (
    Telefone_PK INTEGER NOT NULL PRIMARY KEY,
    fk_Funcionario_CPF VARCHAR
);

CREATE TABLE Categoria/Produto (
    fk_Produto_NSM INTEGER,
    fk_Categoria_id INTEGER,
    PRIMARY KEY (fk_Categoria_id, fk_Produto_NSM)
);

CREATE TABLE Estoque (
    setor INTEGER,
    qtd INTEGER,
    fk_Produto_NSM INTEGER,
    PRIMARY KEY (setor, fk_Produto_NSM)
);
 
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_2
    FOREIGN KEY (fk_Telefone_Telefone_PK)
    REFERENCES Telefone (Telefone_PK)
    ON DELETE NO ACTION;
 
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_3
    FOREIGN KEY (fk_Funcionario_CPF)
    REFERENCES Funcionario (CPF);
 
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_4
    FOREIGN KEY (CPF_GERENTE)
    REFERENCES Funcionario (CPF);
 
ALTER TABLE Produto ADD CONSTRAINT FK_Produto_2
    FOREIGN KEY (fk_Categoria_id)
    REFERENCES Categoria (id);
 
ALTER TABLE _Fornece ADD CONSTRAINT FK__Fornece_1
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM);
 
ALTER TABLE _Fornece ADD CONSTRAINT FK__Fornece_2
    FOREIGN KEY (fk_Fornecedor_CNPJ)
    REFERENCES Fornecedor (CNPJ);
 
ALTER TABLE _Compra ADD CONSTRAINT FK__Compra_1
    FOREIGN KEY (fk_Cliente_CNPJ)
    REFERENCES Cliente (CNPJ);
 
ALTER TABLE _Compra ADD CONSTRAINT FK__Compra_2
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM);
 
ALTER TABLE Nota_in ADD CONSTRAINT FK_Nota_in_2
    FOREIGN KEY (fk__Compra_id)
    REFERENCES _Compra (id);
 
ALTER TABLE Nota_out ADD CONSTRAINT FK_Nota_out_2
    FOREIGN KEY (fk__Fornece_id)
    REFERENCES _Fornece (id);
 
ALTER TABLE Categoria ADD CONSTRAINT FK_Categoria_2
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM)
    ON DELETE CASCADE;
 
ALTER TABLE Telefone ADD CONSTRAINT FK_Telefone_2
    FOREIGN KEY (fk_Funcionario_CPF)
    REFERENCES Funcionario (CPF);
 
ALTER TABLE Categoria/Produto ADD CONSTRAINT FK_Categoria/Produto_1
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM);
 
ALTER TABLE Categoria/Produto ADD CONSTRAINT FK_Categoria/Produto_2
    FOREIGN KEY (fk_Categoria_id)
    REFERENCES Categoria (id);
 
ALTER TABLE Estoque ADD CONSTRAINT FK_Estoque_2
    FOREIGN KEY (fk_Produto_NSM)
    REFERENCES Produto (NSM);