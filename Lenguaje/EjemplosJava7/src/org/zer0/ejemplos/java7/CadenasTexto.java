package org.zer0.ejemplos.java7;

public class CadenasTexto {

	public static void main(String[] args) {
		CadenasTexto cadenas=new CadenasTexto();
		cadenas._switch();
	}

	public void _switch() {
		String texto = "elegir1";
		switch (texto) {
			case "elegir2":
				System.out.println("eligiendo 2");
				break;
			case "elegir1":
				System.out.println("eligiendo 1");
				break;
			case "elegir3":
				System.out.println("eligiendo 3");
				break;
		}
	}

}
