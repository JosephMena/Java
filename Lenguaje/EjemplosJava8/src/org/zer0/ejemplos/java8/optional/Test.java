package org.zer0.ejemplos.java8.optional;

import java.util.Optional;

import org.zer0.ejemplo.java8.util.Persona;

public class Test {

	public static void main(String[] args) {
		Test test=new Test();
		test.creandoOptionalVacio();
		test.creandoOptionalDesdeObjeto();
		test.creandoOptionalDesdeObjeto2();
		test.metodoOrElse();
		test.metodoFilter();
		test.metodoMap();
	}
	
	public void creandoOptionalVacio() {
		Optional<String> vacio=Optional.empty();
		System.out.println("is present?:"+vacio.isPresent());
	}
	
	//En este caso el metodo of debe recibir un dato a excepcion de null, si no arrojara un NullPointerException
	public void creandoOptionalDesdeObjeto() {
		String dato="mi dato";
		Optional<String> op=Optional.of(dato);
		System.out.println("->"+op.get());
	}
	
	//En caso llege a ocurrir que el valor que le pasemos al Optional pueda ser null se puede usar ofNullable
	//Y tenemos que controlar el acceso a get mediante isPresent ya que get arrojara una excepcion en caso sea null
	public void creandoOptionalDesdeObjeto2() {
		String dato=null;
		Optional<String> op=Optional.ofNullable(dato);
		System.out.println("isPresent()->"+op.isPresent());
		//System.out.println("get()->"+op.get());
	}
	
	//El metodo orElse permite dar un valor por defecto si es que el valor es nulo o vacio
	public void metodoOrElse() {
		System.out.println("orElse valor 1:"+Optional.ofNullable(null).orElse("joseph por defecto!"));
		System.out.println("orElse valor 2:"+Optional.ofNullable("IPzer0").orElse("joseph por defecto!"));
	}
	
	//El metodo filter se puede tomar para una evaluacion condicional if ya que el filter recibe un Predicate.
	public void metodoFilter() {
		Optional<Integer> anioPruebaOptional=Optional.of(1984);
		if(anioPruebaOptional.filter(anio->anio>1980).isPresent()) {
			System.out.println("mas joven que yo");
		}
	}
	
	//Ademas sobre un Optional tambien se pueden aplicar otras operaciones como map, el cual develve un Optional
	//En este caso el map se usa para extraer un valor
	public void metodoMap() {
		Optional<Persona> op=Optional.ofNullable(new Persona("mena", 51));
		System.out.println(op.map(Persona::getNombre).filter((nombre)->{return nombre.equals("mena");}).isPresent());
	}
	
	
	public void metodoIfPresent() {
		Optional<Persona> op=Optional.ofNullable(null);
	}
	
}
