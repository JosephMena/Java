package org.zer0.ejemplos.api.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ejemplo01 {

	
	// En este ejemplo, se crea un thread pool de 10, luego se crea una implementacion anonima de Runnable y se ejecuta en uno de los hilos de ExecutorService.
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		executorService.execute(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task");
		    }
		});
		executorService.shutdown();
	}
}
