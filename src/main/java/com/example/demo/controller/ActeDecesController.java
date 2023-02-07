package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ActeDeces;
import com.example.demo.model.Defunt;
import com.example.demo.model.Maire;
import com.example.demo.model.PieceDeces;
import com.example.demo.repository.ActeDecesRepository;
import com.example.demo.repository.DefuntRepository;
import com.example.demo.repository.MaireRepository;
import com.example.demo.repository.PieceDecesRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.DecesRequest;

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
			ActeDeces deces = premierCopieRepository.findById(IdPremierCopie).map(premierCopie -> {
				
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
							decesRequest.getCreatedDate()
							);
					
					premierCopie.addDeces(actedeces);
					return acteDecesRepository.save(actedeces);
				
				
				
			}).orElseThrow(() -> new ResourceNotFoundException("Not found Premier Copie with id = " + IdPremierCopie));
		    return new ResponseEntity<>(deces, HttpStatus.CREATED);
			
		} catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
