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

public class Test {
	
	private static final List<Integer> lstNumeros=Arrays.asList(1,23,45,4,23,7,76,54,1,4,9,67,54,34,5,27,0,42,105);
	
	
	public static void main(String[] args) {
		Test test=new Test();
		//test.operacionFilter();
		//test.operacionMap();
		//test.operacionMap2();
		//test.operacionFindFirst();
		//test.operacionFindAny();
		//test.intStream();
		//test.operacionSorted2();
		//test.operacionCollectToMapList();
		//test.operacionCollectToMap();
		//test.operacionCollectToMap2();
		//test.operacionSkip();
		//test.operacionAllMatch();
		//test.operacionAnyMatch();
		//test.operacionNoneMatch();
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
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------Terminales--------------------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Retorna el primer elemento del stream
	private void operacionFindFirst() {
		Stream<String> flujo=Stream.of("joseph","cesar","mena","sihuacollo");
		Optional<String> elemento=flujo.findFirst();
		System.out.println(elemento.get());
	}
	
	//Esta operacion retorna solo 1 elememento envuelto en un Optional, en teoria deberia devolver cualquier elemento pero en las pruebas siempre retorna el primero.
	private void operacionFindAny() {
		Stream<String> flujo=Stream.of("joseph","cesar","mena","sihuacollo");
		flujo.findAny().ifPresent(System.out::println);		
	}
	
	private void operacionCollectToList() {
		Stream<String> flujo=Stream.of("Joseph","Mena","Sihuacollo","Paul");
		List<String> lista=flujo.collect(Collectors.toList());
	}
	
	private void operacionCollectToMapList() {
		Stream<String> flujo=Stream.of("Joseph","Mena","Sihuacollo","Jorge","Martin");
		Map<String,List<String>> mapa=flujo.collect(
										Collectors.groupingBy(
												nombre->String.valueOf(nombre.charAt(0))
												)
									);
		
		mapa.forEach((k,v)->{
			System.out.println("___Nombres que empiezan con:"+k);
			v.forEach(System.out::println);
		});
	}
	
	
	private void operacionCollectJoining() {
		Stream<String> flujo=Stream.of("Joseph","Mena","Sihuacollo","Jorge","Martin");
		String cadena=flujo.collect(Collectors.joining(","));
		System.out.println(cadena);
	}
	
	//Si se lanza este metodo, se arrojara una excepcion,ello se debe a que el toMap de dos parametros
	//lanza una excepcion cuando el key se encuentra mas de 1 vez:ej (P)aul y (P)edro
	//en su lugar usar el toMap de 3 parametros
	private void operacionCollectToMap() {
		Stream<String> flujo=Stream.of("Joseph","Pedro","Sihuacollo","Martin","Paul");
		Map<String,String> mapa=flujo.collect(Collectors.toMap(
					nombre->String.valueOf(nombre.charAt(0)),
					nombre->nombre
				));
		mapa.forEach((k,v)->{
			System.out.println("___Nombres que empiezan con:"+k+" -v:"+v);
		});
	}
	
	// Como se puede apreciar a diferencia del toMap con 2 parametros, en este caso se le pasa una funcion
	//lambda que sirve como merge.
	private void operacionCollectToMap2() {
		Stream<String> flujo=Stream.of("Joseph","Pedro","Sihuacollo","Martin","Paul","Pantro");
		Map<String,String> mapa=flujo.collect(Collectors.toMap(
					nombre->String.valueOf(nombre.charAt(0)),
					nombre->nombre,
					(a,b)->a+","+b
				));
		mapa.forEach((k,v)->{
			System.out.println("___Nombres que empiezan con:"+k+" -v:"+v);
		});
	}
	

}



