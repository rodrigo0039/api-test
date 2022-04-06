CREATE TABLE funcionario(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    salario VARCHAR(50),
    dataEntrada DOUBLE,
    dataSaida VARCHAR(50),
    cargo VARCHAR(20),
    cidade VARCHAR(100),
    numero VARCHAR(20),
    complemento VARCHAR(10),
    bairro VARCHAR(20),
    cep VARCHAR(20)
    
    
)ENGINE = InnoDB DEFAULT CHARSET=utf8;