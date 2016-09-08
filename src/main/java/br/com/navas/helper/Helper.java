package br.com.navas.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import br.com.navas.controller.Vars;
import br.com.navas.database.DataBase;
import br.com.navas.entity.Cerveja;

public class Helper {
	
	private Cerveja lerDoArquivo(String nome){
		BufferedReader buffer = null;
		try {
			System.out.println("Procurou no arquivo");
			System.out.println(Vars.PATH+"cervejas.json");
			File file = new File(Vars.PATH+"cervejas.json");
			if(file.exists()){
				System.out.println("ok");
			}else{
				System.out.println("nao");
			}
			buffer = new BufferedReader(new FileReader(Vars.PATH+"cervejas.json"));
			System.out.println("Caminho do arquivo: "+ Vars.PATH+"cervejas.json");
			
			Gson gson = new Gson();
			Result result = gson.fromJson(buffer, Result.class);
			DataBase.cervejas = (ArrayList<Cerveja>) result.getCervejas();
			
			for(Cerveja c : DataBase.cervejas){
				System.out.println(c.getNome());
				if(nome.equalsIgnoreCase(c.getNome())){
					return c;
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(buffer != null){
				try {
					buffer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
		
	}
	
	public void cadastra(Cerveja cerveja){
		DataBase.cervejas.add(cerveja);
		Map<String , ArrayList<Cerveja>> cervejas = new HashMap<String, ArrayList<Cerveja>>();
		cervejas.put("cervejas", DataBase.cervejas);
		String json = new Gson().toJson(cervejas);
		System.out.println(json);
		PrintWriter print = null;
		try {
			print = new PrintWriter("C:\\Users\\eduardo.navas\\Desktop\\cervejas.json");
			print.write(json);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(print != null){
				print.close();
			}
		}
	}
	
	public Cerveja buscarCerveja(String nome){
		
		System.out.println(DataBase.cervejas.size());
		
		for(Cerveja c : DataBase.cervejas){
			if(nome.equalsIgnoreCase(c.getNome())){
				System.out.println(c.getNome());
				return c;
			}
		}
		
		return lerDoArquivo(nome);
	}
	
}
