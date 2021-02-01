package org.cro.springrecette.repositories;

import java.util.List;

import org.cro.springrecette.models.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorieRepository extends MongoRepository<Categorie, String> {

	List<Categorie> findByNom(String nom);
	
}
