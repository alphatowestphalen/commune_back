package com.back.commune.service;

import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.mapper.MarriageMapper;
import com.back.commune.model.*;
import com.back.commune.model.auth.User;
import com.back.commune.model.mariage.*;
import com.back.commune.repository.*;
import com.back.commune.request.*;
import com.back.commune.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MariageService {

	private final TypeRepository typeRepository;
    private final HommeRepository hommeRepository;
    private final FemmeRepository femmeRepository;
    private final TemoinRepository temoinRepository;
	private final MariageRepository mariageRepository;
    private final MarriageMapper marriageMapper;
    private final PereRepository pereRepository;
    private final MereRepository mereRepository;
    private final PremierCopieService premierCopieService;

    private final UserService userService;

    private final MaireService maireService;

    @Autowired
    public MariageService(
        @Autowired(required = false) TypeRepository typeRepository,
        HommeRepository hommeRepository, FemmeRepository femmeRepository, TemoinRepository temoinRepository, MariageRepository mariageRepository,
        MarriageMapper marriageMapper, PereRepository pereRepository, MereRepository mereRepository, PremierCopieService premierCopieService, UserService userService, MaireService maireService) {
        this.typeRepository = typeRepository;
        this.hommeRepository = hommeRepository;
        this.femmeRepository = femmeRepository;
        this.temoinRepository = temoinRepository;
        this.mariageRepository = mariageRepository;
        this.marriageMapper = marriageMapper;
        this.pereRepository = pereRepository;
        this.mereRepository = mereRepository;
        this.premierCopieService = premierCopieService;
        this.userService = userService;
        this.maireService = maireService;
    }

    /*
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
	}*/

    public Homme saveHomme(Homme homme){
        return hommeRepository.save(homme);
    }
    public Femme saveFemme(Femme femme){
        return femmeRepository.save(femme);
    }

    public Pere savePere(Pere pere){
        return pereRepository.save(pere);
    }
    public Mere saveMere(Mere mere){
        return mereRepository.save(mere);
    }


    public Temoin saveTemoin(Temoin temoin){
        return temoinRepository.save(temoin);
    }


    // add mariage interne interne
    @Transactional
    public MariageAllInterne saveMariageII(MariageIIRequest request){
        // extract temoin from request
        User user = userService.getAuthenticatedUser();
        if(user == null) throw new NotFoundDataException("User not found");

        Temoin temoinHomme =  marriageMapper.extractTemoin(request, GenreMariage.HOMME);
        Temoin temoinFemme =  marriageMapper.extractTemoin(request, GenreMariage.FEMME);
        temoinFemme = saveTemoin(temoinFemme);
        temoinHomme = saveTemoin(temoinHomme);

        // find Copie from DB
        PremierCopie copieHomme = premierCopieService.findById(request.getIdPremierCopieHomme());
        PremierCopie copieFemme = premierCopieService.findById(request.getIdPremierCopieFemme());

        // extract mariage from request
        Mariage mariage = marriageMapper.extractMariage(request);

        Maire maire = maireService.findById(request.getIdMaire());

        MariageAllInterne mariageAllInterne = new MariageAllInterne(mariage, copieHomme, copieFemme);

        mariageAllInterne.setCreatedBy(user);
        mariageAllInterne.setMaire(maire);
        mariageAllInterne.setTemoinFemme(temoinFemme);
        mariageAllInterne.setTemoinHomme(temoinHomme);
        return mariageRepository.save(mariageAllInterne);
    }

    @Transactional
    public MariageMixteHomme saveMariageIE(MariageIERequest request){
        User user = userService.getAuthenticatedUser();
        if(user == null) throw new NotFoundDataException("User not found");

        Temoin temoinHomme =  marriageMapper.extractTemoin(request, GenreMariage.HOMME);
        Temoin temoinFemme =  marriageMapper.extractTemoin(request, GenreMariage.FEMME);
        temoinFemme = saveTemoin(temoinFemme);
        temoinHomme = saveTemoin(temoinHomme);

        PremierCopie copieHomme = premierCopieService.findById(request.getIdPremierCopieHomme());

        Mariage mariage = marriageMapper.extractMariage(request);

        Femme femme = marriageMapper.extractFemme(request);
        Pere pereFemme = marriageMapper.extractPere(request);
        pereFemme = savePere(pereFemme);
        Mere mereFemme = marriageMapper.extractMere(request);
        mereFemme = saveMere(mereFemme);

        femme.setPereFemme(pereFemme);
        femme.setMereFemme(mereFemme);

        Maire maire = maireService.findById(request.getIdMaire());


        femme = saveFemme(femme);

        MariageMixteHomme mariageMixteHomme = new MariageMixteHomme(mariage, copieHomme, femme);
        mariageMixteHomme.setCreatedBy(user);
        mariageMixteHomme.setMaire(maire);
        mariageMixteHomme.setTemoinFemme(temoinFemme);
        mariageMixteHomme.setTemoinHomme(temoinHomme);
        return mariageRepository.save(mariageMixteHomme);
    }

    @Transactional
    public Mariage saveMariageEE(MariageEERequest request){
        User user = userService.getAuthenticatedUser();
        if(user == null) throw new NotFoundDataException("User not found");

        Temoin temoinHomme =  marriageMapper.extractTemoin(request, GenreMariage.HOMME);
        Temoin temoinFemme =  marriageMapper.extractTemoin(request, GenreMariage.FEMME);
        temoinFemme = saveTemoin(temoinFemme);
        temoinHomme = saveTemoin(temoinHomme);

        Mariage mariage = marriageMapper.extractMariage(request);

        //add Homme
        Homme homme = marriageMapper.extractHomme(request);
        Pere pereHomme = marriageMapper.extractPere(request, GenreMariage.HOMME);
        pereHomme = savePere(pereHomme);
        Mere mereHomme = marriageMapper.extractMere(request, GenreMariage.HOMME);
        mereHomme = saveMere(mereHomme);

        homme.setPereHomme(pereHomme);
        homme.setMereHomme(mereHomme);

        homme = saveHomme(homme);

        //add Femme
        Femme femme = marriageMapper.extractFemme(request);
        Pere pereFemme = marriageMapper.extractPere(request, GenreMariage.FEMME);
        pereFemme = savePere(pereFemme);
        Mere mereFemme = marriageMapper.extractMere(request, GenreMariage.FEMME);
        mereFemme = saveMere(mereFemme);

        femme.setPereFemme(pereFemme);
        femme.setMereFemme(mereFemme);

        femme = saveFemme(femme);

        Maire maire = maireService.findById(request.getIdMaire());

        MariageAllExterne mariageAllExterne = new MariageAllExterne(mariage, homme, femme);
        mariageAllExterne.setCreatedBy(user);

        mariageAllExterne.setMaire(maire);
        mariageAllExterne.setTemoinFemme(temoinFemme);
        mariageAllExterne.setTemoinHomme(temoinHomme);
        return mariageRepository.save(mariageAllExterne);

    }

    @Transactional
    public Mariage saveMariageEI(MariageEIRequest request){
        User user = userService.getAuthenticatedUser();
        if(user == null) throw new NotFoundDataException("User not found");

        Temoin temoinHomme =  marriageMapper.extractTemoin(request, GenreMariage.HOMME);
        Temoin temoinFemme =  marriageMapper.extractTemoin(request, GenreMariage.FEMME);
        temoinFemme = saveTemoin(temoinFemme);
        temoinHomme = saveTemoin(temoinHomme);

        PremierCopie copieFemme = premierCopieService.findById(request.getIdPremierCopieFemme());

        Mariage mariage = marriageMapper.extractMariage(request);

        // set Temoin from DB to mariage
        mariage.setTemoinFemme(temoinFemme);
        mariage.setTemoinHomme(temoinHomme);

        Homme homme = marriageMapper.extractHomme(request);
        Pere pereHomme = marriageMapper.extractPere(request);
        pereHomme = savePere(pereHomme);
        Mere mereHomme = marriageMapper.extractMere(request);
        mereHomme = saveMere(mereHomme);

        homme.setPereHomme(pereHomme);
        homme.setMereHomme(mereHomme);

        homme = saveHomme(homme);
        Maire maire = maireService.findById(request.getIdMaire());

        MariageMixteFemme mariageMixteFemme = new MariageMixteFemme(mariage, homme, copieFemme);
        mariageMixteFemme.setCreatedBy(user);
        mariageMixteFemme.setMaire(maire);
        mariageMixteFemme.setTemoinFemme(temoinFemme);
        mariageMixteFemme.setTemoinHomme(temoinHomme);

        return mariageRepository.save(mariageMixteFemme);
    }

    public List<Mariage> getAllMariages() {
        return mariageRepository.findAll();
    }
}
