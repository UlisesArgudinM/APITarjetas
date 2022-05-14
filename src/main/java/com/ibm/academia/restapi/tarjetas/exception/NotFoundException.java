package com.ibm.academia.restapi.tarjetas.exception;

public class NotFoundException extends RuntimeException
{
	public NotFoundException(String mensaje)
	{
		super(mensaje);
	}
	private static final long serialVersionUID = -1419602753696221823L;
}
