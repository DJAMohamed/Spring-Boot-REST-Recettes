package org.cro.springrecette.controllers;

import java.util.List;

import org.cro.springrecette.models.Categorie;
import org.cro.springrecette.models.Ingredient;
import org.cro.springrecette.models.Recette;
import org.cro.springrecette.services.CategorieService;
import org.cro.springrecette.services.IngredientService;
import org.cro.springrecette.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recettes")
public class RecetteController {
	
	@Autowired
	private RecetteService service;
	@Autowired
	private CategorieService catService;
	@Autowired
	private IngredientService ingService;
	
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Recette findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/nom/{nom}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Recette save(@RequestBody Recette recette) {
		return this.service.save(recette);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Recette update(@PathVariable String id, @RequestBody Recette recette) {
		Recette oldRecette = this.service.findById(id);
		recette.setId(oldRecette.getId());
		return this.service.update(recette);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	
	@PutMapping("/{idRecette}/ingredients")
	@ResponseStatus(code = HttpStatus.OK)
	public Recette updateRecette(@PathVariable String idRecette, @RequestBody List<Ingredient> ingredients) {
		return this.service.updateRecetteIngredient(idRecette, ingredients);
	}
	
	@GetMapping("categories/{idCategorie}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findRecetteByCategorie(@PathVariable String idCategorie) {
		Categorie categorie = catService.findById(idCategorie);
		return this.service.findRecetteByCategorie(categorie);
	}
	
	/**
	 * 
	 * @param idCategorie
	 * @return
	 */
	
	@GetMapping("ingredients/{idIngredient}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findRecetteByIngredient(@PathVariable String idIngredient) {
		Ingredient ingredient = ingService.findById(idIngredient);
		return this.service.findRecetteByIngerient(ingredient);
	}
	
}