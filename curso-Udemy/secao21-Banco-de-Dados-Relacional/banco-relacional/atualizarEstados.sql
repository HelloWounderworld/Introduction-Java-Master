-- Tome muito cuidado quando for usar o update!
-- Se não colocar o where, a coluna indicada no set,
-- irá atualizar tudo pelo mesmo nome.
UPDATE estados
SET nome = 'Maranhão'
WHERE sigla = 'MA';

SELECT nome FROM estados
WHERE sigla = 'MA';

-- Podemos usar o `` nas colunas que não tem problema
SELECT `nome` FROM estados
WHERE sigla = 'MA';

UPDATE estados
SET nome = 'Paraná', 
    populacao = 11.32
WHERE sigla = 'PR';

SELECT nome FROM estados
WHERE sigla = 'PR';

-- Usamos o alias para apelidar a tabela estados para est
-- ela serve para ajudar a distinguir as colunas que tem o mesmo nome
-- Se por acaso tivermos duas tabelas onde ambas, tem a mesma coluna
-- com o mesmo nome, o alias ajuda a distinguir
-- est.nome e muni.nome, onde "estados est" e "municipio muni"
SELECT 
    est.nome,
    sigla,
    populacao
FROM estados est
WHERE sigla = 'PR';