USE BDBravi;

-- Inserindo registros na tabela Funcionario
INSERT INTO Funcionario (Setor, Cargo, CPF, Nome, Data_de_Nascimento, Rua, Bairro, CEP, Numero, CPF_GERENTE)
VALUES
('Administrativo', 'Gerente', '44444444444', 'João Silva', '1978-06-21', 'Rua A', 'Centro', '12345678', 10, NULL),
('Financeiro', 'Analista', '55555555555', 'Maria Oliveira', '1985-08-12', 'Rua B', 'Zona Sul', '23456789', 20, '44444444444'),
('Vendas', 'Vendedor', '66666666666', 'Carlos Souza', '1990-11-30', 'Rua C', 'Zona Norte', '34567890', 30, '44444444444');

-- Populando a tabela Fornecedor com CNPJs únicos e incluindo o nome
INSERT INTO Fornecedor (categoria, CNPJ, Nome, Rua, Bairro, CEP, Numero, Inscricao_Estadual, Razao_Social)
VALUES
('Limpeza', '12345678901234', 'Fornecedor A', 'Av. das Indústrias', 'Industrial', '56789012', 100, 987654321, 'Fornecedor A LTDA'),
('Tecnologia', '23456789012346', 'Fornecedor B', 'Rua do Comércio', 'Centro', '67890123', 200, 876543210, 'Fornecedor B LTDA'); -- Alterei o último dígito do CNPJ para evitar duplicidade

-- Populando a tabela Cliente e incluindo o nome
INSERT INTO Cliente (CNPJ, Nome, Rua, Bairro, CEP, Numero, Inscricao_Estadual, Razao_Social)
VALUES
('34567890123456', 'Cliente A', 'Av. Central', 'Centro', '78901234', 300, 765432109, 'Cliente A LTDA'),
('45678901234567', 'Cliente B', 'Rua Nova', 'Zona Oeste', '89012345', 400, 654321098, 'Cliente B LTDA');

-- Populando a tabela Produto
INSERT INTO Produto (NSM, Nome, Descrição)
VALUES
(1, 'Sabão Líquido', 'Produto de limpeza para uso geral'),
(2, 'Notebook', 'Computador portátil de última geração');

-- Populando a tabela _Fornece
INSERT INTO _Fornece (fk_Produto_NSM, fk_Fornecedor_CNPJ, id, data)
VALUES
(1, '12345678901234', 1, '2024-01-15'),
(2, '23456789012346', 2, '2024-02-20'); -- CNPJ corrigido para corresponder ao valor inserido em Fornecedor

-- Populando a tabela _Compra
INSERT INTO _Compra (fk_Cliente_CNPJ, fk_Produto_NSM, id, data)
VALUES
('34567890123456', 1, 1, '2024-03-05'),
('45678901234567', 2, 2, '2024-04-10');

-- Populando a tabela Nota_in
INSERT INTO Nota_in (id, data, fk__Compra_id)
VALUES
(1, '2024-03-06', 1),
(2, '2024-04-11', 2);

-- Populando a tabela Nota_out
INSERT INTO Nota_out (id, data, fk__Fornece_id)
VALUES
(1, '2024-01-16', 1),
(2, '2024-02-21', 2);

-- Populando a tabela Categoria
INSERT INTO Categoria (id, nome)
VALUES
(1, 'Limpeza'),
(2, 'Tecnologia');

-- Populando a tabela Telefone
INSERT INTO Telefone (Telefone_PK, fk_Funcionario_CPF)
VALUES
(12345678, '44444444444'),
(87654321, '55555555555');

-- Populando a tabela Categoria_Produto
INSERT INTO Categoria_Produto (fk_Produto_NSM, fk_Categoria_id)
VALUES
(1, 1),
(2, 2);

-- Populando a tabela Estoque
INSERT INTO Estoque (setor, qtd, fk_Produto_NSM)
VALUES
(1, 50, 1),
(2, 20, 2);
