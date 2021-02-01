package org.cro.springrecette.services;

import java.util.List;

import org.cro.springrecette.models.Ingredient;
import org.cro.springrecette.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository repository;

	public List<Ingredient> getAll() {
		return this.repository.findAll();
	}

	public Ingredient findById(String id) {
		return this.repository.findById(id)
				.orElseThrow(
						()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
						);
	}
	
	public List<Ingredient> findByNom(String nom) {
		return this.repository.findByNom(nom);
	}
	
	public Ingredient save(@RequestBody Ingredient ingredient) {
		return this.repository.save(ingredient);
	}

	public Ingredient update(@RequestBody Ingredient ingredient) {
		return this.repository.save(ingredient);
	}

	public void delete(@PathVariable String id) {
		this.repository.deleteById(id);
	}
	
}