package com.back.commune.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActeCelibataireRequestI {
    private String nomFkt;
    private String numCin;
	private String dateCin;
	private String lieuCin;
    private String idPremierCopie;
}
