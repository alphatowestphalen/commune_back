package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Maire;
import com.example.demo.repository.MaireRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/maires")
public class MaireController {

	@Autowired
	MaireRepository maireRepository;
	
	@PostMapping
	// @PreAuthorize("hasRole('MAIRE')")
	  public ResponseEntity<Maire> createMaire (@RequestBody @Valid Maire maire )
	  {
	    
	    	Maire _maire = maireRepository.save(maire);
	      return new ResponseEntity<>(_maire, HttpStatus.CREATED);
	    
	  }
	
	@GetMapping
	// @PreAuthorize("hasRole('USER')")
	  public ResponseEntity<List<Maire>> getAllMaires() {
	    try {
	      List<Maire> maires = maireRepository.findAll();

	      if (maires.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(maires, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	  public ResponseEntity<Maire> getByIdMaire(@PathVariable("id") Long id)
	{
	       	Maire maire = maireRepository.findById(id).get();
	    	
	    	if (maire != null) {
	  	      return new ResponseEntity<>(maire, HttpStatus.OK);
	  	    } else {
	  	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	    }
	  }
	
	@PutMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<Maire> updateMaire(@PathVariable("id") Long id, @RequestBody @Valid Maire maire) 
	{
		Maire maireData = maireRepository.findById(id).get();
		if(maireData != null)
		{
			maireData.getIdMaire();
			maireData.setNomMaire(maire.getNomMaire());
			maireData.setPrenomsMaire(maire.getPrenomsMaire());
			maireData.setFonction(maire.getFonction());
			
			maireRepository.save(maireData);
			
			return new ResponseEntity<>(maireData, HttpStatus.OK);
		}
		else
		{
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	@PutMapping("/restore/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<HttpStatus> restoreMaire(@Param("idMaire") Long idMaire) 
	{
		try {
			maireRepository.restoreMaire(idMaire);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e)
		{
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	@DeleteMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<HttpStatus>  supprMaire(@PathVariable("id") long id) {	
		try {
			maireRepository.deleteById(id);			 
	      return new ResponseEntity<>(HttpStatus.OK);
	      
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/supprdefinitive/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<HttpStatus>  supprDefinitive(@PathVariable("id") long id) {	
		try {
			maireRepository.supprdefinitive(id);			 
	      return new ResponseEntity<>(HttpStatus.OK);
	      
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
