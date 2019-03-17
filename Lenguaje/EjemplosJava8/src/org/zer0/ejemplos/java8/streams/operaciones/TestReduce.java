package org.zer0.ejemplos.java8.streams.operaciones;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.zer0.ejemplos.java8.streams.TestBasic;

public class TestReduce{ 

	private static final List<Integer> lstNumeros=Arrays.asList(1,23,45,4,23,7,76,54,1,4,9,67,54,34,5,27,0,42,105);
	
	// Reduce es una operacion que sirve para combinar elementos y producir un nuevo valor.
	// Casos donde se pueda usar son:
	//  - Encontrar el maximo valor de un conjunto de numeros
	//  - Sumar/Multiplicar todos los elementos de una lista
	//  - Concatenar cadenas
	

	// En este caso la operacion reduce esta recibiendo un acumulador (BinaryOperator<String>) como parametro  
	private void operacionReduce() {
		Stream<String> flujo=Stream.of("Joseph","Pedro","Sihuacollo","Martin","Paul","Pantro");
		flujo.reduce(
					(n1,n2)->n1+","+n2
			 ).ifPresent(System.out::println);;
	}
	
	// En este caso se hace uso del identity y un acumulador, identity se usa para agregar un valor adicional
	// al stream, y en este caso es el valor inicial que se operara contra los demas elementos del stream
	private void operacionReduce2() {
		Stream<Integer> flujo=lstNumeros.stream();
		int valorMaximo = flujo.reduce(110,
					(n1,n2)->{return n1>n2?n1:n2;}
			 ).intValue();
		System.out.println("valor Maximo:"+valorMaximo);
	}
	
	// Tambien existe el caso de que el identity no es del mismo tipo que los valores del stream
	// para ese caso es obligatorio adicionar un tercer parametro
	private void operacionReduce3() {
		Stream<Integer> flujo=lstNumeros.stream();
		String finalText = flujo.reduce("Text Final:",
					(n1,n2)->{return n1+n2+",";},
					(n1,n2)->n1
			 );
		System.out.println(finalText);
	}
	
	//En este ejemplo se encuentra el maximo valor
	private void operacionReduceMaximoValor() {
		IntStream flujo=Arrays.stream(new int[] {1,4,6,8,2,20,6,10});
		flujo.reduce(
				(n1,n2)->{return n1>n2?n1:n2;}
				)
			 .ifPresent(System.out::println);;
	}
	
	//En este ejemplo se encuentra el maximo valor pero usar el Integer.max(a,b)
	private void operacionReduceMaximoValor2() {
		Stream<Integer> flujo=lstNumeros.stream();
		flujo.reduce(Integer::max).ifPresent(System.out::println);;
	}
	
	public static void main(String[] args) {
		TestReduce test=new TestReduce();
		test.operacionReduce3();
	}
}
