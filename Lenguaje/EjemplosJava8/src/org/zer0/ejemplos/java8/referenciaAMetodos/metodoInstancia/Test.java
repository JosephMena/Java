package org.zer0.ejemplos.java8.referenciaAMetodos.metodoInstancia;

import org.zer0.ejemplos.java8.referenciaAMetodos.IFuncionalRetorno_2Parametros;
import org.zer0.ejemplos.java8.referenciaAMetodos.IFuncionalSinRetornoSinParametro;
import org.zer0.ejemplos.java8.referenciaAMetodos.IFuncionalSinRetorno_1Parametro;

public class Test {

	public static void main(String[] args) {
		Test t=new Test();
		//t.metodoSinRetornoySinParametros();
		t.metoroRetorno_2Parametros();
	}
	
	private void metodoSinRetornoySinParametros() {
		ClasePruebas instancia=new ClasePruebas();
		IFuncionalSinRetornoSinParametro operacion=instancia::metodoSinRetornoSinParametros;
		operacion.metodo();
	}
	
	private void metodoSinRetorno_1Parametro() {
		ClasePruebas instancia=new ClasePruebas();
		IFuncionalSinRetorno_1Parametro operacion=instancia::metodoSinRetorno_1Parametro;
		operacion.metodo("Joseph");
	}
	
	private void metoroRetorno_2Parametros() {
		ClasePruebas instancia=new ClasePruebas();
		IFuncionalRetorno_2Parametros operacion=instancia::metodoRetorno_2Parametro;
		System.out.println(operacion.metodo("Saludos ", "Joseph"));
	}
	
}
