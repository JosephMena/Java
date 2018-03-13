package org.zer0.ejemplos.java7.api.transferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Ejemplo005 {

	public static void main(String[] args) {
		try {
			TransferQueue<String> tq=new LinkedTransferQueue<>();
			tq.put("Hola");
			tq.put("Mundo");
			Consumer05 consumer=new Consumer05(tq, "Consumidor 04");
			
			Thread hiloC=new Thread(consumer);
			hiloC.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
