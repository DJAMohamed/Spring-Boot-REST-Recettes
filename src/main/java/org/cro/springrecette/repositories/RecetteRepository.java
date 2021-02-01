package org.cro.springrecette.repositories;

import java.util.List;

import org.cro.springrecette.models.Categorie;
import org.cro.springrecette.models.Ingredient;
import org.cro.springrecette.models.Recette;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecetteRepository extends MongoRepository<Recette, String> {

	List<Recette> findByNomAllIgnoreCase(String nom);
	List<Recette> findByCategories(Categorie categorie);
	List<Recette> findByIngredients(Ingredient ingredient);
	
}