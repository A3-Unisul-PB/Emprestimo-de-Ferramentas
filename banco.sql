
--Amigos--
CREATE TABLE tb_amigos (
	id INT NOT NULL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	telefone VARCHAR(15) NOT NULL
);

INSERT INTO tb_amigos (id, nome, telefone) VALUES
	(1, 'Pedro', '123456789'),
	(2, 'Nieto', '987654321'),
	(3, 'Danilo', '987654321'),
	(4, 'Jackson', '987654321'),
	(5, 'Ana', '987654321');

--Ferramentas--
CREATE TABLE tb_ferramentas (
	id INT NOT NULL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	marca VARCHAR(50) NOT NULL,
	preco DECIMAL(7 , 2 ) NOT NULL
);

INSERT INTO tb_ferramentas (id, nome, marca, preco) VALUES
	(1, 'Martelo', 'Marca A', 10.50),
	(2, 'Chave de Fenda', 'Marca B', 5.25),
	(3, 'Furadeira', 'Marca C', 50.00);

--Emprestimo--
CREATE TABLE tb_emprestimos (
	id INT NOT NULL PRIMARY KEY,
	id_amigo INT NOT NULL,
	id_ferramenta INT NOT NULL,
	data_emprestimo TIMESTAMP DEFAULT NOW() NOT NULL,
	data_limite DATE,
	data_finalizado DATE,
	FOREIGN KEY (id_amigo) REFERENCES tb_amigos (id),
	FOREIGN KEY (id_ferramenta) REFERENCES tb_ferramentas (id)
);

--Empréstimo geral--
INSERT INTO tb_emprestimos (id, id_amigo, id_ferramenta) VALUES
	(1, 1, 1),
	(2, 2, 3),
	(3, 3, 2);

--Empréstimo pendente--
INSERT INTO tb_emprestimos (id, id_amigo, id_ferramenta, data_limite) VALUES (4, 4, 2, '2024-06-03');

--Empréstimo concluído--
INSERT INTO tb_emprestimos (id, id_amigo, id_ferramenta, data_finalizado) VALUES (5, 5, 3, '2024-06-03');

--Empréstimos totais--
SELECT a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco
	FROM tb_emprestimos e
	JOIN tb_amigos a ON e.id_amigo = a.id
	JOIN tb_ferramentas f ON e.id_ferramenta = f.id;

--Empréstimos pendentes--
SELECT a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco
	FROM tb_emprestimos e
    JOIN tb_amigos a ON e.id_amigo = a.id
    JOIN tb_ferramentas f ON e.id_ferramenta = f.id
    WHERE e.data_limite IS NOT NULL AND e.data_limite < CURRENT_DATE AND e.data_finalizado IS NULL;

--Empréstimos concluídos--
SELECT a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco
	FROM tb_emprestimos e
    JOIN tb_amigos a ON e.id_amigo = a.id
    JOIN tb_ferramentas f ON e.id_ferramenta = f.id
    WHERE e.data_finalizado IS NOT NULL;
