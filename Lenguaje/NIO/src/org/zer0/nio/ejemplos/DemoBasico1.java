package org.zer0.nio.ejemplos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//http://tutorials.jenkov.com/java-nio/index.html
public class DemoBasico1 {

	public static void main(String[] args) {
		DemoBasico1 demo1=new DemoBasico1();
		demo1.leerArchivo();
	}
	
	public void leerArchivo(){
		
		try(RandomAccessFile rda = new RandomAccessFile("archivo.txt", "rw");){
			FileChannel fileChannel=rda.getChannel();
			ByteBuffer buffer=ByteBuffer.allocate(24);//tambien existen ChafBuffer, DoubleBuffer, IntBuffer......
			int bytesRead=fileChannel.read(buffer);//modo escritura
			while(bytesRead!=-1){
				buffer.flip();//Pasamos a modo lectura del ByteBuffer
				while(buffer.hasRemaining()){
					System.out.println((char)buffer.get());
				}
				buffer.clear();//limpiamos el buffer para volver a usarlo, en realidad no se limpia la data del buffer si no que position se pone a 0 y limit a capacity del buffer.
				bytesRead=fileChannel.read(buffer);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
}
