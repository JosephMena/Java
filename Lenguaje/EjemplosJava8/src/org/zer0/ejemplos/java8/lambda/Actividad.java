package org.zer0.ejemplos.java8.lambda;

public class Actividad {

	public static void realizarActividadEstatica(String parametro){
		System.out.println("esta es un metodo estatico, parametro:"+parametro);
	}
	
	public static void realizarActividadEstaticaDosParams(String parametro1,String parametro2){
		System.out.println("esta es un metodo estatico, parametro 1:"+parametro1+" - parametro 2:"+parametro2);
	}
	
	public static String realizarActividadEstaticaDosParamsConReturn(String parametro1,String parametro2){
		return "esta es un metodo estatico, parametro 1:"+parametro1+" - parametro 2:"+parametro2;
	}
	
}
