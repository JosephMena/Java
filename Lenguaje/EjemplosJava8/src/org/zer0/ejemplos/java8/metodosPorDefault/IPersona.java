package org.zer0.ejemplos.java8.metodosPorDefault;

public interface IPersona {

	public abstract void dormir();
	public abstract void leer();
	public abstract void trabajar();
	
	public default void embarazarse() {
		//Solo mujeres
	}
}
