package org.zer0.ejemplos.api.executorService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Ejemplo03 {

	public static void main(String[] args) {
		Ejemplo03 ejemplo=new Ejemplo03();
		ejemplo.metodoInvokeAny();
	}

	//En ese caso se ejecuta un Runnable, ademas para este caso no existe forma de obtener un resultado de la llamada de la operacion.
	private void metodoExecute() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Runnable runnableTask = () -> {
			try {
				System.out.println("metodoExecute");
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		executorService.execute(runnableTask);
		executorService.shutdown();
	}

	//En este caso tambien se ejecuta un Runnable pero si devuelve un Future por medio del cual se puede obtener el resultado.
	private void metodoSubmitRunnable() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Runnable runnableTask = () -> {
			try {
				System.out.println("metodoSubmitRunnable");
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Future future=executorService.submit(runnableTask);
		
	}

	
	private void metodoSubmitCallable() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Callable<String> callableTask=new Callable<String>() {

			@Override
			public String call() throws Exception {
				TimeUnit.MILLISECONDS.sleep(300);
				return "hola!!! soy callable!";
			}
		};
		
		Future<String> resultado=executorService.submit(callableTask);
		try {
			System.out.println("resultado:"+resultado.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	//Se tratan de ejecutar todos pero solo hasta el momento en que uno de ellos termina, en el momento que uno de ellos termina los demas automaticamente se terminan
	//luego se devuelve el resultado del callable terminado. Tambien el proceso puede ser abortado si es que alguno de ellos genero alguna excepcion.
	private void metodoInvokeAny() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Callable<String> callableTask1=()->{
			System.out.println("Task callable 1");
			return "Task callable 1";
		};
		
		Callable<String> callableTask2=()->{
			System.out.println("Task callable 2");
			return "Task callable 2";
		};
		
		Callable<String> callableTask3=()->{
			System.out.println("Task callable 3");
			return "Task callable 3";
		};
		
		Collection<Callable<String>> lstCallableTasks=new ArrayList<>();
		lstCallableTasks.add(callableTask3);
		lstCallableTasks.add(callableTask2);
		lstCallableTasks.add(callableTask1);
		
		try {
			String tareaEjecutada=executorService.invokeAny(lstCallableTasks);
			System.out.println("Se ejecuto la tarea:"+tareaEjecutada);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	//Se ejecutan todos y se devuelven los resultados en un Future, tener en cuenta que si se cae por una excepcion
	private void metodoInvokeAll() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Callable<String> callableTask=()->{
			TimeUnit.MILLISECONDS.sleep(300);
			return "Task callable";
		};
		
		Collection<Callable<String>> lstCallableTasks=new ArrayList<>();
		lstCallableTasks.add(callableTask);
		lstCallableTasks.add(callableTask);
		lstCallableTasks.add(callableTask);
		
		try {
			List<Future<String>> futures=executorService.invokeAll(lstCallableTasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}	
