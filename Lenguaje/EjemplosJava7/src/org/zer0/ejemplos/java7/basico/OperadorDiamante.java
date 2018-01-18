package org.zer0.ejemplos.java7.basico;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperadorDiamante {

	
	public static void main(String[] args) {
		//Antes, en Java 6 se tenia que poner en la creacion del objeto los tipos que serian soportados por la clase, ej:
		Map<String, List<String>> lista1 = new HashMap<String, List<String>>();
		
		//Pero desde Java 7 ya no es necesario poner los tipos en la creacion, ej:
		Map<String, List<String>> lista2 = new HashMap<>();
	}
}
