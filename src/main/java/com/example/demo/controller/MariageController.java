package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Femme;
import com.example.demo.model.Homme;
import com.example.demo.model.Maire;
import com.example.demo.model.Mariage;
import com.example.demo.model.Mere;
import com.example.demo.model.Pere;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.Temoin;
import com.example.demo.repository.FemmeRepository;
import com.example.demo.repository.HommeRepository;
import com.example.demo.repository.MaireRepository;
import com.example.demo.repository.MariageRepository;
import com.example.demo.repository.MereRepository;
import com.example.demo.repository.PereRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.repository.TemoinRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.request.MariageRequest;
import com.example.demo.request.NumeroMariageRequest;
import com.example.demo.service.MariageService;
import com.fasterxml.jackson.annotation.JsonFormat;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

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
	@Autowired
	PereRepository pereRepository;
	@Autowired
	MereRepository mereRepository;

	@PostMapping("/{typeHomme}/{typeFemme}")
	public ResponseEntity<Mariage> createMariageMixte(@PathVariable(value = "typeHomme") String typeHomme,
			@PathVariable(value = "typeFemme") String typeFemme, @RequestBody @Valid MariageRequest mariageRequest) {
		try {
			if (typeHomme.equals("interne") && typeFemme.equals("interne")) {
				NumeroMariageRequest numeroActeMariage = mariageService.numeroMariage();

				PremierCopie premierCopieHomme = premierCopieRepository
						.findByIdPremierCopie(mariageRequest.getIdPremierCopieHomme());

				PremierCopie premierCopieFemme = premierCopieRepository
						.findByIdPremierCopie(mariageRequest.getIdPremierCopieFemme());

				Maire maire = maireRepository.findById(mariageRequest.getIdMaire()).get();

				Pere pereHomme = pereRepository.findById(mariageRequest.getIdPereHomme()).get();

				Pere pereFemme = pereRepository.findById(mariageRequest.getIdPereFemme()).get();

				Mere mereHomme = mereRepository.findById(mariageRequest.getIdMereHomme()).get();

				Mere mereFemme = mereRepository.findById(mariageRequest.getIdMereFemme()).get();

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
						mereHomme,
						pereHomme,
						temoinHomme,
						premierCopieHomme);
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
						mereFemme,
						pereFemme,
						temoinFemme,
						premierCopieFemme);
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
						numeroActeMariage.annee);

				return new ResponseEntity<>(mariage, HttpStatus.OK);

			}

			else if (typeHomme.equals("externe") && typeFemme.equals("interne")) {

				NumeroMariageRequest numeroActeMariage = mariageService.numeroMariage();

				PremierCopie premierCopieHomme = null;

				PremierCopie premierCopieFemme = premierCopieRepository
						.findByIdPremierCopie(mariageRequest.getIdPremierCopieFemme());

				Maire maire = maireRepository.findById(mariageRequest.getIdMaire()).get();

				Pere pereHomme = new Pere(
						mariageRequest.getNomPere(),
						mariageRequest.getPrenomsPere(),
						mariageRequest.getDatenaissPere(),
						mariageRequest.getLieuNaissPere(),
						mariageRequest.getAdressPere(),
						mariageRequest.getProfessionPere());

				pereRepository.save(pereHomme);

				Mere mereHomme = new Mere(
						mariageRequest.getNomMere(),
						mariageRequest.getPrenomsMere(),
						mariageRequest.getDatenaissMere(),
						mariageRequest.getLieunaissMere(),
						mariageRequest.getAdresseMere(),
						mariageRequest.getProfessionMere()

				);
				mereRepository.save(mereHomme);

				Pere pereFemme = pereRepository.findById(mariageRequest.getIdPereFemme()).get();

				Mere mereFemme = mereRepository.findById(mariageRequest.getIdMereFemme()).get();

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
						mereHomme,
						pereHomme,
						temoinHomme,
						premierCopieHomme);
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
						mereFemme,
						pereFemme,
						temoinFemme,
						premierCopieFemme);
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
						numeroActeMariage.annee);

				return new ResponseEntity<>(mariage, HttpStatus.OK);
			} else if (typeHomme.equals("interne") && typeFemme.equals("externe")) {

				NumeroMariageRequest numeroActeMariage = mariageService.numeroMariage();

				PremierCopie premierCopieFemme = null;

				PremierCopie premierCopieHomme = premierCopieRepository
						.findByIdPremierCopie(mariageRequest.getIdPremierCopieHomme());

				Maire maire = maireRepository.findById(mariageRequest.getIdMaire()).get();

				Pere pereFemme = new Pere(
						mariageRequest.getNomPereFemme(),
						mariageRequest.getPrenomsPereFemme(),
						mariageRequest.getDatenaissPereFemme(),
						mariageRequest.getLieuNaissPereFemme(),
						mariageRequest.getAdressPereFemme(),
						mariageRequest.getProfessionPereFemme());

				pereRepository.save(pereFemme);

				Mere mereFemme = new Mere(
						mariageRequest.getNomMereFemme(),
						mariageRequest.getPrenomsMereFemme(),
						mariageRequest.getDatenaissMereFemme(),
						mariageRequest.getLieunaissMereFemme(),
						mariageRequest.getAdresseMereFemme(),
						mariageRequest.getProfessionMereFemme()

				);
				mereRepository.save(mereFemme);

				Pere pereHomme = pereRepository.findById(mariageRequest.getIdPereHomme()).get();

				Mere mereHomme = mereRepository.findById(mariageRequest.getIdMereHomme()).get();

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
						mereHomme,
						pereHomme,
						temoinHomme,
						premierCopieHomme);
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
						mereFemme,
						pereFemme,
						temoinFemme,
						premierCopieFemme);
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
						numeroActeMariage.annee);

				return new ResponseEntity<>(mariage, HttpStatus.OK);

			} else {
				NumeroMariageRequest numeroActeMariage = mariageService.numeroMariage();

				PremierCopie premierCopieHomme = null;

				PremierCopie premierCopieFemme = null;

				Maire maire = maireRepository.findById(mariageRequest.getIdMaire()).get();

				Pere pereHomme = new Pere(
						mariageRequest.getNomPere(),
						mariageRequest.getPrenomsPere(),
						mariageRequest.getDatenaissPere(),
						mariageRequest.getLieuNaissPere(),
						mariageRequest.getAdressPere(),
						mariageRequest.getProfessionPere());

				pereRepository.save(pereHomme);

				Mere mereHomme = new Mere(
						mariageRequest.getNomMere(),
						mariageRequest.getPrenomsMere(),
						mariageRequest.getDatenaissMere(),
						mariageRequest.getLieunaissMere(),
						mariageRequest.getAdresseMere(),
						mariageRequest.getProfessionMere()

				);
				mereRepository.save(mereHomme);

				Pere pereFemme = new Pere(
						mariageRequest.getNomPereFemme(),
						mariageRequest.getPrenomsPereFemme(),
						mariageRequest.getDatenaissPereFemme(),
						mariageRequest.getLieuNaissPereFemme(),
						mariageRequest.getAdressPereFemme(),
						mariageRequest.getProfessionPereFemme());

				pereRepository.save(pereFemme);

				Mere mereFemme = new Mere(
						mariageRequest.getNomMereFemme(),
						mariageRequest.getPrenomsMereFemme(),
						mariageRequest.getDatenaissMereFemme(),
						mariageRequest.getLieunaissMereFemme(),
						mariageRequest.getAdresseMereFemme(),
						mariageRequest.getProfessionMereFemme()

				);
				mereRepository.save(mereFemme);

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
						mereHomme,
						pereHomme,
						temoinHomme,
						premierCopieHomme);
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
						mereFemme,
						pereFemme,
						temoinFemme,
						premierCopieFemme);
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
						numeroActeMariage.annee);

				return new ResponseEntity<>(mariage, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping()
	public ResponseEntity<Map<String, Object>> getAllMariage(
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "10") int size
	){
		try {
	        List<Mariage> mariageList = new ArrayList<Mariage>();
	        Pageable paging = PageRequest.of(page, size);
	        
	        Page<Mariage> listmariage;
	        listmariage = mariageRepository.findAll(paging);
	        	
	        	mariageList = listmariage.getContent();

	             Map<String, Object> response = new HashMap<>();
	             response.put("mariges", mariageList);
	             response.put("currentPage", listmariage.getNumber());
	             response.put("length", listmariage.getTotalElements());
	             response.put("totalPages", listmariage.getTotalPages());
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }




	}
}
