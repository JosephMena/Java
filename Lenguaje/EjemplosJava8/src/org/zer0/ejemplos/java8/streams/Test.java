package org.zer0.ejemplos.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		Test test=new Test();
		//test.operacionFilter();
		test.operacionMap();
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
	
	//La operacion .map recibe una Function, donde una funcion recibe un parametro y devuelve un valor.
	//Esta operacion se realiza sobre todos los elementos del stream.
	private void operacionMap() {
		Stream<String> flujo=Stream.of("joseph","cesar","mena","sihuacollo");
		List<String> lista=flujo.map(palabra->palabra.toUpperCase()).collect(Collectors.toList());//map(String::toUpperCase) su parametro es la intancia de String, ejemplo: joseph
		lista.forEach(System.out::println);
	}
	
	private void operacionFindFirst() {
		Stream<String> flujo=Stream.of("joseph","cesar","mena","sihuacollo");
		flujo.findFirst();
		
	}
	
}



