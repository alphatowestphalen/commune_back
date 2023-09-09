package com.example.demo.service;

import com.example.demo.exceptions.NotFoundDataException;
import com.example.demo.model.*;
import com.example.demo.model.auth.User;
import com.example.demo.repository.*;
import com.example.demo.request.PremierCopieRequest;
import com.example.demo.security.services.UserService;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.request.NumeroRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PremierCopieService {
    private final PieceJustificativeRepository pieceJustificativeRepository;
    private final EnfantRepository enfantRepository;

    private final DeclarantRepository declarantRepository;

    private final MereRepository mereRepository;
    private final  PereRepository pereRepository;
	private final PremierCopieRepository premierCopieRepository;
    private final TypeRepository typeRepository;
    private final MaireRepository maireRepository;

    private final UserService userService;

    @Autowired
    public PremierCopieService(
        PieceJustificativeRepository pieceJustificativeRepository, EnfantRepository enfantRepository, MereRepository mereRepository,
        PereRepository pereRepository,
        PremierCopieRepository premierCopieRepository,
        @Autowired(required = false) TypeRepository typeRepository,
        MaireRepository maireRepository,
        DeclarantRepository declarantRepository,
        UserService userService) {
        this.pieceJustificativeRepository = pieceJustificativeRepository;
        this.enfantRepository = enfantRepository;
        this.mereRepository = mereRepository;
        this.pereRepository = pereRepository;
        this.premierCopieRepository = premierCopieRepository;
        this.typeRepository = typeRepository;
        this.maireRepository = maireRepository;
        this.declarantRepository = declarantRepository;
        this.userService = userService;
    }



    public NumeroRequest numeroCopie()
	{
		NumeroRequest numeroRequest = new NumeroRequest();

		PremierCopie pc = premierCopieRepository.chercherPremierCopie();

		int currentYear = typeRepository.year;

		if (pc != null) {
			long num = pc.getNumero();
			int annee = pc.getAnneeActuelle();
			/*
			long num = premierCopieRepository.chercherNumeroCopie();
			int annee = premierCopieRepository.chercherAnneeCopie();
			*/
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

/*	public void PersonDecede(@Param("idPremierCopie") String idPremierCopie)
	{
		premierCopieRepository.personneDecede(idPremierCopie);
	}
	*/

	public void supprimerPCopie( String IdPremierCopie)
	{
        System.out.println("id copie "+IdPremierCopie);
		PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
        System.out.println("premier "+premierCopie.getIdPremierCopie());
		if(premierCopie == null) throw new RuntimeException("Premier Copie not found");
        premierCopieRepository.deletePremierCopie(premierCopie.getIdPremierCopie());
	}

    public PremierCopie findById(String IdPremierCopie){
        return premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
    }

    public ResponsePageable<PremierCopie> findAll(Pageable pageable){
        return new ResponsePageable<PremierCopie>(premierCopieRepository.findAll(pageable));
    }

    @Transactional
    public PremierCopie save(PremierCopieRequest premierCopieRequest){
        NumeroRequest numeroRequest = numeroCopie();
        Optional<Maire> optionalMaire = maireRepository.findById(premierCopieRequest.getIdMaire());
        if(!optionalMaire.isPresent()) throw new NotFoundDataException( "Maire not found");
        User user = userService.getAuthenticatedUser();
        if (user== null) throw new NotFoundDataException("User not found");
        Declarant declarant = new Declarant(
            premierCopieRequest.getNomDeclarant(),
            premierCopieRequest.getPrenomsDeclarant(),
            premierCopieRequest.getDatenaissDeclarant(),
            premierCopieRequest.getLieuNaissDeclarant(),
            premierCopieRequest.getAdressDeclarant(),
            premierCopieRequest.getProfessionDeclarant());
        declarantRepository.save(declarant);
        Mere mere = new Mere(
            premierCopieRequest.getNomMere(),
            premierCopieRequest.getPrenomsMere(),
            premierCopieRequest.getDatenaissMere(),
            premierCopieRequest.getLieuNaissMere(),
            premierCopieRequest.getProfessionMere(),
            premierCopieRequest.getAdresseMere() );
        mereRepository.save(mere);
        Pere pere = new Pere();
        if(premierCopieRequest.getAvoirPere()) {
            pere = new Pere(
                premierCopieRequest.getNomPere(),
                premierCopieRequest.getPrenomsPere(),
                premierCopieRequest.getDatenaissPere(),
                premierCopieRequest.getLieuNaissPere(),
                premierCopieRequest.getProfessionPere(),
                premierCopieRequest.getAdressePere());
            pereRepository.save(pere);
        }
        Enfant enfant = new Enfant(
            premierCopieRequest.getNomEnfant(),
            premierCopieRequest.getPrenomsEnfant(),
            premierCopieRequest.getDatenaissEnfant(),
            premierCopieRequest.getLieunaissEnfant(),
            premierCopieRequest.getHeurenaissEnfant(),
            premierCopieRequest.getSexeEnfant(),
            premierCopieRequest.getDateEnfant());
        enfantRepository.save(enfant);

        PieceJustificative pieceJustificative = new PieceJustificative(
            premierCopieRequest.getCertificatAccouch(),
            premierCopieRequest.getLivretFamille(),
            premierCopieRequest.getCinMere(),
            premierCopieRequest.getCinDeclarant() );
        pieceJustificativeRepository.save(pieceJustificative);

        PremierCopie premierCopie = new PremierCopie(
            numeroRequest.idPremierCopie,
            premierCopieRequest.getDescription(),
            premierCopieRequest.getMention(),
            premierCopieRequest.getDatePCopie(),
            premierCopieRequest.getDatePremierCopie(),
            declarant,
            optionalMaire.get(),
            mere,
            pere,
            enfant,
            pieceJustificative,
            premierCopieRequest.getCreatedDate(),
            numeroRequest.numero,
            numeroRequest.annee
        );
        premierCopie.setCreatedBy(user);

        System.out.println("user "+user.getUsername());
        return premierCopieRepository.save(premierCopie);
    }

    public void setDefuntPremierCopie(String IdPremierCopie){
        supprimerPCopie(IdPremierCopie);
    }
}
