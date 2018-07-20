package org.zer0.ejemplos.java8.referenciaAMetodos.metodoInstanciaArbitraria;

public class ClasePruebas {

	public void metodoSinRetornoSinParametros() {
		System.out.println("Esta es la instancia:"+this);
	}
	
	public void metodoSinRetorno_1Parametro(String nombre) {
		System.out.println("Hello "+nombre);
	}
	
	public String metodoRetorno_2Parametro(String saludo,String nombre) {
		return saludo+nombre;
	}
}
