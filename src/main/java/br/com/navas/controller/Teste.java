package br.com.navas.controller;

import java.io.File;

public class Teste {

	public static void main(String[] args) {
		File file = new File("src/main/java/br/com/navas/controller/cervejas.json");
		
		if(file.exists()){
			System.out.println("ok");
		}else{
			System.out.println("nao");
		}
	}

}
