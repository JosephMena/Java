package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Ejemplo007 {

	public static void main(String[] args) {
		TransferQueue<String> tq=new LinkedTransferQueue<>();
		Producer07 producer=new Producer07(tq, "Productor 06");
		Consumer07 consumer1=new Consumer07(tq, "Consumidor 07_1", 5);
		Consumer07 consumer2=new Consumer07(tq, "Consumidor 07_2", 5);
		Thread hiloP=new Thread(producer);
		hiloP.start();
		
		Thread hiloC1=new Thread(consumer1);
		hiloC1.start();
		
		Thread hiloC2=new Thread(consumer2);
		hiloC2.start();
	}
	
}
