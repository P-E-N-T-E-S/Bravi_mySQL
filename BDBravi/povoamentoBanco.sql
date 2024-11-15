USE BDBravi;

-- Primeiro, insira as categorias
INSERT INTO Categoria (id, nome)
VALUES
(1, 'Limpeza'),
(2, 'Tecnologia'),
(3, 'Equipamentos'),
(4, 'Portáteis');

-- Inserindo registros na tabela Funcionario
INSERT INTO Funcionario (Setor, Cargo, CPF, Nome, Data_de_Nascimento, Rua, Bairro, CEP, Numero, CPF_GERENTE)
VALUES
('Administrativo', 'Gerente', '44444444444', 'João Silva', '1978-06-21', 'Rua A', 'Centro', '12345678', 10, NULL),
('Financeiro', 'Analista', '55555555555', 'Maria Oliveira', '1985-08-12', 'Rua B', 'Zona Sul', '23456789', 20, '44444444444'),
('Vendas', 'Vendedor', '66666666666', 'Carlos Souza', '1990-11-30', 'Rua C', 'Zona Norte', '34567890', 30, '44444444444'),
('Logística', 'Coordenador', '77777777777', 'Ana Costa', '1988-02-15', 'Rua D', 'Zona Norte', '45678901', 40, '44444444444'),
('RH', 'Assistente', '88888888888', 'Pedro Santos', '1995-09-25', 'Rua E', 'Centro', '56789012', 50, '44444444444'),
('Tecnologia', 'Desenvolvedor', '99999999999', 'Julia Martins', '1993-12-10', 'Rua F', 'Zona Leste', '67890123', 60, '44444444444');

-- Populando a tabela Fornecedor com CNPJs únicos e incluindo o nome
INSERT INTO Fornecedor (categoria, CNPJ, Nome, Rua, Bairro, CEP, Numero, Numero2, Inscricao_Estadual, Razao_Social)
VALUES
('Limpeza', '12345678901234', 'Fornecedor A', 'Av. das Indústrias', 'Industrial', '56789012', 100, '123', 987654321, 'Fornecedor A LTDA'),
('Tecnologia', '23456789012346', 'Fornecedor B', 'Rua do Comércio', 'Centro', '67890123', 200, '124', 876543210, 'Fornecedor B LTDA'),
('Limpeza', '56789012345678', 'Fornecedor C', 'Av. Paulista', 'Centro', '34567890', 150, '125', 543216789, 'Fornecedor C LTDA'),
('Equipamentos', '67890123456789', 'Fornecedor D', 'Rua das Flores', 'Zona Norte', '45678901', 250, '126', 432109876, 'Fornecedor D EIRELI');

-- Populando a tabela Cliente e incluindo o nome
INSERT INTO Cliente (CNPJ, Nome, Rua, Bairro, CEP, Numero, Numero2, Inscricao_Estadual, Razao_Social)
VALUES
('34567890123456', 'Cliente A', 'Av. Central', 'Centro', '78901234', 300, '101', 765432109, 'Cliente A LTDA'),
('45678901234567', 'Cliente B', 'Rua Nova', 'Zona Oeste', '89012345', 400, '102', 654321098, 'Cliente B LTDA'),
('56789012345678', 'Cliente C', 'Av. Rio Branco', 'Zona Oeste', '23456789', 350, '103', 321098765, 'Cliente C LTDA'),
('67890123456789', 'Cliente D', 'Rua das Palmeiras', 'Zona Norte', '12345678', 450, '104', 210987654, 'Cliente D LTDA');

-- Populando a tabela Produto com categoria vinculada
INSERT INTO Produto (NSM, Nome, Descrição, fk_Categoria_id)
VALUES
(1, 'Sabão Líquido', 'Produto de limpeza para uso geral', 1),
(2, 'Notebook', 'Computador portátil de última geração', 2),
(3, 'Detergente', 'Produto de limpeza com fórmula concentrada', 1),
(4, 'Impressora', 'Equipamento multifuncional a laser', 3),
(5, 'Tablet', 'Dispositivo portátil com tela touch screen', 4);

-- Populando a tabela Categoria_Produto
INSERT INTO Categoria_Produto (fk_Produto_NSM, fk_Categoria_id)
VALUES
(1, 1),
(2, 2),
(3, 1),
(4, 3),
(5, 4);

-- Populando a tabela Estoque
INSERT INTO Estoque (setor, qtd, fk_Produto_NSM)
VALUES
(1, 50, 1),
(2, 20, 2),
(1, 200, 3),
(2, 15, 4),
(3, 40, 5);

-- Populando a tabela _Fornece com a coluna `valor`
INSERT INTO _Fornece (fk_Produto_NSM, fk_Fornecedor_CNPJ, id, data, valor)
VALUES
(1, '12345678901234', 1, '2024-01-15', 150.00),
(2, '23456789012346', 2, '2024-02-20', 2500.00),
(3, '56789012345678', 3, '2024-05-10', 75.00),
(4, '67890123456789', 4, '2024-06-15', 1200.00),
(5, '23456789012346', 5, '2024-07-20', 800.00);

-- Populando a tabela _Compra com a coluna `valor`
INSERT INTO _Compra (fk_Cliente_CNPJ, fk_Produto_NSM, id, data, valor)
VALUES
('34567890123456', 1, 1, '2024-03-05', 25.00),
('45678901234567', 2, 2, '2024-04-10', 2500.00),
('56789012345678', 3, 3, '2024-08-05', 80.00),
('67890123456789', 4, 4, '2024-09-10', 1300.00),
('34567890123456', 5, 5, '2024-10-15', 850.00);
