package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Ejemplo002 {

	public static void main(String[] args) {
		TransferQueue<String> tq=new LinkedTransferQueue<>();
		Producer1 producer=new Producer1(tq, "Productor 01", 3);
		Thread hilo=new Thread(producer);
		hilo.start();
	}
	
}
