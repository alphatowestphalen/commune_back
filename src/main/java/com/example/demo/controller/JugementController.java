package com.example.demo.controller;

import java.util.Map;

import com.example.demo.service.JugementService;
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


import com.example.demo.model.Jugement;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.JugementRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.JugementRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jugements")
public class JugementController {

    private final JugementService jugementService;

    @Autowired
    public JugementController(JugementService jugementService) {
        this.jugementService = jugementService;
    }

    @GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<ResponsePageable<Jugement>> getAllJugements(
		        @RequestParam(defaultValue = "1") int page,
		        @RequestParam(defaultValue = "10") int size) {

        Pageable paging = PageRequest.of(page-1, size);
        ResponsePageable<Jugement> response = jugementService.getAll(paging);
        return new ResponseEntity<> (response, HttpStatus.OK);
    }

	@GetMapping("/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<Jugement> getJugementById(@PathVariable(value = "id") Long id) {
        Jugement jugement = jugementService.findById(id);
	    return new ResponseEntity<>(jugement, HttpStatus.OK);
    }

	@PostMapping()
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Jugement> addJugement(@RequestBody JugementRequest jugementRequest)
	{
        Jugement jugement = jugementService.save(jugementRequest);
        return new ResponseEntity<>(jugement, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<Jugement> updateJugement(@PathVariable(value = "id") Long id,
			@RequestBody JugementRequest jugementRequest)
	{
        Jugement jugement = jugementService.update(id, jugementRequest);
		return new ResponseEntity<>(jugement, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	  public ResponseEntity<HttpStatus> deleteJugement(@PathVariable("id") long id)
	{
        jugementService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
