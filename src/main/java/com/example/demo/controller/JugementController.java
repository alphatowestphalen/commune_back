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


import com.example.demo.model.Jugement;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.JugementRepository;
import com.example.demo.repository.PremierCopieRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jugements")
public class JugementController {
	
	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	JugementRepository jugementRepository;
	
	@GetMapping
	  public ResponseEntity<List<Jugement>> getAllJugements() {
	    List<Jugement> jugements = new ArrayList<Jugement>();

	    jugementRepository.findAll().forEach(jugements::add);

	    if (jugements.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(jugements, HttpStatus.OK);
	  }
	
	@GetMapping("/{id}")
	  public ResponseEntity<Jugement> getJugementById(@PathVariable(value = "id") Long id) {
		Jugement jugement = jugementRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + id));

	    return new ResponseEntity<>(jugement, HttpStatus.OK);
	  }
	
	@PostMapping("/{IdPremierCopie}")
	  public ResponseEntity<Jugement> addJugement(@PathVariable(value = "IdPremierCopie") Long IdPremierCopie, 
			  @RequestBody Jugement jugementRequest) 
	{
		Jugement jugement = premierCopieRepository.findById(IdPremierCopie).map(premierCopie -> {
			long idJugement = jugementRequest.getIdJugement();
			
			// is existed
			if(idJugement != 0L) {
				Jugement _jugement = jugementRepository.findById(idJugement)
						.orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + idJugement));
				premierCopie.addJugement(_jugement);
				premierCopieRepository.save(premierCopie);
				return _jugement;
			}
			
			//add and create
			premierCopie.addJugement(jugementRequest);
			return jugementRepository.save(jugementRequest);
			
		}).orElseThrow(() -> new ResourceNotFoundException("Not found Premier Copie with id = " + IdPremierCopie));
	    return new ResponseEntity<>(jugement, HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Jugement> updateJugement(@PathVariable(value = "id") Long id, 
			@RequestBody Jugement jugementRequest)
	{
		Jugement jugement = jugementRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + id));
		
		jugement.setInfoChangement(jugementRequest.getInfoChangement());
		jugement.setNumJugement(jugementRequest.getNumJugement());
		
		jugementRepository.save(jugement);
		
		return new ResponseEntity<>(jugement, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/premierCopie/{IdPremierCopie}")
	public ResponseEntity<HttpStatus> deleteJugementFromPremierCopie(@PathVariable(value = "id") Long id,
			@PathVariable(value = "IdPremierCopie") Long IdPremierCopie)
	{
		
		PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Premier Copie with id = " + IdPremierCopie));
		
		premierCopie.removeJugement(id);
		premierCopieRepository.save(premierCopie);
		
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	}
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteJugement(@PathVariable("id") long id) 
	{
		try {
			jugementRepository.deleteById(id);

		    return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	    
	  }
	

}