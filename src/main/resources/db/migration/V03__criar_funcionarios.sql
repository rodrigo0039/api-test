CREATE TABLE funcionario(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(20),
    salario VARCHAR(50),
    data_entrada DATE,
    data_saida DATE,
    cargo VARCHAR(20),
    cidade VARCHAR(100),
    numero VARCHAR(20),
    complemento VARCHAR(10),
    bairro VARCHAR(20),
    cep VARCHAR(20)
    
    
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO funcionario
(nome, salario, data_entrada, data_saida, cargo, cidade, numero, complemento, bairro, cep)
VALUES
("Rodrigo", 1000, null, null, "vendedor", "Fortaleza","12", "a", "Mondubum","12321");