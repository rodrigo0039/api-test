package com.example.jogosApi.resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.jogosApi.Model.Jogos;
import com.example.jogosApi.repository.JogosRepository;

@RestController
@RequestMapping("/jogos")
public class JogosResource {
	
	
	private static String caminhoImagen ="C:\\Users\\Rodrigo\\projetos\\loja_jogos\\src\\assets\\img\\";
	
	
	@Autowired
	private JogosRepository jogosRepository;
	
	@CrossOrigin(maxAge = 10 , origins = "http://localhost:4200")
	@GetMapping
	public List<Jogos> listar(){
		return jogosRepository.findAll();
	}
	
	@PostMapping() 
	public ResponseEntity<Jogos> criar(@Valid Jogos jogos, HttpServletResponse response, 
			@RequestParam(value = "file", required=false) MultipartFile arquivo){
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		try {
			if(!arquivo.isEmpty()) {
				byte [] bytes = arquivo.getBytes();
				Path caminho = Paths.get(caminhoImagen +dtf.format(LocalDateTime.now()) + String.valueOf(jogos.getCodigo()) + arquivo.getOriginalFilename());
				Files.write(caminho, bytes);
				jogos.setImagem(dtf.format(LocalDateTime.now()) + String.valueOf(jogos.getCodigo()) + arquivo.getOriginalFilename());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Jogos jogosSalvo = jogosRepository.save(jogos);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(jogosSalvo);
	}
	
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("codigo") Long codigo) {
		jogosRepository.deleteById(codigo);
	}
	
	@GetMapping("/mostrar/imagem/{imagem}")
	
	public byte[] mostrarImagem(@PathVariable("imagem") String imagem ){
		
		try {
		File imagemArquivo = new File(caminhoImagen+imagem);
		
		System.out.print(imagem);
		
		return Files.readAllBytes(imagemArquivo.toPath());
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
