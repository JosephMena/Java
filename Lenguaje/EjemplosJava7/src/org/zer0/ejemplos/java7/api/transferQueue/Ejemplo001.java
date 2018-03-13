package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Ejemplo001 {

	public static void main(String[] args) {
		TransferQueue<String> tq=new LinkedTransferQueue<>();
		Producer02 producer=new Producer02(tq, "Productor 01", 3);
		Thread hilo=new Thread(producer);
		hilo.start();
	}
	
}
