package org.zer0.ejemplos.java8.lambda.interfazFuncional;

public class Test {

	
	public static void main(String[] args) {
		Test test=new Test();
		test.procesarGenerico();
		test.procesarParametroGenerico();
	}
	
	public void procesarGenerico() {
		/* En este ejemplo se demuestra que pueden existir Interfaces Funcionales con Generics*/
		Generico<String> saludar=(String mensaje)->{System.out.println("este es un mensaje:"+mensaje);};
		Generico<Integer> adicionar=(Integer i)->{System.out.println(i+54);};
		saludar.procesar("para Joseph");
		adicionar.procesar(5);
	}
	
	public void procesarComoParametro(Generico<String> generico,String dato) {
		generico.procesar(dato);
	}
	
	public void procesarParametroGenerico() {
		Generico<String> saludar=(String mensaje)->{System.out.println("este es un mensaje:"+mensaje);};
		procesarComoParametro(saludar, " de otro mundo");
	}
	
}
