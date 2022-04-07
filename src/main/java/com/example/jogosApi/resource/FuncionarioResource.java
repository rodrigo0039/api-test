package com.example.jogosApi.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.jogosApi.Model.Funcionario;
import com.example.jogosApi.repository.FuncionarioRepository;

@RestController
@RequestMapping("/administrativo/funcionario")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@PostMapping
	public ResponseEntity<Funcionario> cadastro(@Valid @RequestBody Funcionario funcionario, HttpServletResponse response){
		Funcionario fucionarioSalvo = funcionarioRepository.save(funcionario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand(fucionarioSalvo.getId()).toUri();
		response.setHeader("Location", uri.toString());
		
		return ResponseEntity.created(uri).body(fucionarioSalvo);
	}
}
