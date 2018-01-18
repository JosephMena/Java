package org.zer0.ejemplos.java7.phasers;

import java.util.concurrent.Phaser;

public class Procesar {

	// Phaser:
	// Phaser es una caracteristica util cuando se quiere tener tareas(Threads) que trabajen en Bloques(Phases).
	// En Phaser, las tareas se detienen en una barrera imaginaria esperando que se cumpla cierta condicion para seguir con su ejecucion.
	// Por ejemplo, se puede tener una serie de fases que solo use una instancia de Phaser:
	// Fase 1: Compuesta por 3 tareas (hilos)
	// Fase 2: Compuesta por 4 tareas. 
	// Condicion: la condicion a cumplir para que la fase se sigua es: Cuando el numero de tareas arrived (arriveAndAwaitAdvance) sea igual   
	// al numero tareas registradas (register), la ejecucion del programa continua, cuando se da esta situacion el phase number 
	// se incrementara: getPhase() 
	// Para que se pueda controlar el trabajo mediante fases se recomienda la siguiente practica:
	// En el hilo(main o controlador) que controla las tareas, instanciar el Phaser con el parametro "1" en el constructor, 
	// esto lo que hace es llamar al metodo register y registrar el hilo actual(el main o el del controlador de tareas), esto añadiria 
	// 1 mas al contador del phaser.
	// Entonces para que se cumpla la condicion de nro de arrive=nro de register, se debe invocar en el hilo principal(main) al arriveAndAwaitAdvance
	// con ello la ejecucion de las tareas continuaria.
	
	public static void main(String[] args) {
		Phaser phaser=new Phaser(1);
		new Worker(phaser, "Hilo 1");
		new Worker(phaser, "Hilo 2");
		new Worker(phaser, "Hilo 3");
		phaser.arriveAndAwaitAdvance();
	}
	
}
