package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ActeDeces;
import com.example.demo.repository.ActeDecesRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.request.NumeroActeDecesRequest;

@Service
public class ActeDecesService {

	@Autowired(required = false)
	TypeRepository typeRepository;
	@Autowired
	ActeDecesRepository acteDecesRepository;
	
	public NumeroActeDecesRequest numeroActeDeces()
	{
		NumeroActeDecesRequest numActeDeces = new NumeroActeDecesRequest();
		
		ActeDeces deces =  acteDecesRepository.chercherActeDeces();
		int currentYear = typeRepository.year;
		
		if(deces != null)
		{
			long num = deces.getNumero();
			int annee = deces.getAnnee();
			
			
			if(annee == currentYear)
			{
				long numero = num + 1;
				String idActeDeces = Long.toString(numero).concat(Integer.toString(annee));
				numActeDeces.idActeDeces = idActeDeces;
				numActeDeces.annee = annee;
				numActeDeces.numero = numero;
				
				return numActeDeces;
			}
			num = 1;
			annee = currentYear;
			String idActeDeces = Long.toString(num).concat(Integer.toString(annee));
			numActeDeces.idActeDeces = idActeDeces;
			numActeDeces.annee = annee;
			numActeDeces.numero = num;
			
			return numActeDeces;
			}
		else
		{
			long numero = 1;
			int annee = currentYear;
			String idActeDeces = Long.toString(numero).concat(Integer.toString(annee));
			numActeDeces.idActeDeces = idActeDeces;
			numActeDeces.annee = annee;
			numActeDeces.numero = numero;
			
			return numActeDeces;
		}
	}
}
