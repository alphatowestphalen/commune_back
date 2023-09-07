package com.example.demo.service;

import com.example.demo.exceptions.NotFoundDataException;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.ActeCelibataireRequest;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.ActeCelibataire;
import com.example.demo.repository.ActeCelibataireRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.request.NumeroActeCelibataire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActeCelibataireService {

	@Autowired
	ActeCelibataireRepository acteCelibataireRepository;
	@Autowired(required = false)
	TypeRepository typeRepository;
    @Autowired
    PremierCopieRepository premierCopieRepository;

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

    public ActeCelibataire save(ActeCelibataireRequest acteCelibataireRequest, String IdPremierCopie) {
        NumeroActeCelibataire numeroActeCelibataire = numeroActeCelibataire();
        PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
        ActeCelibataire acteCelibataire = new ActeCelibataire(
            numeroActeCelibataire.idActeCelibataire,
            acteCelibataireRequest.getNomFkt(),
            acteCelibataireRequest.getNumCin(),
            acteCelibataireRequest.getDateCin(),
            acteCelibataireRequest.getLieuCin(),
            acteCelibataireRequest.getDateActe(),
            premierCopie,
            numeroActeCelibataire.numero,
            numeroActeCelibataire.annee,
            acteCelibataireRequest.getCreatedDate()
        );

        return acteCelibataireRepository.save(acteCelibataire);
    }


    public void delete(String id) {
        acteCelibataireRepository.deleteById(id);
    }

    public ActeCelibataire update(ActeCelibataireRequest acteCelibataireRequest, String id) {
        ActeCelibataire acteCelibataire = acteCelibataireRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundDataException("Not found Jugement with id = " + id));;

        PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(acteCelibataire.getPremierecopie().getIdPremierCopie());

        acteCelibataire.setNomFkt(acteCelibataireRequest.getNomFkt());
        acteCelibataire.setNumCin(acteCelibataireRequest.getNumCin());
        acteCelibataire.setDateCin(acteCelibataireRequest.getDateCin());
        acteCelibataire.setLieuCin(acteCelibataireRequest.getLieuCin());
        acteCelibataire.setDateActe(acteCelibataireRequest.getDateActe());
        acteCelibataire.setPremierecopie(premierCopie);

        return acteCelibataireRepository.save(acteCelibataire);
    }

    public ActeCelibataire find(String id) {
       return acteCelibataireRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundDataException("Not found Jugement with id = " + id));
    }

    public ResponsePageable<ActeCelibataire> findAll(Pageable pageable) {
        Page<ActeCelibataire> pageactecelibataire = acteCelibataireRepository.findAll(pageable);
        return new ResponsePageable<>(pageactecelibataire);
    }
}
