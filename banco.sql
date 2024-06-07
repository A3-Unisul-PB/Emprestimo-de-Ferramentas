-- Amigos
CREATE TABLE IF NOT EXISTS tb_amigos (
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


-- Ferramentas
CREATE TABLE IF NOT EXISTS tb_ferramentas(
	id INT NOT NUll primary key,
	nome varchar(50) NOT NUll,
	marca varchar(50) NOT NUll,
	preco decimal(7,2) NOT NULL
);

INSERT INTO tb_ferramentas (id, nome, marca, preco) VALUES
	(1, 'Martelo', 'Marca A', 10.50),
	(2, 'Chave de Fenda', 'Marca B', 5.25),
	(3, 'Furadeira', 'Marca C', 50.00);


-- Empréstimos
CREATE TABLE IF NOT EXISTS tb_emprestimos (
    id INT NOT NULL PRIMARY KEY,
    id_amigo INT NOT NULL,
    id_ferramenta INT NOT NULL,
    data_emprestimo TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    data_limite DATE,
    data_finalizado DATE,
    FOREIGN KEY (id_amigo) REFERENCES tb_amigos(id),
    FOREIGN KEY (id_ferramenta) REFERENCES tb_ferramentas(id)
);

-- Inserir empréstimo genérico
INSERT INTO tb_emprestimos (id, id_amigo, id_ferramenta) VALUES
	(1, 1, 1),
	(2, 2, 3),
	(3, 3, 2);

-- Inserir empréstimo pendente
INSERT INTO tb_emprestimos (id, id_amigo, id_ferramenta, data_limite) VALUES (4, 4, 2, '2024-06-03');

-- Inserir empréstimo concluído
INSERT INTO tb_emprestimos (id, id_amigo, id_ferramenta, data_finalizado) VALUES (5, 5, 3, '2024-06-03');

-- Lista todos os empréstimos
SELECT a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco
	FROM tb_emprestimos e
	JOIN tb_amigos a ON e.id_amigo = a.id
	JOIN tb_ferramentas f ON e.id_ferramenta = f.id;

-- Lista todos os empréstimos pendentes
SELECT a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco
	FROM tb_emprestimos e
    JOIN tb_amigos a ON e.id_amigo = a.id
    JOIN tb_ferramentas f ON e.id_ferramenta = f.id
    WHERE e.data_limite IS NOT NULL AND e.data_limite < CURRENT_DATE AND e.data_finalizado IS NULL;

-- Lista todos os empréstimos concluídos
SELECT a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco
	FROM tb_emprestimos e
    JOIN tb_amigos a ON e.id_amigo = a.id
    JOIN tb_ferramentas f ON e.id_ferramenta = f.id
    WHERE e.data_finalizado IS NOT NULL;

-- Lista o usuário com mais empréstimos
SELECT a.nome, a.telefone
	FROM tb_amigos a
	JOIN (
      SELECT e.id_amigo, COUNT(e.id_amigo) AS total_emprestimos
      FROM tb_emprestimos e
      GROUP BY e.id_amigo
	) AS emprestimos_por_amigo ON a.id = emprestimos_por_amigo.id_amigo
	ORDER BY emprestimos_por_amigo.total_emprestimos DESC
     LIMIT 1;

-- Lista o preço total de todas as ferramentas somadas
SELECT SUM(f.preco) AS preco_total_emprestado
FROM tb_emprestimos e
JOIN tb_ferramentas f ON e.id_ferramenta = f.id;

-- Verifica se o usuário possui empréstimos pendentes ou não
SELECT EXISTS (
    SELECT 1
    FROM tb_emprestimos
    WHERE id_amigo = 1 AND data_limite IS NOT NULL AND data_limite < CURRENT_DATE AND data_finalizado IS NULL
) AS possui_emprestimo_pendente;
