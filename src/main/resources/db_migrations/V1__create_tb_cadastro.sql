-- Cria tb_missoes primeiro (pois tb_cadastro referencia ela)
CREATE TABLE tb_missoes (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome       VARCHAR(255),
    descricao  VARCHAR(255),
    dificuldade CHAR(1)
);

-- Cria tb_cadastro com FK para tb_missoes
CREATE TABLE tb_cadastro (
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    idade    INTEGER,
    tasks_id BIGINT,
    FOREIGN KEY (tasks_id) REFERENCES tb_missoes(id)
);