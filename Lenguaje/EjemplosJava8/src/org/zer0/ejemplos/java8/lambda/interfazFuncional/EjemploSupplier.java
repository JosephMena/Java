package org.zer0.ejemplos.java8.lambda.interfazFuncional;

import java.util.function.Supplier;

public class EjemploSupplier {

	public static void main(String[] args) {
		
	}
	
	public void suministradorComoParametro() {
		Supplier<Integer> suministro=()->{return new Double(Math.random()*10).intValue();};
		generar(suministro, 1);
	}
	
	//Como se puede ver a este metodo se puede encargar de generar cualquier tipo de valor, dependiendo de la clase de suministro que se le envie
	public Integer generar(Supplier<Integer> suministro,Integer valor) {
		return suministro.get()+valor;
	}
	
}
