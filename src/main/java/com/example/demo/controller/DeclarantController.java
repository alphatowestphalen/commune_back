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

import com.example.demo.model.Declarant;
import com.example.demo.repository.DeclarantRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DeclarantController {
	@Autowired
	DeclarantRepository declarantRepository;
	
	@GetMapping("/declarants/{id}")
	  public ResponseEntity<Declarant> getDeclarantById(@PathVariable("id") long id) 
	{
	    Optional<Declarant> declarantData = declarantRepository.findById(id);

	    if (declarantData.isPresent()) {
	      return new ResponseEntity<>(declarantData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PostMapping("/declarant")
	  public ResponseEntity<Declarant> createDeclarant(@RequestBody Declarant declarant )
	  {
	    try {
	    	Declarant _declarant = declarantRepository
	          .save(new Declarant(declarant.getNomDeclarant(), declarant.getPrenomsDeclarant(), declarant.getDatenaissDeclarant(), declarant.getLieuNaissDeclarant(), declarant.getAdressDeclarant() ));
	      return new ResponseEntity<>(_declarant, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/declarants")
	  public ResponseEntity<List<Declarant>> getAllDeclarants() {
	    try {
	      List<Declarant> declarants = new ArrayList<Declarant>();

	     	      
	      declarantRepository.findAll().forEach(declarants::add);
	      if (declarants.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

	      return new ResponseEntity<>(declarants, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PutMapping("/declarants/{id}")
	  public ResponseEntity<Declarant> updateDeclarant(@PathVariable("id") long id, @RequestBody Declarant declarant) {
	    Optional<Declarant> declarantData = declarantRepository.findById(id);

	    if (declarantData.isPresent()) {
	    	Declarant _declarant = declarantData.get();
	    	_declarant.setNomDeclarant(declarant.getNomDeclarant());
	    	_declarant.setPrenomsDeclarant(declarant.getPrenomsDeclarant());
	    	_declarant.setDatenaissDeclarant(declarant.getDatenaissDeclarant());
	    	_declarant.setLieuNaissDeclarant(declarant.getLieuNaissDeclarant());
	    	_declarant.setAdressDeclarant(declarant.getAdressDeclarant());

	      return new ResponseEntity<>(declarantRepository.save(_declarant), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	 @DeleteMapping("/declarants/{id}")
	  public ResponseEntity<HttpStatus> deleteDeclarant(@PathVariable("id") long id) {
	    try {
	    	declarantRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
 
}
