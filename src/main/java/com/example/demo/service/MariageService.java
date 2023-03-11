package com.example.demo.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Femme;
import com.example.demo.model.Homme;
import com.example.demo.model.Maire;
import com.example.demo.model.Mariage;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.MariageRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.request.NumeroMariageRequest;

@Service
public class MariageService {

	@Autowired(required = false)
	TypeRepository typeRepository;
	@Autowired
	MariageRepository mariageRepository;
	
	public NumeroMariageRequest numeroMariage()
	{
		NumeroMariageRequest numeroMariage = new NumeroMariageRequest();
		
		Mariage mariage = mariageRepository.chercherMariage();
		int currentYear = typeRepository.year;
		
		if(mariage != null)
		{
			long num = mariage.getNumero();
			int annee = mariage.getAnnee();
			
			
			if(annee == currentYear)
			{
				long numero = num + 1;
				String idMariage = Long.toString(numero).concat(Integer.toString(annee));
				numeroMariage.idMariage = idMariage;
				numeroMariage.annee = annee;
				numeroMariage.numero = numero;
				
				return numeroMariage;
			}
			num = 1;
			annee = currentYear;
			String idMariage = Long.toString(num).concat(Integer.toString(annee));
			numeroMariage.idMariage = idMariage;
			numeroMariage.annee = annee;
			numeroMariage.numero = num;
			
			return numeroMariage;
			
			}
		else
		{
			long numero = 1;
			int annee = currentYear;
			String idMariage = Long.toString(numero).concat(Integer.toString(annee));
			numeroMariage.idMariage = idMariage;
			numeroMariage.annee = annee;
			numeroMariage.numero = numero;
			
			return numeroMariage;
		}
	}
	
	public Mariage ajoutMariageMixte(String idMariage, String description, String dateMariage, ArrayList<String> type, String heureMariage ,Homme homme,
			Femme femme, Maire maire, Instant createdDate, long numero, int annee , List<PremierCopie> premierCopie)
	{
		Mariage mariage = new Mariage(
				idMariage,
				description,
				dateMariage,
				type,
				heureMariage,
				homme,
				femme,
				maire,
				createdDate,
				numero,
				annee,
				premierCopie);
		
		mariageRepository.save(mariage);
		
		return mariage;
	}
}
