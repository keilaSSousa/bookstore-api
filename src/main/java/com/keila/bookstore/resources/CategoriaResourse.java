package com.keila.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keila.bookstore.dominio.Categoria;
import com.keila.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResourse {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		 Categoria categoria = categoriaService.findById(id);
		 
		 return ResponseEntity.ok().body(categoria); 
	}

}
