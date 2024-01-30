-- Será feito uma soma total das populações de cada regiao
-- provavelmente, só possível realizar esse processo
-- visto que a regiao está enumerado no momento da criação da
-- tabela estados
-- regiao ENUM('Norte', 'Nordeste', 'Centro-Oeste', 'Sudeste', 'Sul') NOT NULL,
SELECT 
    regiao as 'Regiao',
    sum(populacao) as Total
FROM estados
GROUP BY regiao
ORDER BY Total DESC;

-- Total de tudo
SELECT
    sum(populacao) as Total
FROM estados;

-- Pegando a média
-- A divisao foi feita pela quantidade de linhas
SELECT
    avg(populacao) as Total
FROM estados;
