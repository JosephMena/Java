package org.zer0.ejemplos.java8.streams.operaciones;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.zer0.ejemplos.java8.streams.TestBasic;

public class TestMatch {

	private static final List<Integer> lstNumeros=Arrays.asList(1,23,45,4,23,7,76,54,1,4,9,67,54,34,5,27,0,42,105);
	
	//Esta operacion se realiza contra todos los elementos del stream y debe cumplir para todos ellos el Predicate, recien cuando todos cumplen se retorna true
	private void operacionAllMatch() {
		Stream<Integer> stream=lstNumeros.stream();
		boolean sonMayoresQue100=stream.allMatch(n->n>100);
		System.out.println("sonMayoresQue100:"+sonMayoresQue100);
	}
	
	//Esta operacion retorna true si alguno de los elementos del stream cumple con el Predicate
	private void operacionAnyMatch() {
		Stream<String> flujo=Stream.of("Joseph","Mena","Sihuacollo","peruano");
		boolean contienePeru=flujo.anyMatch(param->{return param.contains("peru");});
		System.out.println(contienePeru);
	}
	
	//Esta operacion retorna true  si ninguno de los elementos del stream cumple con el Predicate
	private void operacionNoneMatch() {
		Stream<String> flujo=Stream.of("Joseph","Mena","Sihuacollo","Cesar");
		boolean contieneZ=flujo.noneMatch(nombre->{return nombre.contains("z");});
		System.out.println("Ninguno contiene z? "+contieneZ);
	}
	
	public static void main(String[] args) {
		TestBasic test=new TestBasic();
		//test.operacionAllMatch();
		//test.operacionAnyMatch();
		//test.operacionNoneMatch();
	}
}
