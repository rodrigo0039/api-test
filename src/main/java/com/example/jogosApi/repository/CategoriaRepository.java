package com.example.jogosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jogosApi.Model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}
