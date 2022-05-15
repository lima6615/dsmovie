package com.projecao.projeto.dsmovie.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource " + id + " not Find");
	}
}
