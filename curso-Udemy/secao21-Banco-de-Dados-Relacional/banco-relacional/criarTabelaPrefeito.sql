CREATE TABLE IF NOT EXISTS prefeitos (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cidade_id INT UNSIGNED,
    PRIMARY KEY (id),
    UNIQUE KEY (cidade_id), -- Torna cada cidade_id um valor único não permite que seja duplicado na mesma tabela
    FOREIGN KEY (cidade_id) REFERENCES cidades (id)
);