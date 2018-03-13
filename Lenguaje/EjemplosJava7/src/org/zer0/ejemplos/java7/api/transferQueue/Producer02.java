package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer02 implements Runnable{

	private TransferQueue<String> transferQueue;
	  
    private String name;
  
    private Integer numberOfMessagesToProduce;
  
    public AtomicInteger numberOfProducedMessages= new AtomicInteger(); // por defecto inicia a 0.
 
    public Producer02(TransferQueue<String> transferQueue, String name, Integer numberOfMessagesToProduce) {
		super();
		this.transferQueue = transferQueue;
		this.name = name;
		this.numberOfMessagesToProduce = numberOfMessagesToProduce;
	}

	@Override
    public void run() {
        for (int i = 0; i < numberOfMessagesToProduce; i++) {
            try {
            	System.out.println("Inicio T:Tratando de ingresar un elemento");
                boolean added = transferQueue.tryTransfer("A" + i, 4000, TimeUnit.MILLISECONDS);
                System.out.println("Fin T");
                if(added){
                	numberOfProducedMessages.incrementAndGet();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("tamanio transferQueue:"+transferQueue.size());
    }
	
}
