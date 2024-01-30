-- Se tentarmos inserir a forma como está o cnpj abaixo irá dar um erro de pouco espaço
INSERT INTO empresas
    (nome, cnpj)
VALUES
    ('Bradesco', 95694186000132),
    ('Vale', 31221138000144),
    ('Cielo', 48904361000199);

SELECT * FROM empresas;
SELECT * FROM cidades;

-- Vamos modificar as características da coluna cnpj para possbilitar a inserção
ALTER TABLE empresas MODIFY cnpj VARCHAR(14);

-- Caso vc queira mostrar a descrição de como a tabela foi arquitetada, então
DESC empresas;
DESC prefeitos;

INSERT INTO empresas_unidades
    (empresa_id, cidade_id, sede)
VALUES
    (1, 1, 1),
    (1, 2, 0),
    (2, 1, 0),
    (2, 2, 1);

SELECT * FROM empresas_unidades;
