CREATE TABLE jogos(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    preco DOUBLE,
    descricao VARCHAR(50),
    produtora VARCHAR(20),
    imagem VARCHAR(100),
    codigo_categoria BIGINT,
    FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
    
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO jogos (nome, preco, descricao, codigo_categoria) VALUES ("Elden Ring", 250, "Jogo Legal", 1)
