package com.keila.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
		Livro newObj = this.livroService.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
		Livro newObj = this.livroService.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue="0") Integer id_cat, @RequestBody Livro obj){
		Livro newObj= this.livroService.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		this.livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
 }
