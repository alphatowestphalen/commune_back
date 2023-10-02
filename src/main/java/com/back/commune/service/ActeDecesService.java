package com.back.commune.service;

import com.back.commune.DTO.ActeDeDecesDTO;
import com.back.commune.DTO.StatisiqueAbstract;
import com.back.commune.DTO.StatistiaqueDeces;
import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.mapper.ActeDeDecesMapper;
import com.back.commune.model.*;
import com.back.commune.model.auth.User;
import com.back.commune.model.deces.ActeDeces;
import com.back.commune.model.deces.Defunt;
import com.back.commune.repository.DefuntRepository;
import com.back.commune.repository.TypeRepository;
import com.back.commune.repository.PieceDecesRepository;
import com.back.commune.request.DecesRequest;
import com.back.commune.security.services.UserService;
import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.back.commune.repository.ActeDecesRepository;
import com.back.commune.request.NumeroActeDecesRequest;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActeDecesService {
    private final TypeRepository typeRepository;
	private final ActeDecesRepository acteDecesRepository;
    private final PremierCopieService premierCopieService;
    private final PieceDecesRepository pieceDecesRepository;
    private final DefuntRepository defuntRepository;
    private final MaireService maireService;
    private final UserService userService;
    private final ActeDeDecesMapper acteDeDecesMapper;

    @Autowired
    public ActeDecesService(
        @Autowired(required = false) TypeRepository typeRepository,
        ActeDecesRepository acteDecesRepository,
        PremierCopieService premierCopieService,
        PieceDecesRepository pieceDecesRepository,
        DefuntRepository defuntRepository, MaireService maireService,
        UserService userService, ActeDeDecesMapper acteDeDecesMapper)
    {
        this.typeRepository = typeRepository;
        this.acteDecesRepository = acteDecesRepository;
        this.premierCopieService = premierCopieService;
        this.pieceDecesRepository = pieceDecesRepository;
        this.defuntRepository = defuntRepository;
        this.maireService = maireService;
        this.userService = userService;
        this.acteDeDecesMapper = acteDeDecesMapper;
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
    public ActeDeDecesDTO save(DecesRequest decesRequest) {
        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");
        Maire maire = maireService.findById( decesRequest.getIdMaire());
        if (maire == null) throw new NotFoundDataException("Not found Maire with id = " + decesRequest.getIdMaire());
        PremierCopie premierCopie = null;
        System.out.println(decesRequest.getIdPremierCopie());
        if(decesRequest.getIdPremierCopie() != null){
            premierCopie = premierCopieService.findById(decesRequest.getIdPremierCopie());
            if (premierCopie == null)
                throw new NotFoundDataException("Not found PremierCopie with id = " + decesRequest.getIdPremierCopie());
        }
        PieceDeces pieceDeces = new PieceDeces(
            decesRequest.isNomPiece());
        pieceDecesRepository.save(pieceDeces);
        Defunt defunt = acteDeDecesMapper.convertToDefunt(decesRequest);
        defuntRepository.save(defunt);

        ActeDeces acteDeces = acteDeDecesMapper.convertToActeDeDeces(decesRequest);
        acteDeces.setCreatedBy(user);
        acteDeces.setDefunt(defunt);
        acteDeces.setMaire(maire);
        if(decesRequest.getIdPremierCopie() != null) {
            acteDeces.setPremierCopie(premierCopie);
            premierCopieService.setDefuntPremierCopie(decesRequest.getIdPremierCopie());
        }
        return new ActeDeDecesDTO(acteDecesRepository.save(acteDeces));
    }

    public ResponsePageable<ActeDeDecesDTO> findAll(Pageable pageable){
        Page<ActeDeces> acteDecesPage = acteDecesRepository.findAll(pageable);
        List<ActeDeDecesDTO> acteDecesList = acteDecesPage.getContent().stream().
            map(ActeDeDecesDTO::new).collect(Collectors.toList());
        Page<ActeDeDecesDTO> page = new PageImpl<>(acteDecesList,pageable,acteDecesPage.getTotalPages());
        return new ResponsePageable<>(page);
    }

    public ActeDeDecesDTO findById(Long id) {
        Optional<ActeDeces> opt = acteDecesRepository.findById(id);
        if(!opt.isPresent()) throw new NotFoundDataException("Not found ActeDeces with id = " + id);
        return new ActeDeDecesDTO(opt.get());
    }

    public void delete(Long idActeDeces) {
        Optional<ActeDeces> opt = acteDecesRepository.findById(idActeDeces);
        if(!opt.isPresent()) throw new NotFoundDataException("Not found ActeDeces with id = " + idActeDeces);;
        premierCopieService.setDefuntPremierCopie(opt.get().getPremierCopie().getIdPremierCopie());
        acteDecesRepository.deleteById(idActeDeces);
    }

    public ActeDeces update(Long idActe, DecesRequest decesRequest){
        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");

        Optional<ActeDeces> opt = acteDecesRepository.findById(idActe);
        if(!opt.isPresent()) throw new NotFoundDataException("Not found ActeDeces with id = " + idActe);
        ActeDeces acteDeces = opt.get();

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
        defunt.setDateEnterement(decesRequest.getDateEnterement());
        defunt.setHeureEnterement(decesRequest.getHeureEnterement());
        defunt.setLieuEnterement(decesRequest.getLieuEnterement());
        defunt.setCommuneEnterement(decesRequest.getCommuneEnterement());
        defunt.setRegionEnterement(decesRequest.getRegionEnterement());
        defunt.setNomDefunt(decesRequest.getNomDefunt());
        defunt.setPrenomDefunt(decesRequest.getPrenomDefunt());
        defunt.setDateDeNaissDefunt(decesRequest.getDateDeNaissDefunt());
        defunt.setLieuDeNaissDefunt(decesRequest.getLieuDeNaissDefunt());
        defunt.setDateCinDefunt(decesRequest.getDateCinDefunt());
        defunt.setLieuCinDefunt(decesRequest.getLieuCinDefunt());
        defunt.setNomPereDefunt(defunt.getNomPereDefunt());
        defunt.setNomMereDefunt(defunt.getNomMereDefunt());
        defunt.setFasanDehibe(decesRequest.isFasanDehibe());

        defunt =  defuntRepository.save(defunt);

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
        acteDeces.setCreatedBy(user);

        return acteDecesRepository.save(acteDeces);
    }
    public StatistiaqueDeces getStatistiaqueDeces() {
        StatistiaqueDeces statistiaqueDeces = new StatistiaqueDeces();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(acteDecesRepository.count());
        statisiqueAbstract.setNombreParUtilisateur(acteDecesRepository.countByUser());

        statistiaqueDeces.setNombre(statisiqueAbstract);

        return statistiaqueDeces;
    }

    public StatistiaqueDeces getStatistiaqueDecesDays(Date day) {
        StatistiaqueDeces statistiaqueDeces = new StatistiaqueDeces();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(acteDecesRepository.countByDays(day));
        statisiqueAbstract.setNombreParUtilisateur(acteDecesRepository.countByUserDay(day));

        statistiaqueDeces.setNombre(statisiqueAbstract);

        return statistiaqueDeces;
    }

    public StatistiaqueDeces getStatistiaqueDecesDays(Date day1, Date day2) {
        StatistiaqueDeces statistiaqueDeces = new StatistiaqueDeces();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(acteDecesRepository.countByDays(day1, day2));
        statisiqueAbstract.setNombreParUtilisateur(acteDecesRepository.countByUserDay(day1, day2));

        statistiaqueDeces.setNombre(statisiqueAbstract);

        return statistiaqueDeces;
    }

    public StatistiaqueDeces getStatistiaqueDecesMonth(Integer month, Integer year) {
        StatistiaqueDeces statistiaqueDeces = new StatistiaqueDeces();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(acteDecesRepository.countByMonth(month, year));
        statisiqueAbstract.setNombreParUtilisateur(acteDecesRepository.countByUserMonth(month, year));

        statistiaqueDeces.setNombre(statisiqueAbstract);

        return statistiaqueDeces;
    }

    public StatistiaqueDeces getStatistiaqueDecesYear(Integer year) {
        StatistiaqueDeces statistiaqueDeces = new StatistiaqueDeces();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(acteDecesRepository.countByYear(year));
        statisiqueAbstract.setNombreParUtilisateur(acteDecesRepository.countByUserYear(year));

        statistiaqueDeces.setNombre(statisiqueAbstract);

        return statistiaqueDeces;
    }

    public ResponsePageable<ActeDeDecesDTO> findAllSearch(String query, Pageable pageable) {
        Page<ActeDeces> acteDecesPage = acteDecesRepository.findAllSearch(query, pageable);
        List<ActeDeDecesDTO> acteDecesList = acteDecesPage.getContent().stream().
            map(ActeDeDecesDTO::new).collect(Collectors.toList());
        Page<ActeDeDecesDTO> page = new PageImpl<>(acteDecesList,pageable,acteDecesPage.getTotalPages());
        return new ResponsePageable<>(page);
    }
}
