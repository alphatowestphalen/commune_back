package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ActeCelibataire;
import com.example.demo.repository.ActeCelibataireRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.request.NumeroActeCelibataire;

@Service
public class ActeCelibataireService {

	@Autowired
	ActeCelibataireRepository acteCelibataireRepository;
	@Autowired(required = false)
	TypeRepository typeRepository;

	public NumeroActeCelibataire numeroActeCelibataire()
	{
		NumeroActeCelibataire numeroActeCelibataire = new NumeroActeCelibataire();

		ActeCelibataire acteCelibataire =  acteCelibataireRepository.chercherActeCelibataire();

		int currentYear = typeRepository.year;

		if (acteCelibataire != null) {
			long num = acteCelibataire.getNumero();
			int annee = acteCelibataire.getAnnee();
			/*
			long num = premierCopieRepository.chercherNumeroCopie();
			int annee = premierCopieRepository.chercherAnneeCopie();
			*/
			if(annee == currentYear)
			{
				long numero = num + 1;
				String idActeCelibataire = Long.toString(numero).concat(Integer.toString(annee));
				numeroActeCelibataire.idActeCelibataire = idActeCelibataire;
				numeroActeCelibataire.annee = annee;
				numeroActeCelibataire.numero = numero;

				return numeroActeCelibataire;
			}

				num = 1;
				annee = currentYear;
				String idActeCelibataire = Long.toString(num).concat(Integer.toString(annee));
				numeroActeCelibataire.idActeCelibataire = idActeCelibataire;
				numeroActeCelibataire.annee = annee;
				numeroActeCelibataire.numero = num;

				return numeroActeCelibataire;
		}
		else
		{
			long num = 1;
			int annee = currentYear;
			String idActeCelibataire = Long.toString(num).concat(Integer.toString(annee));
			numeroActeCelibataire.idActeCelibataire = idActeCelibataire;
			numeroActeCelibataire.annee = annee;
			numeroActeCelibataire.numero = num;

			return numeroActeCelibataire;

		}

	}

    public void save(ActeCelibataire acteCelibataire) {
    	acteCelibataireRepository.save(acteCelibataire);
    }


}
