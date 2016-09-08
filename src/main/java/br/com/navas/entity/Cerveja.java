package br.com.navas.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cerveja {

	@SerializedName("nome")
	@Expose
	private String nome;
	@SerializedName("descricao")
	@Expose
	private String descricao;
	@SerializedName("imagem")
	@Expose
	private String imagem;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}	
}
