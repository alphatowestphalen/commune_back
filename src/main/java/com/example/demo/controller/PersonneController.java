package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Personne;
import com.example.demo.repository.PersonneRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/personnes")
public class PersonneController {
	@Autowired
	PersonneRepository 	personneRepository;
	
	@PostMapping
	  public ResponseEntity<Personne> createDeclarant(@RequestBody Personne personne )
	  {
	    try {
	    	Personne _personne = personneRepository
	          .save(personne);
	      return new ResponseEntity<>(_personne, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping
	  public ResponseEntity<List<Personne>> getAllPersonnes() {
	    try {
	      List<Personne> personnes = new ArrayList<Personne>();

	     	      
	      personneRepository.findAll().forEach(personnes::add);
	      if (personnes.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

	      return new ResponseEntity<>(personnes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/{id}")
	  public ResponseEntity<Personne> getPersonneById(@PathVariable("id") long id) 
	{
	    Optional<Personne> personneData = personneRepository.findById(id);

	    if (personneData.isPresent()) {
	      return new ResponseEntity<>(personneData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PutMapping("/{id}")
	  public ResponseEntity<Personne> updatePersonne(@PathVariable("id") long id, @RequestBody Personne personne) {
	    Optional<Personne> personneData = personneRepository.findById(id);

	    if (personneData.isPresent()) {
	    	Personne _personne = personneData.get();
	    	_personne.setDatenaissPersonne(personne.getDatenaissPersonne());
	    	_personne.setHeurenaissPersonne(personne.getHeurenaissPersonne());
	    	_personne.setLieuNaissPersonne(personne.getLieuNaissPersonne());
	    	_personne.setNomPersonne(personne.getNomPersonne());
	    	_personne.setPrenomsPersonne(personne.getPrenomsPersonne());
	    	_personne.setSexePersonne(personne.getSexePersonne());

	      return new ResponseEntity<>(personneRepository.save(_personne), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deletePersonne(@PathVariable("id") long id) {
	    try {
	    	personneRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
 
}
