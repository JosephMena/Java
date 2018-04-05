package org.zer0.ejemplos.java8.lambda;

@FunctionalInterface
public interface IInstanciaObjetoExistente {

	
	public void llamar(String parametro);
	
	public default String   operacionDos() {
		return "";
	}
	
}
