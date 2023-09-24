package com.back.commune.request;

import com.back.commune.model.mariage.GenreMariage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActeCelibataireRequestE {
    private String nomFkt;
    private String numCin;
    private String dateCin;
    private String lieuCin;
    private GenreMariage genre;

    private String nom;
    private String DateDeNaiss;
    private String lieuDeNaiss;
    private String nomPere;
    private String nomMere;
}
