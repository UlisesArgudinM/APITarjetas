package com.ibm.academia.restapi.tarjetas.exception;

public class BadRequestException extends RuntimeException
{
	public BadRequestException(String mensaje)
	{
		super(mensaje);
	}
		
		private static final long serialVersionUID = 7664014013800001358L;
}
