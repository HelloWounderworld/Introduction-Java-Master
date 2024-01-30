-- Dados A e B conjuntos não vazios

-- JOIN

-- INNER JOIN - Intersecação entre A e B
SELECT * FROM prefeitos;
SELECT * FROM cidades;
SELECT * FROM cidades c INNER JOIN prefeitos p ON c.id = p.cidade_id;

-- OUTER JOIN - A triangulo B = A U B complemento A intersecção de B

-- LEFT JOIN - mostra a intersecção com A e B unido com o complemento de A relativo ao B = LEFT OUTER JOIN
SELECT * FROM cidades c LEFT JOIN prefeitos p ON c.id = p.cidade_id;
SELECT * FROM cidades c LEFT OUTER JOIN prefeitos p ON c.id = p.cidade_id;

-- RIGHT JOIN - RIGHT OUTER JOIN, mesmo analogia do LEFT JOIN, mas para direita.
SELECT * FROM cidades c RIGHT JOIN prefeitos p ON c.id = p.cidade_id;
SELECT * FROM cidades c RIGHT OUTER JOIN prefeitos p ON c.id = p.cidade_id;

-- FULL JOIN - União de A e B - Esse tipo de consulta não é suportado pelo MySQL...
SELECT * FROM cidades c FULL JOIN prefeitos p ON c.id = p.cidade_id;
-- O FULL JOIN é o mesmo que cartesiano, AxB
SELECT * FROM cidades c LEFT OUTER JOIN prefeitos p ON c.id = p.cidade_id
UNION
SELECT * FROM cidades c RIGHT OUTER JOIN prefeitos p ON c.id = p.cidade_id;

-- Irá trazer as duplicações tbm - União mesmo
SELECT * FROM cidades c LEFT OUTER JOIN prefeitos p ON c.id = p.cidade_id
UNION ALL
SELECT * FROM cidades c RIGHT OUTER JOIN prefeitos p ON c.id = p.cidade_id;
