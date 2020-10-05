package br.com.inmetrics.teste.model;

import java.util.Random;

public class Model {
	
	public static String user = null;
	public static String funcionario = null;
	
	public static String geraNumero8Digitos() {
		
		 String numeros = "0123456789";
		
		Random randomNum = new Random();
		
		String geranumeros = "";
		int index = -1;
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			index = random.nextInt(numeros.length());
			geranumeros += numeros.substring(index, index + 1);
		}
		return geranumeros;
	}

}
