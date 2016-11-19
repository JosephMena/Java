package org.zer0.ejemplos.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;

public class EjemplosLambda {

	
	public static void main(String[] args) {
		EjemplosLambda ejemplos=new EjemplosLambda();
		//ejemplos.ejemploForma();
		ejemplos.ejemploForEach();
		//ejemplos.llamadaEstatica_UnParametro_SinRetorno();
	}
	
	public void ejemploForma(){
		ArrayList<String> milista= new ArrayList<String>();
		milista.add("Juan");
		milista.add("Manuel");
		milista.add("Pancho");
		milista.add("Arturo");
		milista.add("Diego");
		milista.add("Titov");
		
		Collections.sort(milista,(String n,String m)->{System.out.println("aa");return 2;});
		
		for (String string : milista) {
			System.out.println("->"+string);
		}
	}
	
	public void ejemploForEach(){
		ArrayList<String> milista= new ArrayList<String>();
		milista.add("Juan");
		milista.add("Manuel");
		milista.add("Pancho");
		milista.add("Arturo");
		milista.add("Diego");
		milista.add("Titov");
		
		Collections.sort(milista,(String n,String m)->{return n.compareTo(m);});
		
		milista.forEach((String nombre)->System.out.println(nombre));
	}
	
	
	public void basico001(){
		IComparacion comparacionMayor=(numero1,numero2)->numero1>numero2;
		IComparacion comparacionMenor=(numero1,numero2)->numero1<numero2;
		
		System.out.println("Usando comparacion mayor 3,20:"+comparacionMayor.comparar(3, 20));
		System.out.println("Usando comparacion mayor 50,20:"+comparacionMayor.comparar(50, 20));
		
		System.out.println("Usando comparacion menor 3,20:"+comparacionMenor.comparar(3, 20));
		System.out.println("Usando comparacion menor 50,20:"+comparacionMenor.comparar(50, 20));
	}
	
	public void compararObjetos(){
		// No se puede realizar lambdas con definicion de objetos
		//IComparacionObjeto comparacionCadenas=(Integer a, Integer b)->a>b;
		//
	}
	
	public void compararHerencia(){
		// No se puede realizar lambdas con definicion de tipo herencia
		//IComparacionHerencia comparacion=(TrianguloEquilatero a, TrianguloEquilatero b)->a.calcularArea()>b.calcularArea();
	}
	
	public void llamadaEstatica_UnParametro_SinRetorno(){
		ILlamadaUnParametroSinRetorno llamada=Actividad::realizarActividadEstatica;
		llamada.llamar("joseph");
	}
	
	public void llamadaEstatica_DosParametro_SinRetorno(){
		ILlamadaDosParametrosSinRetorno llamada=Actividad::realizarActividadEstatica;
		llamada.llamar("joseph");
	}
	
	
}
