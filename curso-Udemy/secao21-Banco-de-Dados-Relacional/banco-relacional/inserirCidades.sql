SELECT * FROM estados
WHERE id = 29;

INSERT INTO cidades (nome, area, estado_id)
VALUES ('Campinas', 795, 29);

SELECT * FROM cidades;

INSERT INTO cidades (nome, area, estado_id)
VALUES ('Niterói', 133.9, 23);

SELECT * FROM cidades;

-- Uma forma de considerar o id diretamente da tabela estados, sem ter que ficar
-- toda hora colocando de forma manual.
INSERT INTO cidades
    (nome, area, estado_id)
VALUES (
    'Caruaru',
    920.6,
    (SELECT id FROM estados WHERE sigla = 'PE')
);

SELECT * FROM cidades;

INSERT INTO cidades
    (nome, area, estado_id)
VALUES (
    'Juazeiro do Norte',
    248.2,
    (SELECT id FROM estados WHERE sigla = 'CE')
);

SELECT * FROM cidades;
