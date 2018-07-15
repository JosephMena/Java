package org.zer0.ejemplos.java8.lambda.interfazFuncional;

import java.util.function.Consumer;

public class EjemploConsumer {

	public static void main(String[] args) {
		EjemploConsumer ejemplo=new EjemploConsumer();
		ejemplo.consumidor();
	}
	
	//Los consumidores pueden recibir N parametros (para este caso 1 parametro) y no devuelven nada.
	private void consumidor() {
		Consumer<String> consumidor=(String nombre)->{System.out.println(nombre);};
		consumidor.accept("joseph");
	}
	
}
