package org.zer0.ejemplos.java8.referenciaAMetodos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Test {

	
	public static void main(String[] args) {
		Test test=new Test();
		//test.metodoEstatico();
		//test.metodoInstancia();
		test.metodoInstanciaArbitrariaDeUnTipo1();
	}
	
	public void metodoEstatico() {
		ISaludo saludo=ClaseMetodoEstatico::saludar;
		saludo.saludar("hack the workd!");
	}
	
	public void metodoInstancia() {
		ClaseMetodoNormal clase=new ClaseMetodoNormal();
		ISaludo saludo=clase::saludar;
		saludo.saludar("ey soy una instancia!");
	}
	
	public void metodoInstanciaArbitrariaDeUnTipo1() {
		Persona[] personas= {new Persona("Joseph"),new Persona("Paul"),new Persona("Antonia"),new Persona("Cesar")};
		List<Persona> lstPersonas=Arrays.asList(personas);
		lstPersonas.forEach(Persona::imprimirMiNombre);
		//forEach recibe un Consumidor de solo un parametro, cuya metodo funcional es:
		//void accept(T t)
		//Es decir su firma lamba es: (T t)->{}
		//Donde lo que esta entre {} determina que accion se realizara.
		//Pero cuando hacemos metodo de instancia por referencia arbitraria
		//lo que va dentro del forEarch es la referencia a un metodo, lo que hace java internamente 
		//es algo confuso pero se puede determinar. Por ejemplo en este caso impimirMiNombre no tiene 
		//parametros, esta es la parte confusa.
		//Pero el no tener parametros es lo que hace posible este caso ( si no pediria que sea estatico 
		//como el Persona::imprimirMiNombre3 o no se podria ejecutar como el imprimirMiNombre2) 
		//En este caso imprimirMiNombre es un metodo de instancia, y opera sobre cada instancia de la 
		//lista lstPersonas.
		//Tratar de relacionar esto con como funciona lamba es complicado.
	}
	
	public void metodoInstanciaArbitrariaDeUnTipo2() {
		//Se usa en conjunto con lambda
		//Por ejemplo:
		String[] lista= {"cielo","agua","papa","carpintero","taza","ciencia","dedo","mamut","telefono","computadora","maniqui","zapato"};
		List<String> palabras=Arrays.asList(lista);
		palabras.forEach(String::length);// 
		//forEach recibe un consumidor de solo un parametro, es decir puede ser de la siguiente forma: (palabra)->{}
		//Pero tambien puede recibir un metodo referencia, en este caso, por ejemplo recibe el metodo length, pero el metodo length se opera sobre una instancia de String.
		//la firma del metodo length es: public int length() , es decir no recibe parametros, es operado sobre la instanacia del objeto.
		
		//Otro caso de referencia arbitraria seria
		Arrays.sort(lista, String::compareToIgnoreCase);
		//Donde el segundo parametro es un Comparator, en este caso el metodo compareToIgnoreCase es un metodo de instancia, y recibe como parametro otro String para compararse 
		//sobre la instancia del mismo.
		//definicion del Comparator: int compare(T o1, T o2);
		//definicion del compareToIgnoreCase: public int compareToIgnoreCase(String str)
		//La definicion compareToIgnoreCase esta muy cerca de Comparator pero el primero parametro es una instancia y el segundo parametro otra instancia. 
	}
	
	public void metodoNew() {
		Supplier<Persona> usu= Persona::new;
		//Construye un objeto de tipo usuario que es devuelto por m�todo get();
		Persona usuario=usu.get();
	}
}

