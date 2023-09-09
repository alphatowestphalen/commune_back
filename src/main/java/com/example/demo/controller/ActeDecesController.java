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
import com.example.demo.repository.TypeRepository;
import com.example.demo.request.DecesRequest;
import com.example.demo.request.NumeroActeDecesRequest;
import com.example.demo.request.ReconnaissanceRequest;
import com.example.demo.service.ActeDecesService;
import com.example.demo.service.PremierCopieService;

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
	@Autowired(required = false)
	TypeRepository typeRepository;
	@Autowired
	ActeDecesService acteDecesService;
	@Autowired
	PremierCopieService premierCopieService;


	@PostMapping("/{IdPremierCopie}")
	  public ResponseEntity<ActeDeces> addDeces(@PathVariable(value = "IdPremierCopie") String IdPremierCopie, @RequestBody DecesRequest decesRequest)
	{
        ActeDeces actedeces = acteDecesService.save(decesRequest, IdPremierCopie);
        return new ResponseEntity<>(actedeces, HttpStatus.OK);
	}

	@GetMapping
	  public ResponseEntity<List<ActeDeces>> getAllActeDeces() {
        List<ActeDeces> acte = acteDecesRepository.findAll();
	    if (acte.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(acte, HttpStatus.OK);
	  }


	@GetMapping("/{id}")
	  public ResponseEntity<ActeDeces> getActeDecesById(@PathVariable(value = "id") String id) {
		ActeDeces acte = acteDecesRepository.findByIdActeDeces(id);
	    return new ResponseEntity<>(acte, HttpStatus.OK);
	  }

	@PutMapping("/{id}")
	public ResponseEntity<ActeDeces> updateActeDeces(@PathVariable(value = "id") String id, @RequestBody DecesRequest decesRequest)
	{
        ActeDeces acteDeces = acteDecesRepository.findByIdActeDeces(id);

        PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(acteDeces.getPremierCopie().getIdPremierCopie());
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

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>  supprActeDeces(@PathVariable("id") String idActeDeces)
	{
        ActeDeces acteDeces = acteDecesRepository.findByIdActeDeces(idActeDeces);
        Defunt defunt = acteDeces.getDefunt();
        PieceDeces pieceDeces = acteDeces.getPieceDeces();

        acteDecesRepository.delete(acteDeces);
        defuntRepository.delete(defunt);
        pieceDecesRepository.delete(pieceDeces);

        return new ResponseEntity<>(HttpStatus.OK);
	}
}
