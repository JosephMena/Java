package org.zer0.ejemplos.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestOperacionesTerminales {

private static final List<Integer> lstNumeros=Arrays.asList(1,23,45,4,23,7,76,54,1,4,9,67,54,34,5,27,0,42,105);
	
	
	public static void main(String[] args) {
		TestBasic test=new TestBasic();
		//test.operacionFindFirst();
		//test.operacionFindAny();
		//test.operacionCollectToMapList();
		//test.operacionCollectToMap();
		//test.operacionCollectToMap2();
	}
	
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
