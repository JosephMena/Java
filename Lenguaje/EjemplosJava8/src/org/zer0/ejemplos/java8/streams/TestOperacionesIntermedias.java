package org.zer0.ejemplos.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.zer0.ejemplo.java8.util.Persona;

public class TestOperacionesIntermedias {

private static final List<Integer> lstNumeros=Arrays.asList(1,23,45,4,23,7,76,54,1,4,9,67,54,34,5,27,0,42,105);
	
	
	public static void main(String[] args) {
		TestBasic test=new TestBasic();
		//test.operacionFilter();
		//test.operacionMap();
		//test.operacionMap2();
		//test.operacionSorted2();
		//test.operacionSkip();
	}
	
	//Filter permite que dado una lista, se filtre solo algunos de los elementos de la lista
	//para ello .filter recibe un Predicado
	private void operacionFilter() {
		List<String> lista=Arrays.asList("joseph","paul","antonia","cesar","javier","Antonio");
		List<String> listaFinal=lista.stream()
								.filter((String dato)->{return dato.startsWith("j");})
								.collect(Collectors.toList());
		listaFinal.forEach(System.out::println);
	}
	
	//Map recibe una Function, donde una funcion recibe un parametro y devuelve un valor.
	//Esta operacion se realiza sobre todos los elementos del stream.
	 
	private void operacionMap() {
		Stream<String> flujo=Stream.of("joseph","cesar","mena","sihuacollo");
		List<String> lista=flujo.map(palabra->palabra.toUpperCase()).collect(Collectors.toList());//map(String::toUpperCase) su parametro es la intancia de String, ejemplo: joseph
		lista.forEach(System.out::println);
	}
	
	//Tambien puede ser usado para transformar un objeto en otro, o para extraer parte de un objeto.
	//En este ejemplo se extrae el campo nombre del objeto Persona
	private void operacionMap2() {
		List<Persona> personas=Arrays.asList(new Persona("joseph", 33),new Persona("cesar", 64));
		personas.stream()
				.map(Persona::getNombre).forEach(System.out::println);;
	}

	//	
	private void operacionFlatMap() {
		
	}
	
	private void operacionSorted() {
		Stream<String> array=Arrays.stream(new String[]{"Paul","Erik","Joseph","Cesar","Teodomiro"});
		array.sorted().forEach(System.out::println);
	}
	
	private void operacionSorted2() {
		Stream<String> array=Arrays.stream(new String[]{"Paul","Erik","Joseph","Cesar","Teodomiro"});
		array.sorted(String::compareTo).forEach(System.out::println);
		
	}
	
	private void intStream() {
		IntStream stream=Arrays.stream(new int[] {1,2,4,6,2});
		OptionalDouble op=stream.average();
		System.out.println(op.getAsDouble());
	}
	
	//La operacion limit(n) devuelve un Stream con el numero de elementos pasado como parametro
	private void operacionLimit() {
		Stream<Integer> streamNumeros=lstNumeros.stream();
		Stream<Integer> streamFiltrado=streamNumeros.limit(2);
	}
	
	//La operacion distinct devuelve un Stream con solo aquellos elementos que sean unicos, es decir no hay elementos repetidos, para eso se ayuda del metodo equals.
	private void operacionDistinct() {
		Stream<Integer> streamNumeros=lstNumeros.stream();
		Stream<Integer> streamFiltrado=streamNumeros.distinct();
	}
	
	//La operacion skip(n) retorna un stream con solo aquellos elementos que van mas alla del elemento n, por ej si en el stream hay 5 elementos
	//y el parametro de skip es 2, el stream resultante tiene los elementos de posicion 3,4 y 5.
	private void operacionSkip() {
		Stream<String> stream=Arrays.stream(new String[]{"Paul","Erik","Joseph","Cesar","Teodomiro"});
		stream.skip(2).forEach(System.out::println);;
	}
	
	//Esta operacion no altera el flujo, recibe como para un Consumidor el cual ejecutara una accion sobre los elementos del stream*, recordar que se tiene que tomar en cuenta
	//la operacion terminal que se ejecute sobre el stream pues esta determinara como se ejecutara peek, si sobre todos los elementos o parte de ellos. [5]
	private void operacionPeek() {
		Stream<Integer> flujo=lstNumeros.stream();
	}
}
