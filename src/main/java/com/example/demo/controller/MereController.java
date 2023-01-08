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

import com.example.demo.model.Mere;
import com.example.demo.repository.MereRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/meres")
public class MereController {
	
	@Autowired
	MereRepository mereRepository;
	
	@PostMapping
	  public ResponseEntity<Mere> createMere(@RequestBody @Valid Mere mere )
	  {
	   
	    	Mere _mere = mereRepository.save(mere);
	      return new ResponseEntity<>(_mere, HttpStatus.CREATED);
	   
	  }
	
	@GetMapping
	  public ResponseEntity<List<Mere>> getAllMeres() {
	    try {
	      List<Mere> meres =  mereRepository.findAll();

	      if (meres.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
	      
	      return new ResponseEntity<>(meres, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/{id}")
	  public ResponseEntity<Mere> getMereById(@PathVariable("id") long id) 
	{
	    Mere mereData = mereRepository.findById(id).get();

	    if (mereData != null) {
	      return new ResponseEntity<>(mereData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PutMapping("/{id}")
	  public ResponseEntity<Mere> updateMere(@PathVariable("id") long id, @RequestBody @Valid Mere mere)
	{
	    Mere mereData = mereRepository.findById(id).get();

	    if (mereData != null) {
	    	mereData.getIdMere();
	    	mereData.setNomMere(mere.getNomMere());
	    	mereData.setPrenomsMere(mere.getPrenomsMere());
	    	mereData.setDatenaissMere(mere.getDatenaissMere());
	    	mereData.setLieuNaissMere(mere.getLieuNaissMere());
	    	mereData.setProfessionMere(mere.getProfessionMere());
	    	mereData.setAdresseMere(mere.getAdresseMere());
	    	
	    	mereRepository.save(mereData);

	      return new ResponseEntity<>(mereData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteMere(@PathVariable("id") long id) {
	    try {
	    	mereRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


}
