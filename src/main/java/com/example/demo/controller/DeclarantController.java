package com.example.demo.controller;


import java.util.List;


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

import com.example.demo.model.Declarant;
import com.example.demo.repository.DeclarantRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/declarants")
public class DeclarantController {
	@Autowired
	DeclarantRepository declarantRepository;
	
	@PostMapping
	  public ResponseEntity<Declarant> createDeclarant(@RequestBody @Valid Declarant declarant )
	  {	    
	    	Declarant _declarant = declarantRepository.save(declarant);
	      return new ResponseEntity<>(_declarant, HttpStatus.CREATED);
	  }

	
	@GetMapping
	  public ResponseEntity<List<Declarant>> getAllDeclarants() {
	    try {
	      List<Declarant> declarants = declarantRepository.findAll();
	     	      
	      if (declarants.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

	      return new ResponseEntity<>(declarants, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<Declarant> getDeclarantById(@PathVariable("id") long id) 
	{
	    Declarant declarant = declarantRepository.findById(id).get();

	    if (declarant != null) {
	      return new ResponseEntity<>(declarant, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	@PutMapping("/{id}")
	  public ResponseEntity<Declarant> updateDeclarant(@PathVariable("id") long id, @RequestBody @Valid Declarant declarant)
	{
		 Declarant declarantData = declarantRepository.findById(id).get();

	    if (declarantData != null) {
	    	declarantData.getIdDeclarant();
	    	declarantData.setNomDeclarant(declarant.getNomDeclarant());
	    	declarantData.setPrenomsDeclarant(declarant.getPrenomsDeclarant());
	    	declarantData.setDatenaissDeclarant(declarant.getDatenaissDeclarant());
	    	declarantData.setLieuNaissDeclarant(declarant.getLieuNaissDeclarant());
	    	declarantData.setAdressDeclarant(declarant.getAdressDeclarant());

	    	declarantRepository.save(declarantData);
	    	
	      return new ResponseEntity<>(declarantData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	 @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteDeclarant(@PathVariable("id") long id)
	 {
	    try {
	    	declarantRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
 
}
