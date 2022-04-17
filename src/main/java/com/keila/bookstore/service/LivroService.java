package com.keila.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keila.bookstore.dominio.Livro;
import com.keila.bookstore.repositories.LivroRepository;
import com.keila.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + ", Tipo: " + Livro.class.getName()));
		
	}

}
