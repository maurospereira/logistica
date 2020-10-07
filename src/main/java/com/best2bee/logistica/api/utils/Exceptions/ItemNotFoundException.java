package com.best2bee.logistica.api.utils.Exceptions;

public class ItemNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	
	public ItemNotFoundException(String cnpj) {
		this.cnpj=cnpj;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	

}
