CREATE TABLE tb_amigos (
    id_amigo INT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);

INSERT INTO tb_amigos (id_amigo, nome, telefone) VALUES
    (1, 'Pedro', '123456789'),
    (2, 'Nieto', '987654321'),
    (3, 'Danilo', '987654321'),
    (4, 'Jackson', '987654321'),
    (5, 'Ana', '987654321');

CREATE TABLE tb_emprestimos (
    id_emprestimo INT NOT NULL PRIMARY KEY,
    id_amigo INT NOT NULL,
    id_ferramenta INT ,
    data_emprestimo TIMESTAMP DEFAULT NOW() NOT NULL,
    data_devolucao DATE,
    entregue BOOLEAN NOT NULL,
    data_finalizado DATE
    );

INSERT INTO tb_emprestimos (id_emprestimo, id_amigo, id_ferramenta, entregue) VALUES
    (1, 1, 1, false),
    (2, 2, 3, false),
    (3, 3, 2, false);
    
CREATE TABLE tb_ferramentas (
    id_ferramenta INT NOT NUll primary key,
    nome varchar(50) NOT NUll,
    marca varchar(50) NOT NUll,
    preco decimal(7,2) NOT NULL,
    id_emprestimo INT,
    FOREIGN KEY (id_emprestimo) REFERENCES tb_emprestimos (id_emprestimo)
);

INSERT INTO tb_ferramentas (id_ferramenta, nome, marca, preco) VALUES
    (1, 'Martelo', 'Marca A', 10.50),
    (2, 'Chave de Fenda', 'Marca B', 5.25),
    (3, 'Furadeira', 'Marca C', 50.00);
    
    ALTER TABLE tb_emprestimos ADD CONSTRAINT fk_id_amigo FOREIGN KEY (id_amigo) REFERENCES tb_amigos (id_amigo);
    ALTER TABLE tb_emprestimos ADD CONSTRAINT fk_id_ferramenta FOREIGN KEY (id_ferramenta) REFERENCES tb_ferramentas (id_ferramenta);    
    
INSERT INTO tb_emprestimos (id_emprestimo, id_amigo, id_ferramenta, data_devolucao, entregue) VALUES 
   (4, 4, 2, '2024-06-03', false),
   (5, 5, 3, '2024-06-03', false);
   
   Select * from tb_emprestimos;
   
   SELECT a.nome, a.telefone
	FROM tb_amigos a
	JOIN (
      SELECT e.id_amigo, COUNT(e.id_amigo) AS total_emprestimos
      FROM tb_emprestimos e
      GROUP BY e.id_amigo
	) AS emprestimos_por_amigo ON a.id_amigo = emprestimos_por_amigo.id_amigo
	ORDER BY emprestimos_por_amigo.total_emprestimos DESC
     LIMIT 1;

SELECT a.nome AS nome_amigo, a.telefone, f.nome AS nome_ferramenta, f.preco
FROM tb_emprestimos e
JOIN tb_amigos a ON e.id_amigo = a.id_amigo
JOIN tb_ferramentas f ON e.id_ferramenta = e.id_ferramenta;
