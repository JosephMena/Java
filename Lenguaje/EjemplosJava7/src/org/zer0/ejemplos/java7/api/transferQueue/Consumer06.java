package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.TransferQueue;

public class Consumer06 implements Runnable{

	private TransferQueue<String> transferQueue;
    private String name;
    private Integer numberOfMessagesToProduce;
    
    public Consumer06(TransferQueue<String> transferQueue, String name, Integer numberOfMessagesToProduce) {
		super();
		this.transferQueue = transferQueue;
		this.name = name;
		this.numberOfMessagesToProduce=numberOfMessagesToProduce;
	}

	@Override
    public void run() {
		for (int i = 0; i < numberOfMessagesToProduce; i++) {
            try {
	        	System.out.println("Inicio Consumidor:Tratando de consumir un elemento");
	            String elemento=transferQueue.take();
	            System.out.println("Elemento consumido:"+elemento);
	            System.out.println("Fin Consumidor");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
        }
        System.out.println("tamanio transferQueue:"+transferQueue.size());
    }
}
