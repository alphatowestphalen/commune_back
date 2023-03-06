package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Femme;
import com.example.demo.model.Homme;
import com.example.demo.model.Maire;
import com.example.demo.model.Mariage;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.Temoin;
import com.example.demo.repository.FemmeRepository;
import com.example.demo.repository.HommeRepository;
import com.example.demo.repository.MaireRepository;
import com.example.demo.repository.MariageRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.repository.TemoinRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.request.MariageRequest;
import com.example.demo.request.NumeroMariageRequest;
import com.example.demo.service.MariageService;
import com.fasterxml.jackson.annotation.JsonFormat;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/mariages")
public class MariageController {
	
	@Autowired
	MariageRepository mariageRepository;
	@Autowired
	HommeRepository hommeRepository;
	@Autowired
	FemmeRepository femmeRepository;
	@Autowired
	TemoinRepository temoinRepository;
	@Autowired
	MaireRepository maireRepository;
	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired(required = false) 
	TypeRepository typeRepository;
	@Autowired
	MariageService mariageService;
	
	@PostMapping("/{IdPremierCopie}/")
	public ResponseEntity<Mariage> createMariageMixte (@PathVariable(value = "IdPremierCopie") String IdPremierCopie,@RequestBody @Valid MariageRequest mariageRequest)
	{
		try {
		NumeroMariageRequest numeroActeMariage =  mariageService.numeroMariage();
			
		PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
			
		Maire maire = maireRepository.findById(mariageRequest.getIdMaire()).get();
		
		Temoin temoinHomme = new Temoin(
				mariageRequest.getNomTemoinHomme(),
				mariageRequest.getPrenomsTemoinHomme(),
				mariageRequest.getProfessionTemoinHomme(),
				mariageRequest.getDatenaissTemoinHomme(),
				mariageRequest.getLieunaissTemoinHomme(),
				mariageRequest.getAdresseTemoinHomme());
		temoinRepository.save(temoinHomme);
		
		Temoin temoinFemme = new Temoin(
				mariageRequest.getNomTemoinFemme(),
				mariageRequest.getPrenomsTemoinFemme(),
				mariageRequest.getProfessionTemoinFemme(),
				mariageRequest.getDatenaissTemoinFemme(),
				mariageRequest.getLieunaissTemoinFemme(),
				mariageRequest.getAdresseTemoinFemme());
		temoinRepository.save(temoinFemme);
		
		Homme homme = new Homme(
				mariageRequest.getNationaliteHomme(),
				mariageRequest.getNomHomme(),
				mariageRequest.getPrenomsHomme(),
				mariageRequest.getProfessionHomme(),
				mariageRequest.getDatenaissHomme(),
				mariageRequest.getLieunaissHomme(),
				mariageRequest.getAdresseHomme(),
				mariageRequest.getTypeHomme(),
				mariageRequest.getIdPereHomme(),
				mariageRequest.getIdMereHomme(),
				temoinHomme
				
				);
		hommeRepository.save(homme);
		
		Femme femme = new Femme(
				mariageRequest.getNationaliteFemme(),
				mariageRequest.getNomFemme(),
				mariageRequest.getPrenomsFemme(),
				mariageRequest.getProfessionFemme(),
				mariageRequest.getDatenaissFemme(),
				mariageRequest.getLieunaissFemme(),
				mariageRequest.getAdresseFemme(),
				mariageRequest.getTypeFemme(),
				mariageRequest.getIdPereFemme(),
				mariageRequest.getIdMereFemme(),
				temoinFemme
				);
		femmeRepository.save(femme);
		
		Mariage mariage = mariageService.ajoutMariageMixte(
				numeroActeMariage.idMariage,
				mariageRequest.getDescription(),
				mariageRequest.getDateMariage(), 
				mariageRequest.getHeureMariage(),
				homme,
				femme,
				maire,
				mariageRequest.getCreatedDate(),
				numeroActeMariage.numero,
				numeroActeMariage.annee,
				premierCopie);
		
		return new ResponseEntity<>(mariage, HttpStatus.OK);
		
	} catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	

}
