package com.back.commune.DTO;

import com.back.commune.model.*;
import com.back.commune.model.auth.User;
import com.back.commune.model.mariage.*;
import com.back.commune.request.MariageEIRequest;
import lombok.Data;

import java.time.Instant;

@Data
public class MariageDTO {
    private Homme homme;
    private Femme femme;
    private Temoin temoinFemme;
    private Temoin temoinHomme;
    private Long idMariage;
    private String description;
    private String dateMariage;
    private String heureMariage;
    private User createdBy;
    private Maire maire;
    private Instant createdDate;
    private String typeMariage;

    public <T extends Mariage > MariageDTO(T mariage) {
        temoinFemme = mariage.getTemoinFemme();
        temoinHomme = mariage.getTemoinHomme();
        maire = mariage.getMaire();
        createdBy = mariage.getCreatedBy();
        createdDate = mariage.getCreatedDate();
        description = mariage.getDescription();
        idMariage = mariage.getIdMariage();
        dateMariage = mariage.getDateMariage();
        heureMariage= mariage.getHeureMariage();
        getCouples(mariage);
    }

    private <T extends Mariage > void getCouples(T mariage){
        if (mariage instanceof MariageAllExterne) {
            MariageAllExterne allExterne = (MariageAllExterne) mariage;
            getHommeFemmeEE(allExterne);
        }
        else if (mariage instanceof MariageAllInterne) {
            getHommeFemmeII((MariageAllInterne) mariage);
        }
        else if (mariage instanceof MariageMixteHomme) {
            getHommeFemmeMH((MariageMixteHomme) mariage);
        }
        else if (mariage instanceof MariageMixteFemme) {
            getHommeFemmeMF((MariageMixteFemme) mariage);
        }
        else throw new IllegalArgumentException("mariage non reconnu");
    }
    private void getHommeFemmeEE(MariageAllExterne mariage){
        typeMariage = "Externe-Externe";
        homme = mariage.getHomme();
        femme = mariage.getFemme();
    }

    private void getHommeFemmeII(MariageAllInterne mariage){
        typeMariage = "Interne-Interne";
        PremierCopie homeTmp = mariage.getHomme();
        homme = new Homme();
        homme.setIdHomme(Long.parseLong(homeTmp.getIdPremierCopie()));
        homme.setMereHomme(homeTmp.getMere());
        homme.setPereHomme(homeTmp.getPere());
        homme.setDateNaissHomme(homeTmp.getEnfant().getDatenaissEnfant());
        homme.setNomHomme(homeTmp.getEnfant().getNomEnfant());
        homme.setPrenomsHomme(homeTmp.getEnfant().getPrenomsEnfant());
        homme.setNationaliteHomme("Malagasy");
        // missing proffession/ adresse
        homme.setLieuNaissHomme(homeTmp.getEnfant().getLieunaissEnfant());

        PremierCopie femmeTmp = mariage.getFemme();
        femme = new Femme();
        femme.setIdFemme(Long.parseLong(femmeTmp.getIdPremierCopie()));
        femme.setMereFemme(femmeTmp.getMere());
        femme.setPereFemme(femmeTmp.getPere());
        femme.setDateNaissFemme(femmeTmp.getEnfant().getDatenaissEnfant());
        femme.setNomFemme(femmeTmp.getEnfant().getNomEnfant());
        femme.setPrenomsFemme(femmeTmp.getEnfant().getPrenomsEnfant());
        femme.setNationaliteFemme("Malagasy");
        // missing proffession/ adresse
        femme.setLieuNaissFemme(femmeTmp.getEnfant().getLieunaissEnfant());
    }
    private void getHommeFemmeMF(MariageMixteFemme mariage){
        typeMariage = "Externe-Interne";
        PremierCopie femmeTmp = mariage.getFemme();
        femme = new Femme();
        femme.setIdFemme(Long.parseLong(femmeTmp.getIdPremierCopie()));
        femme.setMereFemme(femmeTmp.getMere());
        femme.setPereFemme(femmeTmp.getPere());
        femme.setDateNaissFemme(femmeTmp.getEnfant().getDatenaissEnfant());
        femme.setNomFemme(femmeTmp.getEnfant().getNomEnfant());
        femme.setPrenomsFemme(femmeTmp.getEnfant().getPrenomsEnfant());
        femme.setNationaliteFemme("Malagasy");
        // missing proffession/ adresse
        homme.setLieuNaissHomme(femmeTmp.getEnfant().getLieunaissEnfant());

        homme = mariage.getHomme();
    }
    private void getHommeFemmeMH(MariageMixteHomme mariage){
        typeMariage = "Interne-Externe";
        femme = mariage.getFemme();
        PremierCopie hommeTmp = mariage.getHomme();
        homme = new Homme();
        homme.setIdHomme(Long.parseLong(hommeTmp.getIdPremierCopie()));
        homme.setMereHomme(hommeTmp.getMere());
        homme.setPereHomme(hommeTmp.getPere());
        homme.setDateNaissHomme(hommeTmp.getEnfant().getDatenaissEnfant());
        homme.setNomHomme(hommeTmp.getEnfant().getNomEnfant());
        homme.setPrenomsHomme(hommeTmp.getEnfant().getPrenomsEnfant());
        homme.setNationaliteHomme("Malagasy");
        // missing proffession/ adresse
        homme.setLieuNaissHomme(hommeTmp.getEnfant().getLieunaissEnfant());

        femme = mariage.getFemme();
    }
}
