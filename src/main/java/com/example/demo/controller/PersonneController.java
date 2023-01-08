package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/personnes")
public class PersonneController {
	@Autowired
	PersonneRepository 	personneRepository;
	
	@PostMapping
	  public ResponseEntity<Personne> createDeclarant(@RequestBody @Valid Personne personne )
	  {
	    
	    	Personne _personne = personneRepository.save(personne);
	      return new ResponseEntity<>(_personne, HttpStatus.CREATED);
	    
	  }
	
	@GetMapping
	  public ResponseEntity<List<Personne>> getAllPersonnes() {
	    try {
	      List<Personne> personnes = personneRepository.findAll();
	     	 
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
	    Personne personneData = personneRepository.findById(id).get();

	    if (personneData != null) {
	      return new ResponseEntity<>(personneData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PutMapping("/{id}")
	  public ResponseEntity<Personne> updatePersonne(@PathVariable("id") long id, @RequestBody @Valid Personne personne)
	{
	    Personne personneData = personneRepository.findById(id).get();

	    if (personneData != null) {
	    	personneData.getIdPersonne();
	    	personneData.setDatenaissPersonne(personne.getDatenaissPersonne());
	    	personneData.setHeurenaissPersonne(personne.getHeurenaissPersonne());
	    	personneData.setLieuNaissPersonne(personne.getLieuNaissPersonne());
	    	personneData.setNomPersonne(personne.getNomPersonne());
	    	personneData.setPrenomsPersonne(personne.getPrenomsPersonne());
	    	personneData.setSexePersonne(personne.getSexePersonne());

	    	personneRepository.save(personneData);
	    	
	      return new ResponseEntity<>(personneData, HttpStatus.OK);
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
