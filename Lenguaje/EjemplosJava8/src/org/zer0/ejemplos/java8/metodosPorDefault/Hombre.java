package org.zer0.ejemplos.java8.metodosPorDefault;

public class Hombre implements IPersona{

	@Override
	public void dormir() {
		System.out.println("arrimado");
	}

	@Override
	public void leer() {
		System.out.println("apasionadamente");
	}

	@Override
	public void trabajar() {
		System.out.println("se parte el lomo");
	}
}
