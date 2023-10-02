package com.back.commune.controller;

import com.back.commune.model.Reconnaissance;
import com.back.commune.service.ReconnaissanceService;
import com.back.commune.request.ReconnaissanceRequest;
import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reconnaissances")
public class ReconnaissanceController {
    private final ReconnaissanceService reconnaissanceService;
    @Autowired
    public ReconnaissanceController(ReconnaissanceService reconnaissanceService) {
        this.reconnaissanceService = reconnaissanceService;
    }

    @GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<ResponsePageable<Reconnaissance>> getAllReconnaissances(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam()Optional<String> q,
        @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page-1, size);
        ResponsePageable<Reconnaissance> response;

        if(q.isPresent() && !q.get().trim().isEmpty()){
            response = reconnaissanceService.getSearchAll(q.get().trim(), pageable);
        }else{
            response = reconnaissanceService.getAll(pageable);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@GetMapping("/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<Reconnaissance> getReconnaissanceById(@PathVariable(value = "id") Long id) {
		Reconnaissance reconnaissance = reconnaissanceService.findById(id);
	    return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
    }

	@PostMapping()
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Reconnaissance> addReconnaissance(@RequestBody ReconnaissanceRequest reconnaissanceRequest)
	{
        Reconnaissance reconnaissance = reconnaissanceService.save(reconnaissanceRequest);
        return new ResponseEntity<>(reconnaissance, HttpStatus.CREATED);
	}


	@PutMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<Reconnaissance> updateReconnaissance(@PathVariable(value = "id") Long id, @RequestBody ReconnaissanceRequest reconnaissanceRequest)
	{
        Reconnaissance reconnaissance = reconnaissanceService.update(id, reconnaissanceRequest);
		return new ResponseEntity<>(reconnaissance, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
    public ResponseEntity<HttpStatus> deleteReconnaissance(@PathVariable("id") long id) {
        reconnaissanceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
