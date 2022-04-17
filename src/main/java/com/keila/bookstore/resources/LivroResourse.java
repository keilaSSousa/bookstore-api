package com.keila.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keila.bookstore.dominio.Livro;
import com.keila.bookstore.dtos.LivroDTO;
import com.keila.bookstore.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResourse {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		
		Livro obj= livroService.findById(id);
		return ResponseEntity.ok().body(obj);	
		
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat){
		List<Livro> livros = livroService.findAll(id_cat);
		
		List<LivroDTO> listDto = livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
		//localhost:8080/livros?categoria=1
		
	}
}
