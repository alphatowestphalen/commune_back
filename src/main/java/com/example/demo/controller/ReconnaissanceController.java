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

import com.example.demo.model.PremierCopie;
import com.example.demo.model.Reconnaissance;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.repository.ReconnaissanceRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reconnaissances")
public class ReconnaissanceController {

	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	ReconnaissanceRepository reconnaissanceRepository;
	
	@GetMapping
	  public ResponseEntity<List<Reconnaissance>> getAllReconnaissances() {
	    List<Reconnaissance> reconnaissances = new ArrayList<Reconnaissance>();

	    reconnaissanceRepository.findAll().forEach(reconnaissances::add);

	    if (reconnaissances.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(reconnaissances, HttpStatus.OK);
	  }
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<Reconnaissance> getReconnaissanceById(@PathVariable(value = "id") Long id) {
		Reconnaissance reconnaissance = reconnaissanceRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Reconnaissance with id = " + id));

	    return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
	  }
	
	@PostMapping("/{IdPremierCopie}")
	  public ResponseEntity<Reconnaissance> addReconnaissance(@PathVariable(value = "IdPremierCopie") Long IdPremierCopie, @RequestBody Reconnaissance reconnaissanceRequest) 
	{
		Reconnaissance reconnaissance = premierCopieRepository.findById(IdPremierCopie).map(premierCopie -> {
			long idReconnaissance = reconnaissanceRequest.getIdReconnaissance();
			
			// is existed
			if(idReconnaissance != 0L) {
				Reconnaissance _reconnaissance = reconnaissanceRepository.findById(idReconnaissance)
						.orElseThrow(() -> new ResourceNotFoundException("Not found Reconnaissance with id = " + idReconnaissance));
				premierCopie.addReconnaissance(_reconnaissance);
				premierCopieRepository.save(premierCopie);
				return _reconnaissance;
			}
			
			//add and create
			premierCopie.addReconnaissance(reconnaissanceRequest);
			return reconnaissanceRepository.save(reconnaissanceRequest);
			
		}).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + IdPremierCopie));
	    return new ResponseEntity<>(reconnaissance, HttpStatus.CREATED);

	}
	
	/*@GetMapping("/premierCopie/{IdPremierCopie}")
	public ResponseEntity<List<Reconnaissance>> getAllReconnaissanceByIdPremierCopie(@PathVariable(value = "IdPremierCopie") Long IdPremierCopie)
	{
		if(!premierCopieRepository.existsById(IdPremierCopie))
		{
			throw new ResourceNotFoundException("Not found Tutorial with id = " + IdPremierCopie);
		}
		
		List<Reconnaissance> reconnaissances = reconnaissanceRepository.findReconnaissancesByIdPremierCopie(IdPremierCopie);
		return new ResponseEntity<>(reconnaissances, HttpStatus.OK);
	}
	*/
	@PutMapping("/{id}")
	public ResponseEntity<Reconnaissance> updateReconnaissance(@PathVariable(value = "id") Long id, @RequestBody Reconnaissance reconnaissanceRequest)
	{
		Reconnaissance reconnaissance = reconnaissanceRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Reconnaissance with id = " + id));
		
		reconnaissance.setDateDeclaration(reconnaissanceRequest.getDateDeclaration());
		reconnaissance.setHeureDeclaration(reconnaissanceRequest.getHeureDeclaration());
		reconnaissance.setInfoPersonDeclarant(reconnaissanceRequest.getInfoPersonDeclarant());
		
		reconnaissanceRepository.save(reconnaissance);
		
		return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/premierCopie/{IdPremierCopie}")
	public ResponseEntity<HttpStatus> deleteReconnaissanceFromPremierCopie(@PathVariable(value = "id") Long id, @PathVariable(value = "IdPremierCopie") Long IdPremierCopie)
	{
		try {
			PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie)
			        .orElseThrow(() -> new ResourceNotFoundException("Not found Premier Copie with id = " + IdPremierCopie));
			
			premierCopie.removeReconnaissance(id);
			premierCopieRepository.save(premierCopie);
			
			 return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	}
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteTag(@PathVariable("id") long id) 
	{
		try {
			reconnaissanceRepository.deleteById(id);

		    return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	    
	  }
	
}
