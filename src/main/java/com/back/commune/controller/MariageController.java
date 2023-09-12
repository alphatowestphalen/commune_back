package com.back.commune.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.back.commune.model.mariage.Mariage;
import com.back.commune.repository.PremierCopieRepository;
import com.back.commune.repository.TypeRepository;
import com.back.commune.request.MariageRequest;
import com.back.commune.request.NumeroMariageRequest;
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

import com.back.commune.model.Femme;
import com.back.commune.model.Homme;
import com.back.commune.model.Maire;
import com.back.commune.model.Mere;
import com.back.commune.model.Pere;
import com.back.commune.model.PremierCopie;
import com.back.commune.model.Temoin;
import com.back.commune.repository.FemmeRepository;
import com.back.commune.repository.HommeRepository;
import com.back.commune.repository.MaireRepository;
import com.back.commune.repository.MariageRepository;
import com.back.commune.repository.MereRepository;
import com.back.commune.repository.PereRepository;
import com.back.commune.repository.TemoinRepository;
import com.back.commune.service.MariageService;

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
	             response.put("mariages", mariageList);
	             response.put("currentPage", listmariage.getNumber());
	             response.put("length", listmariage.getTotalElements());
	             response.put("totalPages", listmariage.getTotalPages());
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	@GetMapping("/{idMariage}")
	public  ResponseEntity<Mariage> getMariageById(@PathVariable("idMariage") String idMariage){

		try {
			Mariage mariage = mariageRepository.findByIdMariage(idMariage);
			return new ResponseEntity<Mariage>(mariage, null, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
