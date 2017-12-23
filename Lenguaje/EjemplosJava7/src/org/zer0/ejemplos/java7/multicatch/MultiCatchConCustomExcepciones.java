package org.zer0.ejemplos.java7.multicatch;

public class MultiCatchConCustomExcepciones {

	
	public static void main(String[] args) {
		//Como se puede ver en el codigo la variable ex sera o la excepcion ExcepcionTarea1 o la ExcepcionTarea2 dependiendo cual se lanze
		//los metodo a los cuales se tiene acceso desde la variable ex son los metodos de la clase Throwable, por mas que se ponga codigo
		//customizado en alguna de las excepciones esta no sera accesible desde el objeto ex.
		try {
			Tarea1 t1=new Tarea1();
			t1.metodo();
			Tarea2 t2=new Tarea2();
			t2.metodo();
		} catch(ExcepcionTarea1 | ExcepcionTarea2 ex ) {
			System.out.println(ex.getMessage());
		}
	}
	
}
