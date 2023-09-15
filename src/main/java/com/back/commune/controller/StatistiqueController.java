package com.back.commune.controller;

import com.back.commune.DTO.Statistique;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.commune.service.StatistiqueService;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/statistiques")
public class StatistiqueController {

    private final StatistiqueService statistiqueService;


	@GetMapping
    public ResponseEntity<Statistique> getStatistique() {
        return ResponseEntity.ok().body(statistiqueService.getStatistique());
    }
}
