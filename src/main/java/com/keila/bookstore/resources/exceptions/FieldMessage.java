package com.keila.bookstore.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String fieldMessage;
	public String getFieldName() {
		return fieldName;
	}
	
	
	
	public FieldMessage(String fieldName, String fieldMessage) {
		super();
		this.fieldName = fieldName;
		this.fieldMessage = fieldMessage;
	}



	public FieldMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldMessage() {
		return fieldMessage;
	}
	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}
	
	

}
