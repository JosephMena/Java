package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Ejemplo006 {

	public static void main(String[] args) {
		TransferQueue<String> tq=new LinkedTransferQueue<>();
		Producer06 producer=new Producer06(tq, "Productor 06", 3);
		Consumer06 consumer=new Consumer06(tq, "Consumidor 06", 3);
		Thread hiloP=new Thread(producer);
		hiloP.start();
		
		Thread hiloC=new Thread(consumer);
		hiloC.start();
	}
	
}
