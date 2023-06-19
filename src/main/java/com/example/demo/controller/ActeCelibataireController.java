package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ActeCelibataire;
import com.example.demo.model.ActeDeces;
import com.example.demo.model.Adoption;
import com.example.demo.model.Defunt;
import com.example.demo.model.Maire;
import com.example.demo.model.PieceDeces;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.Reconnaissance;
import com.example.demo.repository.ActeCelibataireRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.ActeCelibataireRequest;
import com.example.demo.request.DecesRequest;
import com.example.demo.request.NumeroActeCelibataire;
import com.example.demo.request.ReconnaissanceRequest;
import com.example.demo.service.ActeCelibataireService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/acteCelibataires")
public class ActeCelibataireController {
	
	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	ActeCelibataireRepository acteCelibataireRepository;
	@Autowired
	ActeCelibataireService acteCelibataireService;
	
	@GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Map<String, Object>> getAllActeCelibataires(
			     @RequestParam(required = false) String title,
			        @RequestParam(defaultValue = "0") int page,
			        @RequestParam(defaultValue = "3") int size) {
		try {
			
			 List<ActeCelibataire> acteCelibataires = new ArrayList<ActeCelibataire>();
		        Pageable paging = PageRequest.of(page, size);
		        
		        Page<ActeCelibataire> pageactecelibataire;
		        pageactecelibataire = acteCelibataireRepository.findAll(paging);

		        if (pageactecelibataire.hasContent())
		        	
		        	acteCelibataires = pageactecelibataire.getContent();

		             Map<String, Object> response = new HashMap<>();
		             response.put("acteCelibataire", acteCelibataires);
		             response.put("currentPage", pageactecelibataire.getNumber());
		             response.put("totalItems", pageactecelibataire.getTotalElements());
		             response.put("totalPages", pageactecelibataire.getTotalPages());
		      return new ResponseEntity<>(response, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	
	@PostMapping("/{IdPremierCopie}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<ActeCelibataire> addActeCelibataire(@PathVariable(value = "IdPremierCopie") String IdPremierCopie, @RequestBody ActeCelibataireRequest acteCelibataireRequest) 
	{
		try {
			NumeroActeCelibataire numeroActeCelibataire = acteCelibataireService.numeroActeCelibataire();
			
			PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
			
			ActeCelibataire acteCelibataire = new ActeCelibataire(
					numeroActeCelibataire.idActeCelibataire,
					acteCelibataireRequest.getNomFkt(),
					acteCelibataireRequest.getNumCin(),
					acteCelibataireRequest.getDateCin(),
					acteCelibataireRequest.getLieuCin(),
					acteCelibataireRequest.getDateActe(),
					premierCopie,
					numeroActeCelibataire.numero,
					numeroActeCelibataire.annee,
					acteCelibataireRequest.getCreatedDate()
					);
			
			acteCelibataireRepository.save(acteCelibataire);
			return new ResponseEntity<>(acteCelibataire, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
			
	}
	
	@GetMapping("/{id}")
	  public ResponseEntity<ActeCelibataire> getActeCelibataireById(@PathVariable(value = "id") String id) {
		
		ActeCelibataire acteCelibataire = acteCelibataireRepository
											.findById(id)
											.orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + id));;

	    return new ResponseEntity<>(acteCelibataire, HttpStatus.OK);
	  }
	
	@PutMapping("/{id}")
	public ResponseEntity<ActeCelibataire> updateActeCelibataire(@PathVariable(value = "id") String id, @RequestBody ActeCelibataireRequest acteCelibataireRequest)
	{
		try {
			
			ActeCelibataire acteCelibataire = acteCelibataireRepository
					.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + id));;
			
			PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(acteCelibataire.getPremierecopie().getIdPremierCopie());
			
			
			//acteDeces.setIdActeDeces(decesRequest.getIdActeDeces());
			acteCelibataire.setNomFkt(acteCelibataireRequest.getNomFkt());
			acteCelibataire.setNumCin(acteCelibataireRequest.getNumCin());
			acteCelibataire.setDateCin(acteCelibataireRequest.getDateCin());
			acteCelibataire.setLieuCin(acteCelibataireRequest.getLieuCin());
			acteCelibataire.setDateActe(acteCelibataireRequest.getDateActe());
			acteCelibataire.setPremierecopie(premierCopie);
			
			
			acteCelibataireRepository.save(acteCelibataire);
			return new ResponseEntity<>(acteCelibataire, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
			
	}
	
	@DeleteMapping("/{id}")
//	 @PreAuthorize(" hasRole('MAIRE')")
	  public ResponseEntity<HttpStatus> deleteActeCelibataire(@PathVariable("id") String id) 
	{
		try {
			
			acteCelibataireRepository.deleteById(id);

		    return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	    
	  }
	
	

}
