package org.zer0.ejemplo.concurrencia.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAtomic {
	
	// Atomic es parte del paquete java.util.concurrent.atomic
	// AtomicInteger fue añadido desde la version 5 de Java.
	// 
	
	AtomicInteger atomicInteger=new AtomicInteger(2);
	
	public void operacion() {
		int numero=atomicInteger.get();
		System.out.println("numero:"+numero);
		atomicInteger.set(50);
		System.out.println("numero cambiado:"+atomicInteger.get());
	}
	
	public void compareAndSet() {
		atomicInteger.set(123);
		int valorEsperado = 123;
		int valorNuevo = 222;
		atomicInteger.compareAndSet(valorEsperado, valorNuevo);
		System.out.println("valor numero:"+atomicInteger.get());
	}
	
	public void agregar() {// si quieres restar solo agregar un numero negativo.
		atomicInteger.set(1);
		System.out.println("add y get:"+atomicInteger.addAndGet(200));
	}
	
	public void incrementarYDecrementar() {// Solo agregar o quita 1 como valor.
		atomicInteger.incrementAndGet();
		atomicInteger.decrementAndGet();
	}
	
	public static void main(String[] args) {
		EjemploAtomic ejemplo=new EjemploAtomic();
		ejemplo.operacion();
		
		ejemplo.compareAndSet();
	}

}
