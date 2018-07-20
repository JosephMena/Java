package org.zer0.ejemplos.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.zer0.ejemplo.java8.util.Persona;

public class Test {
	
	public static void main(String[] args) {
		Test test=new Test();
		//test.operacionFilter();
		//test.operacionMap();
		//test.operacionMap2();
		//test.operacionFindFirst();
		//test.operacionAnyMatch();
		//test.intStream();
		test.operacionSorted();
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
	
	private void operacionFindFirst() {
		Stream<String> flujo=Stream.of("joseph","cesar","mena","sihuacollo");
		Optional<String> elemento=flujo.findFirst();
		System.out.println(elemento.get());
		
	}
	
	private void operacionAnyMatch() {
		Stream<String> flujo=Stream.of("Joseph","Mena","Sihuacollo","peruano");
		boolean contienePeru=flujo.anyMatch(param->{return param.contains("peru");});
		System.out.println(contienePeru);
	}
	
	private void intStream() {
		IntStream stream=Arrays.stream(new int[] {1,2,4,6,2});
		OptionalDouble op=stream.average();
		System.out.println(op.getAsDouble());
	}
	
	private void operacionSorted() {
		Stream<String> array=Arrays.stream(new String[]{"Paul","Erik","Joseph","Cesar","Teodomiro"});
		array.sorted().forEach(System.out::println);
	}
	
	private void operacionSorted2() {
		Stream<String> array=Arrays.stream(new String[]{"Paul","Erik","Joseph","Cesar","Teodomiro"});
		array.sorted().forEach(System.out::println);
		
	}
}



