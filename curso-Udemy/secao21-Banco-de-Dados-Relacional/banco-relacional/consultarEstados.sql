SELECT * FROM estados;

SELECT nome, sigla FROM estados;

SELECT sigla, nome FROM estados;

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