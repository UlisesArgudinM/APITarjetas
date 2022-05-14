package com.ibm.academia.restapi.datos;

import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;

public class DatosDummy 
{
	public static Tarjeta tarjeta01()
	{
		return new Tarjeta(1,"Shopping", 7000, 14999, 18, 23,"B.Smart,Afinity Card" );
	}
	public static Tarjeta tarjeta02()
	{
		return new Tarjeta(1,"Shopping", 7000, 14999, 24, 32,"B.Smart,Afinity Card" );
	}
	public static Tarjeta tarjeta03()
	{
		return new Tarjeta(1,"Shopping", 7000, 14999, 33, 75,"B.Smart,Afinity Card" );
	}
}
