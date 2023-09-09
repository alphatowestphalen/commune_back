package com.example.demo.controller;

import java.util.Map;

import com.example.demo.service.AdoptionService;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.model.Adoption;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.AdoptionRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.AdoptionRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/adoptions")
public class AdoptionController {
	PremierCopieRepository premierCopieRepository;
	AdoptionRepository adoptionRepository;

    private final AdoptionService adoptionService;

    @Autowired
    public AdoptionController(PremierCopieRepository premierCopieRepository, AdoptionRepository adoptionRepository, AdoptionService adoptionService) {
        this.premierCopieRepository = premierCopieRepository;
        this.adoptionRepository = adoptionRepository;
        this.adoptionService = adoptionService;
    }

    @GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<ResponsePageable<Adoption>> getAllAdoptions(
                @RequestParam(defaultValue = "1") int page,
                @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page-1, size);
        ResponsePageable<Adoption> response = adoptionService.getAll(pageable);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

	@GetMapping("/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<Adoption> getAdoptionById(@PathVariable(value = "id") Long id) {
        Adoption adoption = adoptionService.getById(id);
        return new ResponseEntity<>(adoption,HttpStatus.OK);
    }

	@PostMapping()
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<Adoption> addAdoption(@RequestBody AdoptionRequest adoptionRequest)
	{
		Adoption adoption = adoptionService.save(adoptionRequest);
        return new ResponseEntity<>(adoption,HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	//@PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<Adoption> updateAdoption(@PathVariable(value = "id") Long id, @RequestBody AdoptionRequest adoptionRequest)
	{
		Adoption adoption = adoptionService.update(id,adoptionRequest);
        return new ResponseEntity<>(adoption,HttpStatus.CREATED);
    }


	@DeleteMapping("/{id}")
//	 @PreAuthorize(" hasRole('MAIRE')")
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
