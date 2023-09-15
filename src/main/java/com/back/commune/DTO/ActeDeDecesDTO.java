package com.back.commune.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActeDeDecesDTO {
    private String nom;
    private String prenom;
    private String dateNaiss;
    private String lieuNaiss;
    private String numCin;
    private String dateCin;
    private String lieuCin;
    private String nomPere;
    private String nomMere;
    private String dateDeces;
    private String lieuDeces;
    private String dateActe;
    private String nomFktDeces;
    private String heureDeces;
}
