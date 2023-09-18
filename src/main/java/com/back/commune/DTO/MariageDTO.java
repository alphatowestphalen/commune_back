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
        createdBy = mariage.getCreatedBy();
        createdDate = mariage.getCreatedDate();
        description = mariage.getDescription();
        idMariage = mariage.getIdMariage();
        dateMariage = mariage.getDateMariage();
        heureMariage= mariage.getHeureMariage();
    }

    private <T extends Mariage > void getHomme(T mariage){
        if (mariage instanceof MariageAllExterne) {
            MariageAllExterne allExterne = (MariageAllExterne) mariage;
            getHommeFemmeEE(allExterne);
        }
        else if (mariage instanceof MariageAllInterne) {
            MariageAllInterne allExterne = (MariageAllInterne) mariage;
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
        homme = mariage.getHomme();
        femme = mariage.getFemme();
    }

    private void getHommeFemmeII(MariageAllInterne mariage){
        typeMariage = "Interne-Interne";
        PremierCopie homeTmp = mariage.getHomme();
        homme = new Homme();
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
        femme.setMereFemme(femmeTmp.getMere());
        femme.setPereFemme(femmeTmp.getPere());
        femme.setDateNaissFemme(femmeTmp.getEnfant().getDatenaissEnfant());
        femme.setNomFemme(femmeTmp.getEnfant().getNomEnfant());
        femme.setPrenomsFemme(femmeTmp.getEnfant().getPrenomsEnfant());
        femme.setNationaliteFemme("Malagasy");
        // missing proffession/ adresse
        homme.setLieuNaissHomme(femmeTmp.getEnfant().getLieunaissEnfant());
    }
    private void getHommeFemmeMF(MariageMixteFemme mariage){
        PremierCopie femmeTmp = mariage.getFemme();
        femme = new Femme();
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
        femme = mariage.getFemme();
        PremierCopie hommeTmp = mariage.getHomme();
        homme = new Homme();
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
