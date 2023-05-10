package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.output.Acte;
import com.example.demo.output.Naissance;
import com.example.demo.repository.ActeDecesRepository;
import com.example.demo.repository.AdoptionRepository;
import com.example.demo.repository.JugementRepository;
import com.example.demo.repository.MariageRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.repository.ReconnaissanceRepository;

@Service
public class StatistiqueService {
	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	ActeDecesRepository acteDecesRepository;
	@Autowired
	MariageRepository mariageRepository;
	@Autowired
	AdoptionRepository adoptionRepository;
	@Autowired
	JugementRepository jugementRepository;
	@Autowired
	ReconnaissanceRepository reconnaissanceRepository;
	
	static final long price = 2000 ;
	
	public Acte statistiqueacte()
	{
		Acte acte = new Acte();
		
		long nbrActeNaissance = premierCopieRepository.countByIdPC();
		long nbrActeDeces = acteDecesRepository.countByIdDeces();
		long nbrActeMariage = mariageRepository.countByIdMariage();
		
		long priceActenaissance = nbrActeNaissance * price ;
		long priceActedeces = nbrActeDeces * price ;
		long priceActemariage = nbrActeMariage * price ;
		
		acte.setNbrActeNaissance(nbrActeNaissance);
		acte.setNbrActeDeces(nbrActeDeces);
		acte.setNbrActeMariage(nbrActeMariage);
		acte.setPriceActeNaissance(priceActenaissance);
		acte.setPriceActeDeces(priceActedeces);
		acte.setNbrActeMariage(priceActemariage);
		
		return acte;
	}
	
	public Naissance statistiqueNaissance()
	{
		Naissance naissance = new Naissance();
		
		long nbrPremierCopie = premierCopieRepository.countByIdPC();
		long nbrAdoption = adoptionRepository.countByIdAdoption();
		long nbrJugement = jugementRepository.countByIdJugement();
		long nbrReconnaissance = reconnaissanceRepository.countByIdReconnaissance();
		
		naissance.setNbrPremierCopie(nbrPremierCopie);
		naissance.setNbrAdoption(nbrAdoption);
		naissance.setNbrJugement(nbrJugement);
		naissance.setNbrReconnaissance(nbrReconnaissance);
		
		return naissance;
	}
	

}
