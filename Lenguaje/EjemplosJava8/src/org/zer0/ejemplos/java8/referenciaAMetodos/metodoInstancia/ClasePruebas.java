package org.zer0.ejemplos.java8.referenciaAMetodos.metodoInstancia;

public class ClasePruebas {

	
	
	public void metodoSinRetornoSinParametros() {
		System.out.println("Hello world!");
	}
	
	public void metodoSinRetorno_1Parametro(String nombre) {
		System.out.println("Hello "+nombre);
	}
	
	public String metodoRetorno_2Parametro(String saludo,String nombre) {
		return saludo+nombre;
	}
}
