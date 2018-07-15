package org.zer0.ejemplos.java8.lambda.interfazFuncional;

import java.math.BigInteger;
import java.util.function.BiFunction;

public class EjemploBiFunction {

	public static void main(String[] args) {
		EjemploBiFunction ejemplo=new EjemploBiFunction();
		ejemplo.biFuncion();
	}
	
	private void biFuncion() {
		BiFunction<Integer,Integer,BigInteger> funcion=(x,y)->{return BigInteger.valueOf(x).add(BigInteger.valueOf(y));};
		BigInteger resultado=funcion.apply(1000000, 50000);
		System.out.println("resultado:"+resultado);
	}
	
}
