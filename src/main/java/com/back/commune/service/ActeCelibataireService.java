package com.back.commune.service;

import com.back.commune.DTO.ActeCelibataireDTO;
import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.PremierCopie;
import com.back.commune.repository.ActeCelibataireRepository;
import com.back.commune.repository.PremierCopieRepository;
import com.back.commune.repository.TypeRepository;
import com.back.commune.request.ActeCelibataireRequest;
import com.back.commune.request.NumeroActeCelibataire;
import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.back.commune.model.ActeCelibataire;

import java.util.List;

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

    public ActeCelibataireDTO save(ActeCelibataireRequest acteCelibataireRequest) {
        NumeroActeCelibataire numeroActeCelibataire = numeroActeCelibataire();
        PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(acteCelibataireRequest.getIdPremierCopie());
        if(premierCopie == null) throw new NotFoundDataException("Not found PremierCopie with id = " + acteCelibataireRequest.getIdPremierCopie());
        ActeCelibataire acteCelibataire = new ActeCelibataire(
            numeroActeCelibataire.idActeCelibataire,
            acteCelibataireRequest.getNomFkt(),
            acteCelibataireRequest.getChefFkt(),
            acteCelibataireRequest.getNumCin(),
            acteCelibataireRequest.getDateCin(),
            acteCelibataireRequest.getLieuCin(),
            acteCelibataireRequest.getDateActe(),
            premierCopie,
            numeroActeCelibataire.numero,
            numeroActeCelibataire.annee
        );
        return new ActeCelibataireDTO(acteCelibataireRepository.save(acteCelibataire));
    }


    public void delete(String id) {
        acteCelibataireRepository.deleteById(id);
    }

    public ActeCelibataireDTO update(ActeCelibataireRequest acteCelibataireRequest, String id) {
        ActeCelibataire acteCelibataire = acteCelibataireRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundDataException("Not found Jugement with id = " + id));;

        PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(acteCelibataire.getPremierecopie().getIdPremierCopie());

        acteCelibataire.setNomFkt(acteCelibataireRequest.getNomFkt());
        acteCelibataire.setChefFkt(acteCelibataireRequest.getChefFkt());
        acteCelibataire.setNumCin(acteCelibataireRequest.getNumCin());
        acteCelibataire.setDateCin(acteCelibataireRequest.getDateCin());
        acteCelibataire.setLieuCin(acteCelibataireRequest.getLieuCin());
        acteCelibataire.setDateActe(acteCelibataireRequest.getDateActe());
        acteCelibataire.setPremierecopie(premierCopie);

        return new ActeCelibataireDTO(acteCelibataireRepository.save(acteCelibataire));
    }

    public ActeCelibataireDTO find(String id) {
       ActeCelibataire acteCelibataire =  acteCelibataireRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundDataException("Not found ActeCellibataire with id = " + id));
        return new ActeCelibataireDTO(acteCelibataire);
    }
    public ResponsePageable<ActeCelibataireDTO> findAll(Pageable pageable) {
        Page<ActeCelibataire> resultDB = acteCelibataireRepository.findAll(pageable);
        List<ActeCelibataireDTO> listDTO =  resultDB.getContent().
            stream().map(ActeCelibataireDTO::new).collect(java.util.stream.Collectors.toList());
        Page<ActeCelibataireDTO> page = new PageImpl<>(listDTO,pageable,resultDB.getTotalElements());
        return new ResponsePageable<>(page);
    }
}
