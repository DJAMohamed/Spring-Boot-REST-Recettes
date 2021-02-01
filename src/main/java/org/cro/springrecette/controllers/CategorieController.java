package org.cro.springrecette.controllers;

import java.util.List;

import org.cro.springrecette.models.Categorie;
import org.cro.springrecette.services.CategorieService;
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
@RequestMapping("categories")
public class CategorieController {
	
	@Autowired
	private CategorieService service;
	
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categorie> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categorie findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/nom/{nom}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categorie> findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categorie save(@RequestBody Categorie categorie) {
		return this.service.save(categorie);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categorie update(@PathVariable String id, @RequestBody Categorie categorie) {
		Categorie oldCategorie = this.service.findById(id);
		oldCategorie.setId(oldCategorie.getId());
		return this.service.update(categorie);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	
}