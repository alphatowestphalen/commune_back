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


import com.example.demo.model.PieceJustificative;
import com.example.demo.repository.PieceJustificativeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/piecejustificative")
public class PieceJustificativeController {
	
	@Autowired
	PieceJustificativeRepository pieceJustificativeRepository;
	
	@PostMapping
	  public ResponseEntity<PieceJustificative> createPieceJustificative(@RequestBody @Valid PieceJustificative pieceJustificative )
	  {   
		PieceJustificative _pieceJustificative = pieceJustificativeRepository.save(pieceJustificative);
	      return new ResponseEntity<>(_pieceJustificative, HttpStatus.CREATED);
	    
	  }
	
	@GetMapping
	  public ResponseEntity<List<PieceJustificative>> getAllPieceJustificatives() {
	    try {
	      List<PieceJustificative> pieceJustificatives = pieceJustificativeRepository.findAll();
	      
	      if (pieceJustificatives.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
	      
	      return new ResponseEntity<>(pieceJustificatives, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/{id}")
	  public ResponseEntity<PieceJustificative> getPieceJustificativeById(@PathVariable("id") long id) 
	{
		PieceJustificative pieceJustificativeData = pieceJustificativeRepository.findById(id).get();

	    if (pieceJustificativeData != null) {
	      return new ResponseEntity<>(pieceJustificativeData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	@PutMapping("/{id}")
	  public ResponseEntity<PieceJustificative> updatePieceJustificative(@PathVariable("id") long id, @RequestBody @Valid PieceJustificative pieceJustificative)
	{
		PieceJustificative pieceJustificativeData = pieceJustificativeRepository.findById(id).get();

	    if (pieceJustificativeData != null) {
	    	pieceJustificativeData.getIdPieceJustificative();
	    	pieceJustificativeData.setCertificatAccouch(pieceJustificative.getCertificatAccouch());
	    	pieceJustificativeData.setCinDeclarant(pieceJustificative.getCinDeclarant());
	    	pieceJustificativeData.setCinMere(pieceJustificative.getCinMere());
	    	pieceJustificativeData.setLivretFamille(pieceJustificative.getLivretFamille());
	    	
	    	pieceJustificativeRepository.save(pieceJustificativeData);
	      return new ResponseEntity<>(pieceJustificativeData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deletePieceJustificative(@PathVariable("id") long id) {
	    try {
	    	pieceJustificativeRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
