package com.ibm.academia.restapi.datos;

import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;

public class DatosDummy 
{
	public static Tarjeta tarjeta01()
	{
		return new Tarjeta(null, "Shopping", 7000.0, 14999.0, 18, 23, "B.smart,Afinity Cart");
	}
	public static Tarjeta tarjeta02()
	{
		return new Tarjeta(null,"Shopping", 7000.0, 14999.0, 24, 32,"B.Smart,Afinity Card" );
	}
	public static Tarjeta tarjeta03()
	{
		return new Tarjeta(null,"Shopping", 7000.0, 14999.0, 33, 75,"B.Smart,Afinity Card" );
	}
}
