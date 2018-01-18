package org.zer0.ejemplos.java7.trywithresources;

public class TryWithResourcesV2 {

	// Como se puede apreciar en este ejemplo, el metodo transferir lanza una excepcion, pero antes de que se controle esta excepcion
	// se ejecuta el metodo close, el cual ademas tambien lanza otra excepcion, Java 7 para manejar este caso introdujo el concepto de
	// Suppresed Exceptions, para el caso la excepcion del metodo close sera "suprimida", por decirlo de alguna forma: no sera lanzada,
	// Es asi que la unica excepcion que se controlara sera la excepcion lanzada por el metodo transferir o interpretado de otra forma, 
	// cualquier excepcion lanzada en el body del try.
	// Para acceder a la excepcion lanzada por el close se puede invocar al metodo getSuppressed() (nuevo en java 7), asi tambien lo podemos
	// usar para detectar que se lanzo una excepcion suppresed.
	
	public static void main(String[] args) throws Exception {

		try ( Recurso2 recurso = new Recurso2() ) {
			recurso.transferir(); 
		}
		catch (Exception e) { 
			System.out.println("Hubo un problema, " + e.getClass());
			int c = e.getSuppressed().length;
			for (int i=0; i<c; i++){
				System.out.println("Suppressed: " + e.getSuppressed()[i]);
			}
		}
		finally {
			System.out.println("Finalizando bloque try catch.");
		}
	}
}

class Transferencia2Exception extends Exception {private static final long serialVersionUID = -3902320297095839085L;}
class CierreException extends Exception {private static final long serialVersionUID = -3902320297095839089L;}

class Recurso2 implements AutoCloseable {

	public Recurso2() throws Exception {
		System.out.println("Recurso es instanciado.");
	}
	public void transferir() throws Exception {
		System.out.println("Transferencia de bytes.");
		throw new TransferenciaException();
	}

	public void close() throws Exception {
		System.out.println("Cierre del recurso.");
		throw new CierreException();
	}
}
