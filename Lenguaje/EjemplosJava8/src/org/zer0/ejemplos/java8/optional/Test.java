package org.zer0.ejemplos.java8.optional;

import java.util.Optional;

public class Test {

	public static void main(String[] args) {
		Test test=new Test();
		test.creandoOptionalVacio();
		test.creandoOptionalDesdeObjeto();
		test.creandoOptionalDesdeObjeto2();
		test.metodoOrElse();
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
	
	
}
