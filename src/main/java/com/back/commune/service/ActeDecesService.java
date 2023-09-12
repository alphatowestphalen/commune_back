package com.back.commune.service;

import com.back.commune.model.*;
import com.back.commune.repository.TypeRepository;
import com.back.commune.repository.MaireRepository;
import com.back.commune.repository.PieceDecesRepository;
import com.back.commune.request.DecesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.commune.repository.ActeDecesRepository;
import com.back.commune.request.NumeroActeDecesRequest;

import javax.transaction.Transactional;

@Service
public class ActeDecesService {

	@Autowired(required = false)
    TypeRepository typeRepository;
	@Autowired
	ActeDecesRepository acteDecesRepository;
    @Autowired
    MaireRepository maireRepository;
    @Autowired
    PremierCopieService premierCopieService;

    @Autowired
    PieceDecesRepository pieceDecesRepository;

    @Autowired
    DefuntService defuntService;

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


    @Transactional
    public ActeDeces save(DecesRequest decesRequest, String idPremierCopie) {
        Maire maire = maireRepository.findById( decesRequest.getIdMaire()).get();
        PremierCopie premierCopie = premierCopieService.findById(idPremierCopie);

        PieceDeces pieceDeces = new PieceDeces(
            decesRequest.isNomPiece());
        pieceDecesRepository.save(pieceDeces);

        Defunt defunt = new Defunt(
            decesRequest.getProfessionDefunt(),
            decesRequest.getAdresseDefunt(),
            decesRequest.getDateDeces(),
            decesRequest.getLieuDeces(),
            decesRequest.getHeureDeces());

        defunt =  defuntService.save(defunt);

        NumeroActeDecesRequest numActeDeces = numeroActeDeces();

        ActeDeces actedeces = new ActeDeces(
            numActeDeces.idActeDeces,
            decesRequest.getDateDeclaration(),
            decesRequest.getHeureDeclaration(),
            decesRequest.getNomDeclarant(),
            decesRequest.getPrenomsDeclarant(),
            decesRequest.getProfessionDeclarant(),
            decesRequest.getLieuNaissanceDeclarant(),
            decesRequest.getAdresseDeclarant(),
            decesRequest.getDateNaissanceDeclarant(),
            decesRequest.getDate(),
            maire,
            defunt,
            pieceDeces,
            decesRequest.getCreatedDate(),
            premierCopie,
            numActeDeces.numero,
            numActeDeces.annee
        );
        premierCopieService.setDefuntPremierCopie(idPremierCopie);
        return acteDecesRepository.save(actedeces);
    }
}
