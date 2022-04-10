package com.keila.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keila.bookstore.dominio.Categoria;
import com.keila.bookstore.dtos.CategoriaDTO;
import com.keila.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResourse {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findById(id);

		return ResponseEntity.ok().body(categoria);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {

		List<Categoria> listaCategoria = this.categoriaService.findAll();
		// As duas formas são válidas
		// List<CategoriaDTO> listaCategoriaDtos = listaCategoria.stream().map(obj-> new
		// CategoriaDTO(obj)).collect(Collectors.toList());
		List<CategoriaDTO> listaCategoriaDtos = listaCategoria.stream().map(CategoriaDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaCategoriaDtos);

	}

}
