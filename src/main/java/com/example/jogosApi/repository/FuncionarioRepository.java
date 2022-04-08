package com.example.jogosApi.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jogosApi.Model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	void save(Optional<Funcionario> funcionarioSalvo);


}
