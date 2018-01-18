package org.zer0.ejemplos.java7.phasers;

import java.util.concurrent.Phaser;

public class Worker extends Thread{

	private Phaser phaser;
	
	public Worker(Phaser phaser,String name) {
		this.setName(name);
		this.phaser=phaser;
		phaser.register();
		this.start();
	}
	
	@Override
	public void run() {
		for(int i=0;i<=3;i++) {
			System.out.println(getName()+" haciendo trabajo de para orden:"+i);
			if(i==3) {
				System.out.println(getName()+" antes del Deregister");
				phaser.arriveAndDeregister();
				System.out.println(getName()+" despues del Deregister");
			}else{
				System.out.println(getName()+" antes del awaitAdvance");
				phaser.arriveAndAwaitAdvance();
				System.out.println(getName()+" despues del awaitAdvance");
			}
			try {
				Thread.sleep(5000);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
