package com.back.commune.DTO;

import com.back.commune.model.celibataire.ActeCelibataire;
import com.back.commune.model.Mere;
import com.back.commune.model.Pere;
import com.back.commune.model.auth.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ActeCelibataireDTO {
    private String nomFkt;
    private Long idActeCelibataire;
    private String numCin;
    private String dateCin;
    private String lieuCin;
    private String dateActe;
    private String nom;
    private String lieuDeNaiss;
    private String dateDeNaiss;
    private String nomPere;
    private String nomMere;
    private User createdBy;

    public ActeCelibataireDTO(ActeCelibataire acteCelibataire){
        this.nomFkt = acteCelibataire.getNomFkt();
        this.numCin = acteCelibataire.getNumCin();
        this.dateCin = acteCelibataire.getDateCin();
        this.lieuCin = acteCelibataire.getLieuCin();
        this.idActeCelibataire = acteCelibataire.getIdActeCelibataire();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date d = Date.from(acteCelibataire.getCreatedDate());
        this.dateActe = form.format(d);
        this.nom = acteCelibataire.getNom();
        this.lieuDeNaiss = acteCelibataire.getLieuDeNaiss();
        this.dateDeNaiss = acteCelibataire.getDateDeNaiss();
        this.nomPere = acteCelibataire.getNomPere();
        this.nomMere = acteCelibataire.getNomMere();
        this.createdBy = acteCelibataire.getCreatedBy();
    }
}
