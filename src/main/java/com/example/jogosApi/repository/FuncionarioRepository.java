package com.example.jogosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jogosApi.Model.Categoria;
import com.example.jogosApi.Model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
