package org.zer0.ejemplos.java8.lambda.interfazFuncional;

import java.util.function.Function;

public class EjemploFunction {

	public static void main(String[] args) {
		EjemploFunction ejemplo=new EjemploFunction();
		ejemplo.funcion();
	}
	
	//Las funciones reciben un paramtro y devuelven un valor, usada para la transformacion de la data
	// Firma: Funtion<P,R> , donde R es el parametro de retorno.
	private void funcion() {
		Function<String,String> funcion=(String nombre)->{return "Hola "+nombre;};
		String resultado=funcion.apply("Joseph");
		System.out.println("resultado:"+resultado);
	}
	
}
