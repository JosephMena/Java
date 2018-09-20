package org.zer0.ejemplos.api.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjemploFuture {

	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<Integer> calcularCuadrado(Integer input) {
		return executor.submit(() -> {
			Thread.sleep(1000);
			return input * input;
		});
	}
	
	public static void main(String[] args) throws Exception{
		EjemploFuture ejemplo=new EjemploFuture();
		ejemplo.testGet();
	}
	
	//Para trabajar con Future e isDone se recomienda hacerlo en un hilo aparte que verifique cada cierto tiempo el termino del procesamiento
	public void testIsDone() {
		EjemploFuture ejemplo=new EjemploFuture();
		Future<Integer> ejecucion=ejemplo.calcularCuadrado(10);
		System.out.println("Se ejecuto el cuadrado:"+ejecucion.isDone());
	}
	
	
	public void testGet() throws InterruptedException, ExecutionException {
		EjemploFuture ejemplo=new EjemploFuture();
		Future<Integer> ejecucion=ejemplo.calcularCuadrado(20);
		System.out.println("Resultado:"+ejecucion.get());
	}
	
}
