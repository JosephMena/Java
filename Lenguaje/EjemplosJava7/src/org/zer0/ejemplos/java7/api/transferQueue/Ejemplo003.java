package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Ejemplo003 {

	public static void main(String[] args) {
		TransferQueue<String> tq=new LinkedTransferQueue<>();
		Producer3 producer=new Producer3(tq, "Productor 01", 3);
		Thread hilo=new Thread(producer);
		hilo.start();
	}
	
}
