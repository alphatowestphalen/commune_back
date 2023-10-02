package com.back.commune.service;

import com.back.commune.DTO.MariageDTO;
import com.back.commune.DTO.StatisiqueAbstract;
import com.back.commune.DTO.StatistiqueMariage;
import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.mapper.MarriageMapper;
import com.back.commune.model.*;
import com.back.commune.model.auth.User;
import com.back.commune.model.mariage.*;
import com.back.commune.repository.*;
import com.back.commune.request.*;
import com.back.commune.security.services.UserService;
import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("copie : " + mariageMixteHomme.getHomme().getIdPremierCopie());
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

    public ResponsePageable<MariageDTO> getAllMariages(Pageable pageable){
        Page<Mariage> page = mariageRepository.findAll(pageable);
        List<Mariage> mariageList = page.getContent();
        List<MariageDTO> mariageDTOS = mariageList.stream().map(MariageDTO::new).collect(Collectors.toList());
        Page<MariageDTO> mariageDTOPage = new PageImpl<>(mariageDTOS,pageable,page.getTotalElements());
        return new ResponsePageable<>(mariageDTOPage);
    }

    public ResponsePageable<MariageDTO> getSearchAllMariages( String query, Pageable pageable){
        try {
            Page<Mariage> page = mariageRepository.findSearchAll(query, pageable);
            List<Mariage> mariageList = page.getContent();
            List<MariageDTO> mariageDTOS = mariageList.stream().map(MariageDTO::new).collect(Collectors.toList());
            Page<MariageDTO> mariageDTOPage = new PageImpl<>(mariageDTOS, pageable, page.getTotalElements());
            return new ResponsePageable<>(mariageDTOPage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public StatistiqueMariage getStatistiqueMariage() {
        StatistiqueMariage statistiqueMariage = new StatistiqueMariage();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(mariageRepository.count());
        statisiqueAbstract.setNombreParUtilisateur(mariageRepository.countByUser());

        statistiqueMariage.setNombre(statisiqueAbstract);

        return statistiqueMariage;
    }
    public StatistiqueMariage getStatistiqueMariageDays(Date day) {
        StatistiqueMariage statistiqueMariage = new StatistiqueMariage();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(mariageRepository.countByDays(day));
        statisiqueAbstract.setNombreParUtilisateur(mariageRepository.countByUserDay(day));

        statistiqueMariage.setNombre(statisiqueAbstract);

        return statistiqueMariage;
    }

    public StatistiqueMariage getStatistiqueMariageDays(Date day1, Date day2) {
        StatistiqueMariage statistiqueMariage = new StatistiqueMariage();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(mariageRepository.countByDays(day1, day2));
        statisiqueAbstract.setNombreParUtilisateur(mariageRepository.countByUserDay(day1, day2));

        statistiqueMariage.setNombre(statisiqueAbstract);

        return statistiqueMariage;
    }

    public StatistiqueMariage getStatistiqueMariageMonth(Integer month, Integer year) {
        StatistiqueMariage statistiqueMariage = new StatistiqueMariage();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(mariageRepository.countByMonth(month, year));
        statisiqueAbstract.setNombreParUtilisateur(mariageRepository.countByUserMonth(month, year));

        statistiqueMariage.setNombre(statisiqueAbstract);

        return statistiqueMariage;
    }
    public StatistiqueMariage getStatistiqueMariageYear(Integer year) {
        StatistiqueMariage statistiqueMariage = new StatistiqueMariage();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(mariageRepository.countByYear(year));
        statisiqueAbstract.setNombreParUtilisateur(mariageRepository.countByUserYear(year));

        statistiqueMariage.setNombre(statisiqueAbstract);

        return statistiqueMariage;
    }

    public Mariage findById(Long id){
       return mariageRepository.findById(id).orElseThrow(()-> new NotFoundDataException("Not found Mariage with id " + id));
    }

    public void delete(Long id) {
        Mariage mariage = findById(id) ;
        mariageRepository.delete(mariage);
    }
}
