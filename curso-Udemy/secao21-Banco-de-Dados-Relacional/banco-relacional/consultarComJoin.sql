-- Se eu fizer a consulta abaixo ficará estranho
-- pois vamos ver que não teremos a coluna nome do estados
-- Além disso, note que o id do estado e da cidades está tudo desordenado
-- Literalmente, foi considerado o produto cartesiano da tabela estados e cidades
SELECT * FROM estados e, cidades c;

-- Agora, colocando a restrição, finalmente, estamos colocando uma relação
-- e.id = c.estado_id
-- No caso, isso nos dará um subconjunto do produto cartesiano
-- Ou seja, R = {(x,y) in estados x cidades; x.id = y.estados_id} subset estados x cidades
SELECT * FROM estados e, cidades c
WHERE e.id = c.estado_id;

-- Agora, se colocarmos a coluna nome, dará um erro
-- pois a coluna "nome" é um nome ambíguo
SELECT nome FROM estados e, cidades c
WHERE e.id = c.estado_id;

-- Por isso o alias, apelido, servirá para tirar essa ambiguidade
SELECT e.nome, c.nome, regiao FROM estados e, cidades c
WHERE e.id = c.estado_id;

-- Melhorando a vizualizacao usando alias
SELECT
    e.nome as Estado,
    c.nome as Cidade,
    regiao as Região
FROM estados e, cidades c
WHERE e.id = c.estado_id;

-- Usando o INNER JOIN
SELECT
    c.nome as Cidade,
    e.nome as Estados,
    regiao as Região
FROM estados e
INNER JOIN cidades c
ON e.id = c.estado_id;
