INSERT INTO estados (id, nome, sigla, regiao, populacao)
VALUES (1000, 'Novo', 'NV', 'Sul', 2.54);

SELECT * FROM estados;

-- Visto que colocamos o id como 1000 acima, se realizarmos, agora,
-- um novo insert sem o id como ficaria?
INSERT INTO estados (nome, sigla, regiao, populacao)
VALUES ('Mais Novo', 'MN', 'Norte', 2.51);

-- Note que, o insert, sem o id, acima considerou a partir do maior id, 1000
SELECT * FROM estados;
