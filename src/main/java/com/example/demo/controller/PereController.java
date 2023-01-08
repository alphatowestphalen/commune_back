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


import com.example.demo.model.Pere;
import com.example.demo.repository.PereRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/peres")
public class PereController {
	
	@Autowired
	PereRepository pereRepository;
	
	@PostMapping
	  public ResponseEntity<Pere> createPere(@RequestBody @Valid Pere pere )
	  {   
	    	Pere _pere = pereRepository.save(pere);
	      return new ResponseEntity<>(_pere, HttpStatus.CREATED);
	    
	  }
	
	@GetMapping
	  public ResponseEntity<List<Pere>> getAllPeres() {
	    try {
	      List<Pere> peres = pereRepository.findAll();
	      
	      if (peres.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
	      
	      return new ResponseEntity<>(peres, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/{id}")
	  public ResponseEntity<Pere> getPereById(@PathVariable("id") long id) 
	{
	    Pere pereData = pereRepository.findById(id).get();

	    if (pereData != null) {
	      return new ResponseEntity<>(pereData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PutMapping("/{id}")
	  public ResponseEntity<Pere> updatePere(@PathVariable("id") long id, @RequestBody @Valid Pere pere)
	{
	    Pere pereData = pereRepository.findById(id).get();

	    if (pereData != null) {
	    	pereData.getIdPere();
	    	pereData.setNomPere(pere.getNomPere());
	    	pereData.setPrenomsPere(pere.getPrenomsPere());
	    	pereData.setDatenaissPere(pere.getDatenaissPere());
	    	pereData.setLieuNaissPere(pere.getLieuNaissPere());
	    	pereData.setProfessionPere(pere.getProfessionPere());
	    	pereData.setAdressePere(pere.getAdressePere());

	    	pereRepository.save(pereData);
	      return new ResponseEntity<>(pereData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deletePere(@PathVariable("id") long id) {
	    try {
	    	pereRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
