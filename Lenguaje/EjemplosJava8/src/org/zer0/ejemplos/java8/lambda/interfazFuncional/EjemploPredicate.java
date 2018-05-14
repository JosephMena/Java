package org.zer0.ejemplos.java8.lambda.interfazFuncional;

import java.util.function.Predicate;

public class EjemploPredicate {

	public static void main(String[] args) {
		EjemploPredicate ejemplo=new EjemploPredicate();
		ejemplo.predicado();
	}
	
	//Un predicado es aquel que dado un valor retorna un booleano, un predicado es un operador logico.
	private void predicado() {
		Predicate<Integer> menorQue5=(valor)->{return valor<5;};
		System.out.println(menorQue5.test(10));
	}
	
}
