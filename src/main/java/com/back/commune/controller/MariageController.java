package com.back.commune.controller;

import com.back.commune.model.mariage.Mariage;
import com.back.commune.request.MariageEERequest;
import com.back.commune.request.MariageEIRequest;
import com.back.commune.request.MariageIERequest;
import com.back.commune.request.MariageIIRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.back.commune.service.MariageService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/mariages")
public class MariageController {
    private final MariageService mariageService;

    public MariageController(MariageService mariageService) {
        this.mariageService = mariageService;
    }

    @PostMapping("/interne-interne")
    public Mariage saveMariage(@RequestBody MariageIIRequest request){
        return mariageService.saveMariageII(request);
    }
    @PostMapping("/externe-externe")
    public Mariage saveMariage(@RequestBody MariageEERequest request){
        return mariageService.saveMariageEE(request);
    }

    @PostMapping("/interne-externe")
    public Mariage saveMariage(@RequestBody MariageIERequest request){
        return mariageService.saveMariageIE(request);
    }

    @PostMapping("/externe-interne")
    public Mariage saveMariage(@RequestBody MariageEIRequest request){
        return mariageService.saveMariageEI(request);
    }

    @GetMapping
    public ResponseEntity<List<Mariage>> getAllMariages(){
        return ResponseEntity.ok(mariageService.getAllMariages());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMariage(@PathVariable("id") Long id){
        mariageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mariage> getMariage(@PathVariable String id){
        System.out.println(id);
        Mariage mariage =  mariageService.findById(Long.parseLong(id));
        return new ResponseEntity<>(mariage,HttpStatus.OK);
    }
}
