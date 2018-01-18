package org.zer0.ejemplos.java7.basico;

public class ThrowPreciso {

	// En la version 6 de java este codigo hubiera arrojado la un error de compilacion, indicandonos que no se esta controlando la excepcion
	// Exception
	//Apartir de Java 7, el JDK identifica las excepciones que se van a lanzar y las compara contra la cabecera del metodo throws. 
	
	
	
	public void m1(int v)  throws Ex1 , Ex2 {
        try {
            if (v < 1) {
                throw new Ex1();
            } 
            else
               if ( v > 100 ) {
                   throw new Ex2();
               }
        } 
        catch (Exception ex) {
            throw ex;   // excepción no reportada java.lang.Exception
        }
    }
	
}

class Ex1 extends Exception {private static final long serialVersionUID = 7200285423877250795L; }
class Ex2 extends Exception {private static final long serialVersionUID = -3116320937052406528L; }
