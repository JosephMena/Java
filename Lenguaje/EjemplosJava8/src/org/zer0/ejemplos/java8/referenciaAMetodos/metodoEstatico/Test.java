package org.zer0.ejemplos.java8.referenciaAMetodos.metodoEstatico;

import org.zer0.ejemplos.java8.referenciaAMetodos.IFuncionalRetorno_2Parametros;
import org.zer0.ejemplos.java8.referenciaAMetodos.IFuncionalSinRetornoSinParametro;
import org.zer0.ejemplos.java8.referenciaAMetodos.IFuncionalSinRetorno_1Parametro;
import org.zer0.ejemplos.java8.referenciaAMetodos.IFuncionalSinRetorno_2Parametros;

public class Test {

	
	public static void main(String[] args) {
		Test t=new Test();
		//t.pruebaMetodoEstatico1();
		//t.pruebaMetodoEstatico2();
		//t.pruebaMetodoEstatico3();
		t.pruebaMetodoEstatico4();
	}
	
	private void pruebaMetodoEstatico1(){
		IFuncionalSinRetornoSinParametro operacion=ClasePruebas::metodoSinRetornoySinParametros;
		operacion.metodo();
	}
	
	private void pruebaMetodoEstatico2() {
		IFuncionalSinRetorno_1Parametro operacion=ClasePruebas::metodoSinRetorno_1Parametro;
		operacion.metodo("Joseph");
	}
	
	private void pruebaMetodoEstatico3() {
		IFuncionalSinRetorno_2Parametros operacion=ClasePruebas::metodoSinRetorno_2Parametros;
		operacion.metodo("Buenas tardes", "Joseph");
	}
	
	private void pruebaMetodoEstatico4() {
		IFuncionalRetorno_2Parametros operacion=ClasePruebas::metodoRetorno_2Parametros;
		System.out.println(operacion.metodo("Que tal", "Joseph"));
	}
}
