SELECT * FROM estados;

SELECT nome, sigla FROM estados;

SELECT sigla, nome FROM estados;

-- Colocando a coluna "nome" como "Nome do Estado"
SELECT 
    sigla, 
    nome as "Nome do Estado" 
FROM estados
WHERE regiao = 'Sul';

SELECT nome, regiao FROM estados
WHERE populacao >= 10;

-- Ascendente
SELECT nome, regiao FROM estados
WHERE populacao >= 10
ORDER BY populacao;

SELECT nome, regiao FROM estados
WHERE populacao >= 10
ORDER BY populacao DESC;

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

-- Podemos usar o `` nas colunas que não tem problema
SELECT `nome` FROM estados
WHERE sigla = 'MA';