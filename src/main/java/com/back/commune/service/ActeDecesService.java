package com.back.commune.service;

import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.*;
import com.back.commune.repository.TypeRepository;
import com.back.commune.repository.PieceDecesRepository;
import com.back.commune.request.DecesRequest;
import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.back.commune.repository.ActeDecesRepository;
import com.back.commune.request.NumeroActeDecesRequest;

import javax.transaction.Transactional;

@Service
public class ActeDecesService {

    private final TypeRepository typeRepository;

	private final ActeDecesRepository acteDecesRepository;

    private final PremierCopieService premierCopieService;

    private final PieceDecesRepository pieceDecesRepository;

    private final DefuntService defuntService;

    private final MaireService maireService;

    @Autowired
    public ActeDecesService(@Autowired(required = false) TypeRepository typeRepository,
                            ActeDecesRepository acteDecesRepository,
                            PremierCopieService premierCopieService,
                            PieceDecesRepository pieceDecesRepository,
                            DefuntService defuntService,
                            MaireService maireService)
    {
        this.typeRepository = typeRepository;
        this.acteDecesRepository = acteDecesRepository;
        this.premierCopieService = premierCopieService;
        this.pieceDecesRepository = pieceDecesRepository;
        this.defuntService = defuntService;
        this.maireService = maireService;
    }

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
    public ActeDeces save(DecesRequest decesRequest) {
        Maire maire = maireService.findById( decesRequest.getIdMaire());
        if (maire == null) throw new NotFoundDataException("Not found Maire with id = " + decesRequest.getIdMaire());
        PremierCopie premierCopie = premierCopieService.findById(decesRequest.getIdPremierCopie());
        if(premierCopie == null) throw new NotFoundDataException("Not found PremierCopie with id = " + decesRequest.getIdPremierCopie());
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
            premierCopie,
            numActeDeces.numero,
            numActeDeces.annee
        );
        premierCopieService.setDefuntPremierCopie(decesRequest.getIdPremierCopie());
        return acteDecesRepository.save(actedeces);
    }

    public ResponsePageable<ActeDeces> findAll(Pageable pageable){
        Page<ActeDeces> acteDeces = acteDecesRepository.findAll(pageable);
        return new ResponsePageable<>(acteDeces);
    }

    public ActeDeces findById(String id) {
        ActeDeces acteDeces = acteDecesRepository.findByIdActeDeces(id);
        if(acteDeces == null) throw new NotFoundDataException("Not found ActeDeces with id = " + id);
        return acteDeces;
    }

    public void delete(String idActeDeces) {
        ActeDeces acteDeces =  findById(idActeDeces);
        if (acteDeces == null) throw new NotFoundDataException("Not found ActeDeces with id = " + idActeDeces);
        premierCopieService.setDefuntPremierCopie(acteDeces.getPremierCopie().getIdPremierCopie());
        acteDecesRepository.deleteById(idActeDeces);
    }

    public ActeDeces update(String idActe, DecesRequest decesRequest){
        ActeDeces acteDeces = findById(idActe);
        if(acteDeces == null) throw new NotFoundDataException("Not found ActeDeces with id = " + idActe);

        PremierCopie premierCopie = premierCopieService.findById(decesRequest.getIdPremierCopie());
        if(premierCopie == null) throw new NotFoundDataException("Not found PremierCopie with id = " + decesRequest.getIdPremierCopie());

        Maire maire =  maireService.findById( decesRequest.getIdMaire());
        if(maire == null) throw new NotFoundDataException("Not found Maire with id = " + decesRequest.getIdMaire());

        Defunt defunt = acteDeces.getDefunt();
        PieceDeces pieceDeces = acteDeces.getPieceDeces();

        defunt.setProfessionDefunt(decesRequest.getProfessionDefunt());
        defunt.setAdresseDefunt(decesRequest.getAdresseDefunt());
        defunt.setDateDeces(decesRequest.getDateDeces());
        defunt.setLieuDeces(decesRequest.getLieuDeces());
        defunt.setHeureDeces(decesRequest.getHeureDeces());

        defunt =  defuntService.save(defunt);

        pieceDeces.setNomPiece(decesRequest.isNomPiece());
        pieceDecesRepository.save(pieceDeces);

        acteDeces.setDateDeclaration(decesRequest.getDateDeclaration());
        acteDeces.setHeureDeclaration(decesRequest.getHeureDeclaration());
        acteDeces.setNomDeclarant(decesRequest.getNomDeclarant());
        acteDeces.setPrenomsDeclarant(decesRequest.getPrenomsDeclarant());
        acteDeces.setProfessionDeclarant(decesRequest.getProfessionDeclarant());
        acteDeces.setLieuNaissanceDeclarant(decesRequest.getLieuNaissanceDeclarant());
        acteDeces.setAdresseDeclarant(decesRequest.getAdresseDeclarant());
        acteDeces.setDateNaissanceDeclarant(decesRequest.getDateNaissanceDeclarant());
        acteDeces.setDate(decesRequest.getDate());
        acteDeces.setMaire(maire);
        acteDeces.setDefunt(defunt);
        acteDeces.setPieceDeces(pieceDeces);
        acteDeces.setPremierCopie(premierCopie);

        return acteDecesRepository.save(acteDeces);
    }
}
