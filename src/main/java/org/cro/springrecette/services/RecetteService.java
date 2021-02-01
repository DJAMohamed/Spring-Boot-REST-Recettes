package org.cro.springrecette.services;

import java.util.List;

import org.cro.springrecette.models.Categorie;
import org.cro.springrecette.models.Ingredient;
import org.cro.springrecette.models.Recette;
import org.cro.springrecette.repositories.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RecetteService {
	@Autowired
	private RecetteRepository repository;

	public List<Recette> getAll() {
		return this.repository.findAll();
	}

	public Recette findById(String id) {
		return this.repository.findById(id)
				.orElseThrow(
						()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
						);
	}
	
	public List<Recette> findByNom(String nom) {
		return this.repository.findByNomAllIgnoreCase(nom);
	}

	public Recette save(@RequestBody Recette recette) {
		return this.repository.save(recette);
	}

	public Recette update(@RequestBody Recette recette) {
		return this.repository.save(recette);
	}

	public void delete(@PathVariable String id) {
		this.repository.deleteById(id);
	}

	public Recette updateRecetteIngredient(String idRecette, List<Ingredient> ingredients) {
		Recette recette = findById(idRecette);
		recette.setIngredients(ingredients);
		return this.repository.save(recette);
	}

	public List<Recette> findRecetteByCategorie(Categorie categorie) {
		return this.repository.findByCategories(categorie);

	}

	/**
	 * 
	 * @param ingredient
	 * @return
	 */
	public List<Recette> findRecetteByIngerient(Ingredient ingredient) {
		return this.repository.findByIngredients(ingredient);
	}

}