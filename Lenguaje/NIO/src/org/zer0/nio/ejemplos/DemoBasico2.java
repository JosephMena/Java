package org.zer0.nio.ejemplos;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class DemoBasico2 {

	
	public static void main(String[] args) {
		DemoBasico2 demo=new DemoBasico2();
		demo.scaterring();
		demo.gathering();
	}
	
	
	//El scattering hace referencia a que el Channel puede escribir en multiples buffers al mismo tiempo.
	//Esto podria permitir que un archivo sea procesado al mismo tiempo por threads diferentes siempre y cuando se conosca de antemano la cantidad de bytes con que se va trabajar.
	public void scaterring(){
		
		try(RandomAccessFile raf=new RandomAccessFile("archivo.txt", "r");) {
			FileChannel fc=raf.getChannel();
			
			ByteBuffer bufferHeader=ByteBuffer.allocate(29);
			ByteBuffer bufferBody=ByteBuffer.allocate(29);
			
			ByteBuffer[] buffers={bufferHeader,bufferBody};
			
			fc.read(buffers);
			bufferHeader.flip();
			while(bufferHeader.hasRemaining()){
				System.out.println("->"+(char)bufferHeader.get());
			}
			
			bufferBody.flip();
			while(bufferBody.hasRemaining()){
				System.out.println("=>"+(char)bufferBody.get());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//El scattering hace referencia a que multiples Buffers pueden escribir al mismo Channel, en realidad se realiza de manera secuencial, segun el orden del array donde se encuentran los buffers.
	//Para este caso si podria hacerse procesamiento distribuido puesto que no se necesita saber con anticipacion del tamaño a guardar puesto que ya se sabe de antemano.
	//Para probar esto primero dejar a 0 bytes el file nuevoArchivo.txt
	public void gathering(){
		try(RandomAccessFile raf=new RandomAccessFile("nuevoArchivo.txt", "rw");) {
			FileChannel fc=raf.getChannel();
			
			ByteBuffer bufferHeader=ByteBuffer.allocate(29);
			ByteBuffer bufferBody=ByteBuffer.allocate(29);
			
			ByteBuffer[] buffers={bufferHeader,bufferBody};
			
			
			bufferHeader.put("Este es mi mensaje al mundo".getBytes());
			bufferBody.put("El cuerpo es nada sin el alma".getBytes()); 
			bufferHeader.flip();//Cambia a modo escritura
			bufferBody.flip();//Cambia a modo escritura
			fc.write(buffers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
