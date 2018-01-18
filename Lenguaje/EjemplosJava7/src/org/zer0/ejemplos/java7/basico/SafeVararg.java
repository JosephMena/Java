package org.zer0.ejemplos.java7.basico;

public class SafeVararg {

	// Antes de la version 7 de java, el parseador de java habria arrojado un warning en la linea 18.
	// Este warning se debia a que el compilador intentaria crear un array de Pair, pero esto no es permitido ya que Pair esta hecho
	// con Generics, en ese caso (java < 1.7 ) el warning hubiera sido "salvado" poniendo la anotacion @SuppressWarning para cada metodo
	// el cual llamara al metodo vararg.
	// Con java 7 ya no es necesario ello, si no solamente poner la anotacion @SafeVarargs al metodo que contiene el parametro vararg.
	// Con ello se logra reducir el numero total de warnings.
	
	@SafeVarargs
	public static <T> void print(T... a) {
		for (T t : a) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		print("Hello", "World"); // this is fine
		print(new Pair<Integer, String>(1, "One"), new Pair<Integer, String>(2, "Two"));
	}

}
