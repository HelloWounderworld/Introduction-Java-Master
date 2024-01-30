SELECT * FROM cidades;

INSERT INTO prefeitos
    (nome, cidade_id)
VALUES
    ('Rodrigo Neves', (SELECT id FROM cidades WHERE nome = 'Niteroi')),
    ('Raquel Lyra', (SELECT id FROM cidades WHERE nome = 'Caruaru')),
    ('Zenaldo Coutinho', null);

SELECT * FROM prefeitos;

-- Se colocarmos mais um prefeito com o cidade_id null, será que dará o problema de chave única?
-- Visto que foi definido essa estrutura de banco de dados para a cidade_id...
INSERT INTO prefeitos
    (nome, cidade_id)
VALUES
    ('Rafael Greca', null);

-- Note que, não tivemos problema de chave duplicada
SELECT * FROM prefeitos;

-- Entretanto, se colocarmos algum valor numérico de chave
-- Com certeza teremos um problema, independente de qual nome coloquemos
INSERT INTO prefeitos
    (nome, cidade_id)
VALUES
    ('Rodrigo Pinheiro', 3);

-- Note que, foi informado um erro de chave duplicada e não foi inserido o prefeito acima
SELECT * FROM prefeitos;
