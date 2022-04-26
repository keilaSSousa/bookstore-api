package com.keila.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError {
	
	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String fieldName, String mensage) {
		this.erros.add(new FieldMessage(fieldName, mensage));
	}
	
	
	

}
