package com.example.jogosApi.resource;

import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.jogosApi.Model.Categoria;
import com.example.jogosApi.repository.CategoriaRepository;
import com.example.jogosApi.repository.JogosRepository;



@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
		@GetMapping
		public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	@PostMapping	
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();				
	}
		
}
