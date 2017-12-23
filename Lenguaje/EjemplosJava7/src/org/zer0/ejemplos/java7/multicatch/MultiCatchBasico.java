package org.zer0.ejemplos.java7.multicatch;

public class MultiCatchBasico {

	
	public static void main(String[] args) {
		// Como se puede apreciar, en el catch ahora se puede poner todas las excepciones que seran tratadas con ese bloque de codigo.
		try {
			String numero="546";
		    int entero = Integer.parseInt(numero);
		    int resultado = 100 / entero;
		    System.out.println(resultado);
		} catch(NumberFormatException | ArithmeticException ex ) {
		    System.out.println("no es valido");
		}
	}
}
