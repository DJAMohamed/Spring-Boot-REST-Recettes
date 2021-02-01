package org.cro.springrecette.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("ingredients")
public class Ingredient {
	
	@Id
	private String id;
	
	private String nom;
	private int quantite;
	private String unite;
	
	public Ingredient() {
		super();
	}
	
	public Ingredient(String id, String nom, int quantite, String unite) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.unite = unite;
	}
	
}