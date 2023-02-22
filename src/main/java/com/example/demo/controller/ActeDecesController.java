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

import com.example.demo.model.ActeDeces;
import com.example.demo.model.Defunt;
import com.example.demo.model.Maire;
import com.example.demo.model.PieceDeces;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.Reconnaissance;
import com.example.demo.repository.ActeDecesRepository;
import com.example.demo.repository.DefuntRepository;
import com.example.demo.repository.MaireRepository;
import com.example.demo.repository.PieceDecesRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.DecesRequest;
import com.example.demo.request.ReconnaissanceRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/deces")
public class ActeDecesController {

	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	ActeDecesRepository acteDecesRepository;
	@Autowired
	MaireRepository maireRepository;
	@Autowired
	DefuntRepository defuntRepository;
	@Autowired
	PieceDecesRepository pieceDecesRepository;
	
	@PostMapping("/{IdPremierCopie}")
	  public ResponseEntity<ActeDeces> addDeces(@PathVariable(value = "IdPremierCopie") Long IdPremierCopie, @RequestBody DecesRequest decesRequest) 
	{
		try {
			
			PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie).get();
				
			Maire maire = maireRepository.findById(decesRequest.getIdMaire()).get();
					
			Defunt defunt = new Defunt(
					decesRequest.getProfessionDefunt(),
					decesRequest.getAdresseDefunt(),
					decesRequest.getDateDeces(),
					decesRequest.getLieuDeces(),
					decesRequest.getHeureDeces());
			defuntRepository.save(defunt);
					
			PieceDeces pieceDeces = new PieceDeces(
					decesRequest.isNomPiece());
			pieceDecesRepository.save(pieceDeces);
					
			ActeDeces actedeces = new ActeDeces(
					decesRequest.getIdActeDeces(),
					decesRequest.getDateDeclaration(),
					decesRequest.getHeureDeclaration(),
					decesRequest.getNomDeclarant(),
					decesRequest.getPrenomsDeclarant(),
					decesRequest.getProfessionDeclarant(),
					decesRequest.getLieuNaissanceDeclarant(),
					decesRequest.getAdresseDeclarant(),
					decesRequest.getDateNaissanceDeclarant(),
					decesRequest.getDate(),
					maire,
					defunt,
					pieceDeces,
					decesRequest.getCreatedDate(),
					premierCopie
					);
			
			acteDecesRepository.save(actedeces);
			return new ResponseEntity<>(actedeces, HttpStatus.OK);
			
		} catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping
	  public ResponseEntity<List<ActeDeces>> getAllActeDeces() {
	    List<ActeDeces> acte = new ArrayList<ActeDeces>();

	    acteDecesRepository.findAll().forEach(acte::add);

	    if (acte.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(acte, HttpStatus.OK);
	  }
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<ActeDeces> getActeDecesById(@PathVariable(value = "id") Long id) {
		ActeDeces acte = acteDecesRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Acte de Deces with id = " + id));

	    return new ResponseEntity<>(acte, HttpStatus.OK);
	  }
	
	@PutMapping("/{id}")
	public ResponseEntity<ActeDeces> updateActeDeces(@PathVariable(value = "id") Long id, @RequestBody DecesRequest decesRequest)
	{
		try {
			
			ActeDeces acteDeces = acteDecesRepository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Not found Acte de décès with id = " + id));
			
			PremierCopie premierCopie = premierCopieRepository.findById(decesRequest.getIdPremierCopie()).get();
			Maire maire = maireRepository.findById(decesRequest.getIdMaire()).get();
			
			Defunt defunt = acteDeces.getDefunt();
			PieceDeces pieceDeces = acteDeces.getPieceDeces();
			
			defunt.setProfessionDefunt(decesRequest.getProfessionDefunt());
			defunt.setAdresseDefunt(decesRequest.getAdresseDefunt());
			defunt.setDateDeces(decesRequest.getDateDeces());
			defunt.setLieuDeces(decesRequest.getLieuDeces());
			defunt.setHeureDeces(decesRequest.getHeureDeces());
			defuntRepository.save(defunt);
			
			pieceDeces.setNomPiece(decesRequest.isNomPiece());
			pieceDecesRepository.save(pieceDeces);
			
			//acteDeces.setIdActeDeces(decesRequest.getIdActeDeces());
			acteDeces.setDateDeclaration(decesRequest.getDateDeclaration());
			acteDeces.setHeureDeclaration(decesRequest.getHeureDeclaration());
			acteDeces.setNomDeclarant(decesRequest.getNomDeclarant());
			acteDeces.setPrenomsDeclarant(decesRequest.getPrenomsDeclarant());
			acteDeces.setProfessionDeclarant(decesRequest.getProfessionDeclarant());
			acteDeces.setLieuNaissanceDeclarant(decesRequest.getLieuNaissanceDeclarant());
			acteDeces.setAdresseDeclarant(decesRequest.getAdresseDeclarant());
			acteDeces.setDateNaissanceDeclarant(decesRequest.getDateNaissanceDeclarant());
			acteDeces.setDate(decesRequest.getDate());
			acteDeces.setMaire(maire);
			acteDeces.setDefunt(defunt);
			acteDeces.setPieceDeces(pieceDeces);
			acteDeces.setPremierCopie(premierCopie);
			
			acteDecesRepository.save(acteDeces);
			return new ResponseEntity<>(acteDeces, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
			
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>  supprActeDeces(@PathVariable("id") long idActeDeces)
	{
		try {
			ActeDeces acteDeces = acteDecesRepository.findById(idActeDeces).get();
			Defunt defunt = acteDeces.getDefunt();
			PieceDeces pieceDeces = acteDeces.getPieceDeces();
			
			acteDecesRepository.delete(acteDeces);
			defuntRepository.delete(defunt);
			pieceDecesRepository.delete(pieceDeces);
			
			 return new ResponseEntity<>(HttpStatus.OK);
			
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
