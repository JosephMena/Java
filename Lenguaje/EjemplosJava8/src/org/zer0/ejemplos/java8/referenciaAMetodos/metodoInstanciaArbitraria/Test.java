package org.zer0.ejemplos.java8.referenciaAMetodos.metodoInstanciaArbitraria;


public class Test {
	
	public static void main(String[] args) {
		Test t=new Test();
		//t.metodoSinRetornoySinParametros();
		t.metodoSinRetorno_1Parametro();
	}
	
	//Este caso no se puede dar
	private void metodoSinRetornoySinParametros() {
		//IFuncionalSinRetornoSinParametro operacion=ClasePruebas::metodoSinRetornoSinParametros;
		//operacion.metodo();
	}
	
	//Como se puede apreciar en este ejemplo, le metodo por referencia con clase arbitraria
	//solo se puede dar cuando el 1er parametro del metodo es del mismo tipo que la Clase.
	//Y se toma como primer parametro la instancia actual de la clase.
	private void metodoSinRetorno_1Parametro() {
		IFuncionalSinRetorno_1Parametro operacion=ClasePruebas::metodoSinRetornoSinParametros;
		ClasePruebas instancia=new ClasePruebas();
		operacion.metodo(instancia);
	}
	
	
	private void metoroSinRetorno_2Parametros() {
		ClasePruebas instancia=new ClasePruebas();
		IFuncionalSinRetorno_2Parametros operacion=ClasePruebas::metodoSinRetorno_1Parametro;
		operacion.metodo(instancia, "Joseph");
	}
	
}
