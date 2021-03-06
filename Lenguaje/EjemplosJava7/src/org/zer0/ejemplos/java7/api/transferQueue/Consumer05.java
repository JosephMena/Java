package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.TransferQueue;

public class Consumer05 implements Runnable{

	private TransferQueue<String> transferQueue;
    private String name;
    
    public Consumer05(TransferQueue<String> transferQueue, String name) {
		super();
		this.transferQueue = transferQueue;
		this.name = name;
	}

	@Override
    public void run() {
		while(transferQueue.size()>0) {
			try {
	        	System.out.println("Inicio Consumidor:Tratando de consumir un elemento");
	            String elemento=transferQueue.take();
	            System.out.println("Elemento consumido:"+elemento);
	            System.out.println("Fin Consumidor");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
    }
}
