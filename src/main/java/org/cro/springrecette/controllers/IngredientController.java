package org.cro.springrecette.controllers;

import java.util.List;

import org.cro.springrecette.models.Ingredient;
import org.cro.springrecette.services.IngredientService;
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
@RequestMapping("ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientService service;
	
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ingredient> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/nom/{nom}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ingredient> findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ingredient save(@RequestBody Ingredient ingredient) {
		return this.service.save(ingredient);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient update(@PathVariable String id, @RequestBody Ingredient ingredient) {
		Ingredient oldIngredient = this.service.findById(id);
		ingredient.setId(oldIngredient.getId());
		return this.service.update(ingredient);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	
}