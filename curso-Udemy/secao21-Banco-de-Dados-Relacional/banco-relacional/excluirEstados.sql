-- Deletando através da sigla
DELETE FROM estados
WHERE sigla = 'MN';

SELECT * FROM estados;

-- Podemos, também, deletar através do id
DELETE FROM estados
WHERE id = 1000;

-- Podemos, também, deletar um conjunto usando a relação de ordem
DELETE FROM estados
WHERE id >= 1000;

SELECT * FROM estados;
