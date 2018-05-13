package org.zer0.ejemplos.java8.referenciaAMetodos;

public class Persona {

	private String nombre;

	public Persona() {
	}
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public void imprimirMiNombre() {
		System.out.println("mi nombre es:"+nombre);
	}
	
	public void imprimirMiNombre2(String a) {
		System.out.println("mi nombre es:"+nombre);
	}
	
	public void imprimirMiNombre3(Persona a) {
		System.out.println("mi nombre es:"+nombre);
	}
}
