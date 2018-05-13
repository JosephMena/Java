package org.zer0.ejemplos.java8.metodosPorDefault;

public class Mujer implements IPersona{

	@Override
	public void dormir() {
		System.out.println("usar toda la cama");
	}

	@Override
	public void leer() {
		System.out.println("quien sabe");
	}

	@Override
	public void trabajar() {
		System.out.println("depende de sus gustos");
	}

	@Override
	public void embarazarse() {
		System.out.println("9 meses de sufrimiento pero con amor.");
	}

}
