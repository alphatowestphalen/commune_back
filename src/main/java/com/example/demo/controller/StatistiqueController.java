package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.output.Acte;
import com.example.demo.output.Naissance;
import com.example.demo.service.StatistiqueService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/statistiques")
public class StatistiqueController {

	@Autowired
	StatistiqueService statistiqueService;
	
	@GetMapping
	public Acte getActe()
	{
		Acte acte = statistiqueService.statistiqueacte();
		
		return acte;
	}
	
	@GetMapping("/naissance")
	public Naissance getStatistiqueNaissance()
	{
		Naissance naissance = statistiqueService.statistiqueNaissance();
		
		return naissance;
	}
}
