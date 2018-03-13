package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer01 implements Runnable{

	private TransferQueue<String> transferQueue;
	  
    private String name;
  
    private Integer numberOfMessagesToProduce;
  
    public Producer01(TransferQueue<String> transferQueue, String name, Integer numberOfMessagesToProduce) {
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
                transferQueue.transfer("A" + i);
                System.out.println("Fin T");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
}
