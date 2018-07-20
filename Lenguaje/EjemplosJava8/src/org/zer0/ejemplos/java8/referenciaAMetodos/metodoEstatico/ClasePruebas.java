package org.zer0.ejemplos.java8.referenciaAMetodos.metodoEstatico;

public class ClasePruebas {
	
	public static void metodoSinRetornoySinParametros() {
		System.out.println("Hola Mundo!!!!!!");
	}
	
	public static void metodoSinRetorno_1Parametro(String nombre) {
		System.out.println("Hola "+nombre+" ....");
	}
	
	public static void metodoSinRetorno_2Parametros(String saludo,String nombre) {
		System.out.println(saludo+" "+nombre);
	}
	
	public static String metodoRetorno_2Parametros(String saludo,String nombre) {
		return saludo+" "+nombre;
	}
	
}
