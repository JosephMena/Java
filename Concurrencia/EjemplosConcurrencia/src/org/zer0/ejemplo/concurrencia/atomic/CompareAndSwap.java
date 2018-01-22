package org.zer0.ejemplo.concurrencia.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompareAndSwap {

	// http://tutorials.jenkov.com/java-concurrency/compare-and-swap.html
	// Compare and Swap: Compara e Intercambia, esta tecnica consiste en comparar el valor actual de una variable contra un valor esperado,
	// Si el valor actual es igual al valor esperado entonces el valor de la variable sera cambiado hacia otro valor N.
	// Pero que chiste tiene esto? pues veamos un ejemplo:
	
	private boolean locked = false;

    public boolean lock() {
        if(!locked) {
            locked = true;
            return true;
        }
        return false;
    }
    
    // Este codigo, tal como esta, sufre de problemas de sincronizacion, es decir si vienen 2 o mas Hilos al mismo instante, estos dos hilos
    // pueden tener el mismo valor de la variable en un determinado momento, lo cual no deberia ser asi.
    // Para solventar este problema se usa el codigo synchronized en el metodo,asi:
    // 
    // public synchronized boolean lock() {
    // ...
    //
    // Con ello el metodo ya no permite que mas de 1 hilo pueda cambiar u observar el valor de la variable, es decir la operacion se vuelve
    // Atomica.
    // Es asi como el metodo lock se vuelve un ejemplo de Compare and Swap.
    // Modernos CPUs tiene un soporte nativo del algoritmo compare and swap, Desde Java 5 se puede tener acceso a estas funciones del CPU
    // utilizando las clases Atomic del paquete java.util.concurrent.atomic. 
    // En el siguiente ejemplo se aprecia el uso de Atomic:
    
    private AtomicBoolean lockedAtomic = new AtomicBoolean(false);

    public boolean lockAtomic() {
        return lockedAtomic.compareAndSet(false, true);
    }
}
