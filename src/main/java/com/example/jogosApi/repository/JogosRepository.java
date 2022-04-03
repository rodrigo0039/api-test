package com.example.jogosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jogosApi.Model.Jogos;

public interface JogosRepository extends JpaRepository<Jogos, Long> {
		
}
