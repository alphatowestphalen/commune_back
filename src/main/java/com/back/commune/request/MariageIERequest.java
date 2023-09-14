package com.back.commune.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MariageIERequest extends  MariageRequest {


    private String idPremierCopieHomme;
    // Info Femme

    private String nationaliteFemme;

    private String nomFemme;

    private String prenomsFemme;

    private String professionFemme;

    @JsonFormat(pattern ="dd/MM/yyyy")
    private String dateNaissFemme;

    private String lieuNaissFemme;

    private String adresseFemme;

    private String typeFemme;


    // PERE FEMME
    private Long idPereFemme;

    private String nomPereFemme;

    private String prenomsPereFemme;

    private String dateNaissPereFemme;

    private String  lieuNaissPereFemme;

    private String professionPereFemme;

    private String adressePereFemme;


    //MERE FEMME

    private long idMereFemme;

    private String nomMereFemme;

    private String prenomsMereFemme;

    private String dateNaissMereFemme;

    private String lieuNaissMereFemme;

    private String professionMereFemme;

    private String adresseMereFemme;
}
