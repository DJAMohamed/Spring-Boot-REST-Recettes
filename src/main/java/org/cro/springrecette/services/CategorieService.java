package org.cro.springrecette.services;

import java.util.List;

import org.cro.springrecette.models.Categorie;
import org.cro.springrecette.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository repository;

	public List<Categorie> getAll() {
		return this.repository.findAll();
	}

	public Categorie findById(String id) {
		return this.repository.findById(id)
				.orElseThrow(
						()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
						);
	}

	public List<Categorie> findByNom(String nom) {
		return this.repository.findByNom(nom);
	}
	
	public Categorie save(@RequestBody Categorie categorie) {
		return this.repository.save(categorie);
	}

	public Categorie update(@RequestBody Categorie categorie) {
		return this.repository.save(categorie);
	}

	public void delete(@PathVariable String id) {
		this.repository.deleteById(id);
	}
	
}