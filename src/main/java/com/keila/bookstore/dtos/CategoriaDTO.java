package com.keila.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.keila.bookstore.dominio.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo NOME é requerido")
	@Length(min =3, max=100,message = "O campo NOME deve conter entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo DESCRIÇÃO é requerido")
	@Length(min =3, max=100,message = "O campo DESCRIÇÃO deve conter entre 3 e 100 caracteres")
	private String descricao;
	
	
	
	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescrição();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	

}
