package com.keila.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keila.bookstore.dominio.Livro;
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
}
