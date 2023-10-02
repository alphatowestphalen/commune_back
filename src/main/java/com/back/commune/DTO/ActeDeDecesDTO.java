package com.back.commune.DTO;

import com.back.commune.model.Maire;
import com.back.commune.model.auth.User;
import com.back.commune.model.deces.ActeDeces;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActeDeDecesDTO {
    private String idActeDeDeces;
    private String dateDeclaration;
    private String idPremierCopie;
    private String heureDeclaration;
    private String nomDeclarant;
    private String prenomsDeclarant;
    private String professionDeclarant;
    private String lieuNaissanceDeclarant;
    private String adresseDeclarant;
    private String dateNaissanceDeclarant;
    private String date;
    private Maire maire;
    private User createdBy;
    private String nomDefunt;
    private String prenomDefunt;
    private String dateDeNaissDefunt;
    private String lieuDeNaissDefunt;
    private String cinDefunt;
    private String dateCinDefunt;
    private String lieuCinDefunt;
    private String professionDefunt;
    private String adresseDefunt;
    private String nomMereDefunt;
    private String nomPereDefunt;
    private String dateDeces;
    private String lieuDeces;
    private String heureDeces;
    private String dateEnterement;
    private String heureEnterement;
    private String lieuEnterement;
    private String communeEnterement;
    private String districtEnterement;
    private String regionEnterement;
    private boolean fasanDehibe;

    public ActeDeDecesDTO(ActeDeces acteDeces){
        idActeDeDeces = Long.toString(acteDeces.getIdActeDeces());
        districtEnterement = acteDeces.getDefunt().getDistrictEnterement();
        fasanDehibe = acteDeces.getDefunt().isFasanDehibe();
        regionEnterement = acteDeces.getDefunt().getRegionEnterement();
        communeEnterement = acteDeces.getDefunt().getCommuneEnterement();
        lieuEnterement = acteDeces.getDefunt().getLieuEnterement();
        heureEnterement = acteDeces.getDefunt().getHeureEnterement();
        dateEnterement = acteDeces.getDefunt().getDateEnterement();
        heureDeces = acteDeces.getDefunt().getHeureDeces();
        lieuDeces = acteDeces.getDefunt().getLieuDeces();
        dateDeces = acteDeces.getDefunt().getDateDeces();
        nomPereDefunt = acteDeces.getDefunt().getNomPereDefunt();
        nomMereDefunt = acteDeces.getDefunt().getNomMereDefunt();
        adresseDefunt = acteDeces.getDefunt().getAdresseDefunt();
        professionDefunt = acteDeces.getDefunt().getProfessionDefunt();
        lieuCinDefunt = acteDeces.getDefunt().getLieuCinDefunt();
        dateCinDefunt = acteDeces.getDefunt().getDateCinDefunt();
        cinDefunt = acteDeces.getDefunt().getCinDefunt();
        lieuDeNaissDefunt = acteDeces.getDefunt().getLieuDeNaissDefunt();
        dateDeNaissDefunt = acteDeces.getDefunt().getDateDeNaissDefunt();
        prenomDefunt = acteDeces.getDefunt().getPrenomDefunt();
        nomDefunt =  acteDeces.getDefunt().getNomDefunt();
        createdBy = acteDeces.getCreatedBy();
        maire = acteDeces.getMaire();
        date = acteDeces.getDate();
        dateNaissanceDeclarant = acteDeces.getDateNaissanceDeclarant();
        adresseDeclarant = acteDeces.getAdresseDeclarant();
        lieuNaissanceDeclarant = acteDeces.getLieuNaissanceDeclarant();
        professionDeclarant = acteDeces.getProfessionDeclarant();
        prenomsDeclarant =  acteDeces.getPrenomsDeclarant();
        nomDeclarant =  acteDeces.getNomDeclarant();
        heureDeclaration = acteDeces.getHeureDeclaration();
        dateDeclaration = acteDeces.getDateDeclaration();
        idPremierCopie = acteDeces.getPremierCopie().getIdPremierCopie();
    }
}
