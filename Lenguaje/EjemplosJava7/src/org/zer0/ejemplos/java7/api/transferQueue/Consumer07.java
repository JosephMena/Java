package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.TransferQueue;

public class Consumer07 implements Runnable{

	private TransferQueue<String> transferQueue;
    private String name;
    private Integer numberOfMessagesToProduce;
    
    public Consumer07(TransferQueue<String> transferQueue, String name, Integer numberOfMessagesToProduce) {
		super();
		this.transferQueue = transferQueue;
		this.name = name;
		this.numberOfMessagesToProduce=numberOfMessagesToProduce;
	}

	@Override
    public void run() {
		for (int i = 0; i < numberOfMessagesToProduce; i++) {
            try {
	        	System.out.println("Inicio Consumidor["+name+"] :Tratando de consumir un elemento");
	            String elemento=transferQueue.take();
	            System.out.println("Elemento consumido["+name+"]:"+elemento);
	            System.out.println("Fin Consumidor ["+name+"]");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
        }
        System.out.println("tamanio transferQueue ["+name+"]:"+transferQueue.size());
    }
}
