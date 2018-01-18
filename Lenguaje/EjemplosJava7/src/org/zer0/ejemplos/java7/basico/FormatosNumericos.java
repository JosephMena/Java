package org.zer0.ejemplos.java7.basico;

public class FormatosNumericos {

	
	public static void main(String[] args) {
		FormatosNumericos formatos=new FormatosNumericos();
		formatos.numeroBinario();
		formatos.literalEnteroSubrayado();
	}
	
	public void numeroBinario(){
		int binario=0b00110;//Los binarios empiezan por 0b
		System.out.println("el numero en decimal es:"+binario);
	}
	
	public void literalEnteroSubrayado(){
		int numero=121_23_1; 
		int numero1=1_2_1_23_1;// numero y numero1 visualmente parecen diferentes pero son identicos para el ordenador, el _ solo es un separador visual. 
		System.out.println("numero  :"+numero);
		System.out.println("numero 1:"+numero1);
	}
}
