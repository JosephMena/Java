package org.zer0.ejemplos.java7.trywithresources;

public class TryWithResourcesV1 {

	// Si se corre el programa podemos apreciar que el metodo transferir es invocado, pero este lanza una Excepcion.
	// Esta excepcion lanzada no es manejada de inmediato si no que antes se llama al metodo close() del recurso ejecutado.
	// Luego de que es invocado el metodo close() recien se maneja la excepcion generada.
	// Como acto final se invoca al bloque finally.
	
	// Pero, que pasa si el metodo close hubiera lanzado una excepcion?, y ademas el metodo transferir tambien hubiera lanzado una excepcion.
	// En ese caso existirian dos excepciones difentes por manejar, y esto ocurriria antes de que se hubiera tenido la oportunidad de manejar
	// alguna de ellas. La clave para este escenario son las supressed exception, la cual se vera en el ejemplo V2.
	
	
	public static void main(String[] args) throws Exception {

		try ( Recurso recurso = new Recurso() ) {
			recurso.transferir(); 
		}
		catch (Exception e) { 
			System.out.println("Hubo un problema, " + e.getClass());
		}
		finally {
			System.out.println("Finalizando bloque try catch.");
		}
	}
}

class TransferenciaException extends Exception {private static final long serialVersionUID = -3902320297095839080L;}

class Recurso implements AutoCloseable {

	public Recurso() throws Exception {
		System.out.println("Recurso es instanciado.");
	}
	public void transferir() throws Exception {
		System.out.println("Transferencia de bytes.");
		throw new TransferenciaException();
	}

	public void close() throws Exception {
		System.out.println("Cierre del recurso.");
	}
}
