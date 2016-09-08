package br.com.navas.ws;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

import br.com.navas.controller.Vars;
import br.com.navas.entity.Cerveja;
import br.com.navas.helper.Helper;

@Path("/nomes")
public class Servicos {
	
	@GET
	@Path("{nome}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=iso-8859-1")
	public String retornoPorNome(@PathParam("nome") String nome, @Context HttpServletRequest req){
		Vars.PATH = req.getServletContext().getRealPath("/WEB-INF/classes/br/com/navas/controller/");
		Cerveja cerveja = new Helper().buscarCerveja(nome);
		
		String json = new Gson().toJson(cerveja);
				
		System.out.println(json);
		
		return json;
	}
}
