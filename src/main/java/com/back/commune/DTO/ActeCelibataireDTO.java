package com.back.commune.DTO;

import com.back.commune.model.ActeCelibataire;
import com.back.commune.model.Mere;
import com.back.commune.model.Pere;
import com.back.commune.model.auth.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActeCelibataireDTO {
    private String chefFkt;
    private String nomFkt;
    private String numCin;
    private String dateCin;
    private String lieuCin;
    private String dateActe;
    private String nom;
    private String lieuDeNaiss;
    private String dateDeNaiss;
    private String prenom;
    private String nomPere;
    private String nomMere;
    private User createdBy;

    public ActeCelibataireDTO(ActeCelibataire acteCelibataire){
        this.chefFkt = acteCelibataire.getChefFkt();
        this.nomFkt = acteCelibataire.getNomFkt();
        this.numCin = acteCelibataire.getNumCin();
        this.dateCin = acteCelibataire.getDateCin();
        this.lieuCin = acteCelibataire.getLieuCin();
        this.dateActe = acteCelibataire.getDateActe();
        this.nom = acteCelibataire.getPremierecopie().getEnfant().getNomEnfant();
        this.lieuDeNaiss = acteCelibataire.getPremierecopie().getEnfant().getLieunaissEnfant();
        this.dateDeNaiss = acteCelibataire.getPremierecopie().getEnfant().getDatenaissEnfant();
        this.prenom = acteCelibataire.getPremierecopie().getEnfant().getPrenomsEnfant();
        this.nomPere = getFullNamePere(acteCelibataire.getPremierecopie().getPere());
        this.nomMere = getFullNameMere(acteCelibataire.getPremierecopie().getMere());
        this.createdBy = acteCelibataire.getCreatedBy();
    }
    private String getFullNamePere(Pere pere){
        return pere.getNomPere() + " " + pere.getPrenomsPere();
    }
    private String getFullNameMere(Mere mere){
        return mere.getNomMere() + " " + mere.getPrenomsMere();
    }
}
