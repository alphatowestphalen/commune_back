package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.example.demo.model.Adoption;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.AdoptionRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.AdoptionRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/adoptions")
public class AdoptionController {

	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	AdoptionRepository adoptionRepository;
	
	@GetMapping
	  public ResponseEntity<List<Adoption>> getAllAdoptions() {
	    List<Adoption> adoptions = new ArrayList<Adoption>();

	    adoptionRepository.findAll().forEach(adoptions::add);

	    if (adoptions.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(adoptions, HttpStatus.OK);
	  }
	
	@GetMapping("/{id}")
	  public ResponseEntity<Adoption> getAdoptionById(@PathVariable(value = "id") Long id) {
		Adoption adoption = adoptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + id));
;
	    return new ResponseEntity<>(adoption, HttpStatus.OK);
	  }
	
	@PostMapping("/{IdPremierCopie}")
	  public ResponseEntity<Adoption> addAdoption(@PathVariable(value = "IdPremierCopie") Long IdPremierCopie, @RequestBody AdoptionRequest adoptionRequest) 
	{
		try {
			PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie).get();
			
			Adoption adoption = new Adoption(
					adoptionRequest.getParentAdoptif(),
					adoptionRequest.getDateAdoption(),
					adoptionRequest.getHeureAdoption(),
					adoptionRequest.getNumAdoption(),
					adoptionRequest.getCreatedDate(),
					premierCopie
					);
			
			adoptionRepository.save(adoption);
			return new ResponseEntity<>(adoption, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
			
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Adoption> updateAdoption(@PathVariable(value = "id") Long id, @RequestBody AdoptionRequest adoptionRequest)
	{
		Adoption adoption = adoptionRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Adoption with id = " + id));
		
		PremierCopie premierCopie = premierCopieRepository.findById(adoption.getPremierecopie().getIdPremierCopie()).get();
		
		adoption.setParentAdoptif(adoptionRequest.getParentAdoptif());
		adoption.setDateAdoption(adoptionRequest.getDateAdoption());
		adoption.setHeureAdoption(adoptionRequest.getHeureAdoption());
		adoption.setNumAdoption(adoptionRequest.getNumAdoption());
		adoption.setPremierecopie(premierCopie);
		
		
		adoptionRepository.save(adoption);
		
		return new ResponseEntity<>(adoption, HttpStatus.OK);	}

	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteAdoption(@PathVariable("id") long id) 
	{
		try {
			adoptionRepository.deleteById(id);

		    return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	    
	  }
	
}
