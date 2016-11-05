package org.zer0.ejemplos.java7;

import java.io.BufferedReader;
import java.io.FileReader;

//try-with-resources o ARM (Automatic Resource Management)
//Valido para ficheros, sockets, streams o conexiones a base de datos
//Cuando se usa esta nueva funcionalidad el mismo java se encarga de cerrar los recursos.
//El cierre de recursos se da de manera inversa a como han sido declarados.
//Para permitir el uso de ARM se ha creado la interfaz java.lang.AutoCloseable
//Esta interfaz solo tiene el metodo close()
//Este interfaz es padre del interfaz java.io.Closeable del que heredan todos los recursos de entrada y salida.
//El método close() es que se invoca para el cierra todos los recursos incluidos en la cabecera de la sentencia try, 
//llamándose automáticamente una vez finalizado el bloque try o después de producirse una excepción.
public class Recursos {

	public static void main(String[] args) {
		Recursos recursos=new Recursos();
		recursos.pruebaRecursos();
	}
	
	public void pruebaRecursos(){
		try(
				FileReader reader=new FileReader("texto.txt");
				BufferedReader buffer=new BufferedReader(reader);
			){
			String linea;
	        while ((linea = buffer.readLine()) != null) {
	            System.out.println(linea);
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
