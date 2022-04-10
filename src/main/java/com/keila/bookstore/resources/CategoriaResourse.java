package com.keila.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@PostMapping
	public ResponseEntity<Categoria> inserirCategoria(@RequestBody Categoria categoria){
		categoria = this.categoriaService.inserirCategoria(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		//return ResponseEntity.created(uri).body(categoria);
		return ResponseEntity.created(uri).build();
		//return ResponseEntity.ok().body(cat);
		//return ResponseEntity.ok().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDto){
		
		Categoria categoria = this.categoriaService.updateCategoria(id,categoriaDto);
		
		return ResponseEntity.ok().body(new CategoriaDTO(categoria));
		
	}

}
