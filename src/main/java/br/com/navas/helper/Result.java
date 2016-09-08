package br.com.navas.helper;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import br.com.navas.entity.Cerveja;

public class Result {
	
	@SerializedName("cervejas")
	@Expose
	private List<Cerveja> cervejas = new ArrayList<Cerveja>();

	public List<Cerveja> getCervejas() {
		return cervejas;
	}

	public void setCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}
	
}
