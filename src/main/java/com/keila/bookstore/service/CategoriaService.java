package com.keila.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keila.bookstore.dominio.Categoria;
import com.keila.bookstore.repositories.CategoriaRepository;
import com.keila.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	public Categoria findById(Integer id) {
		Optional<Categoria> objetoCategoria = this.categoriaRepository.findById(id);
		
		return objetoCategoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id:" + id + ", Tipo:" + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return this.categoriaRepository.findAll();
	}
	
	public Categoria inserirCategoria(Categoria categoria) {
		categoria.setId(null);
		return this.categoriaRepository.save(categoria);
	}

}
