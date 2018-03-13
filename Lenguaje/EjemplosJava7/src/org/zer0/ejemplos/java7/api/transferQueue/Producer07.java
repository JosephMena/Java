package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer07 implements Runnable{

	private TransferQueue<String> transferQueue;
	  
    private String name;
 
    public Producer07(TransferQueue<String> transferQueue, String name) {
		super();
		this.transferQueue = transferQueue;
		this.name = name;
	}

	@Override
    public void run() {
		int i=0;
        while(true) {
            try {
            	System.out.println("Inicio Productor:Tratando de ingresar un elemento");
                transferQueue.transfer("A" + i++);
                System.out.println("Fin Productor");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
	
}
