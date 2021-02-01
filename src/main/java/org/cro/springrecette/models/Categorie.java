package org.cro.springrecette.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("categories")
public class Categorie {
	
	@Id
	private String id;
	
	private String nom;
	
	public Categorie() {
		
	}

	public Categorie(String id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
}