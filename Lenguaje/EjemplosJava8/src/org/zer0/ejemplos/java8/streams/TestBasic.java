package org.zer0.ejemplos.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.zer0.ejemplo.java8.util.Persona;

public class TestBasic {
	
	private static final List<Integer> lstNumeros=Arrays.asList(1,23,45,4,23,7,76,54,1,4,9,67,54,34,5,27,0,42,105);
	
	
	public static void main(String[] args) {
		TestBasic t =  new TestBasic();
		t.test();
	}
	
	private void test() {
		Stream<Integer> numeros = lstNumeros.stream();
		
		numeros.map(
					n-> {
						System.out.println("invocacion primer map");
						return n;
					})
				.map(
					n-> {
						System.out.println("invocacion segundo map");
						return n;
						}	
					)
				.filter(
					n-> {
						System.out.println("filter!");
						return n>10;
					}
					)
				.findFirst();
		
	}
	

}



