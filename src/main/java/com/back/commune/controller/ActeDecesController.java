package com.back.commune.controller;
import com.back.commune.DTO.ActeDeDecesDTO;
import com.back.commune.utils.ResponsePageable;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.commune.model.deces.ActeDeces;
import com.back.commune.request.DecesRequest;
import com.back.commune.service.ActeDecesService;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/deces")
@AllArgsConstructor
public class ActeDecesController {

    private final ActeDecesService acteDecesService;

	@PostMapping
	  public ResponseEntity<ActeDeDecesDTO> addDeces(@RequestBody DecesRequest decesRequest)
	{
        ActeDeDecesDTO acteDeDecesDTO = acteDecesService.save(decesRequest);
        return new ResponseEntity<>(acteDeDecesDTO, HttpStatus.OK);
	}

	@GetMapping
	  public ResponseEntity<ResponsePageable<ActeDeDecesDTO>> getAllActeDeces(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam() Optional<String> q,
        @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page-1, size);
        ResponsePageable<ActeDeDecesDTO> acteDeces;
        if(q.isPresent() && !q.get().trim().isEmpty()){
            acteDeces = acteDecesService.findAllSearch(q.get().trim() ,pageable);
        }else{
            acteDeces = acteDecesService.findAll(pageable);
        }

	    return new ResponseEntity<>(acteDeces, HttpStatus.OK);
	  }

	@GetMapping("/{id}")
	  public ResponseEntity<ActeDeDecesDTO> getActeDecesById(@PathVariable(value = "id") Long id) {
        ActeDeDecesDTO acte = acteDecesService.findById(id);
	    return new ResponseEntity<>(acte, HttpStatus.OK);
	  }

	@PutMapping("/{id}")
	public ResponseEntity<ActeDeces> updateActeDeces(
        @PathVariable(value = "id") Long id,
        @RequestBody DecesRequest decesRequest)
	{
        ActeDeces acteDeces = acteDecesService.update(id, decesRequest);
        return new ResponseEntity<>(acteDeces, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>  supprActeDeces(@PathVariable("id") Long idActeDeces)
	{
        acteDecesService.delete(idActeDeces);
        return new ResponseEntity<>(HttpStatus.OK);
	}
}
