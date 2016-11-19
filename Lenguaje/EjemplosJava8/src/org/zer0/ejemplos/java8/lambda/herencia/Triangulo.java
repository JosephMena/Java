package org.zer0.ejemplos.java8.lambda.herencia;

public abstract class Triangulo {

	protected Integer altura;
	protected Integer base;
	
	public int calcularArea(){
		return (base*altura)/2;
	}
}
