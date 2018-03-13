package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Ejemplo004 {

	public static void main(String[] args) {
		TransferQueue<String> tq=new LinkedTransferQueue<>();
		Consumer04 consumer=new Consumer04(tq, "Consumidor 04");
		
		Thread hiloC=new Thread(consumer);
		hiloC.start();
	}
	
}
