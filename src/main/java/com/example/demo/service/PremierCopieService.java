package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PremierCopie;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.request.NumeroRequest;

@Service
public class PremierCopieService {

	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired(required = false)
	TypeRepository typeRepository;
	
	public NumeroRequest numeroCopie()
	{
		NumeroRequest numeroRequest = new NumeroRequest();
		
		PremierCopie pc = premierCopieRepository.chercherPremierCopie();
		int currentYear = typeRepository.year;
		
		if(pc != null)
		{
			long num = pc.getNumero();
			int annee = pc.getAnneeActuelle();
			
			if(annee == currentYear)
			{			
				long numero = num + 1;
				String IdPremierCopie = Long.toString(numero).concat(Integer.toString(annee));						
				numeroRequest.idPremierCopie = IdPremierCopie;
				numeroRequest.annee = annee;
				numeroRequest.numero = numero;
				
				return numeroRequest;
			}
			
				num = 1;
				annee = currentYear;	
				String IdPremierCopie = Long.toString(num).concat(Integer.toString(annee));
				numeroRequest.idPremierCopie = IdPremierCopie;
				numeroRequest.annee = annee;
				numeroRequest.numero = num;
				
				return numeroRequest;
		}
		else 
		{
			long num = 1;
			int annee = currentYear;
			String IdPremierCopie = Long.toString(num).concat(Integer.toString(annee));
			numeroRequest.idPremierCopie = IdPremierCopie;
			numeroRequest.annee = annee;
			numeroRequest.numero = num;
			
			return numeroRequest;
			
		}
		
	}
}
