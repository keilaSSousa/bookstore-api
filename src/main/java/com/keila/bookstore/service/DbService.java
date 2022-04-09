package com.keila.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keila.bookstore.dominio.Categoria;
import com.keila.bookstore.dominio.Livro;
import com.keila.bookstore.repositories.CategoriaRepository;
import com.keila.bookstore.repositories.LivroRepository;

@Service
public class DbService {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "como programar");
		Categoria cat2 = new Categoria(null, "Ficção cientifica", "Ficção cientifica");
		Categoria cat3 = new Categoria(null, "biografias", "livros de biografias");
		
		Livro l1= new Livro(null, "java", "joaozinho", "algoritimos", cat1);
		Livro l2= new Livro(null, "Engenharia de software", "loius", "lorem ipsum", cat1);
		Livro l3= new Livro(null, "the time machine", "h.g", "lorem ipsum", cat2);
		Livro l4= new Livro(null, "the wars of the words", "h.s", "ipsum", cat2);
		Livro l5= new Livro(null, "I, Robot", "joaozinho", "ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}

}
