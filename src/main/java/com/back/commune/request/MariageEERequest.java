package com.back.commune.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MariageEERequest extends  MariageRequest{

    // Info Homme

    private String nationaliteHomme;

    private String nomHomme;

    private String prenomsHomme;

    private String professionHomme;

    @JsonFormat(pattern ="dd/MM/yyyy")
    private String dateNaissHomme;

    private String lieuNaissHomme;

    private String adresseHomme;

    // PERE HOMME
    private String nomPereHomme;

    private String prenomsPereHomme;

    private String dateNaissPereHomme;

    private String  lieuNaissPereHomme;

    private String professionPereHomme;

    private String adressePereHomme;


    //MERE HOMME
    private String nomMereHomme;

    private String prenomsMereHomme;

    private String dateNaissMereHomme;

    private String lieuNaissMereHomme;

    private String professionMereHomme;

    private String adresseMereHomme;


    // Info Femme
    private String nationaliteFemme;

    private String nomFemme;

    private String prenomsFemme;

    private String professionFemme;

    @JsonFormat(pattern ="dd/MM/yyyy")
    private String dateNaissFemme;

    private String lieuNaissFemme;

    private String adresseFemme;


    // PERE FEMME
    private String nomPereFemme;

    private String prenomsPereFemme;

    private String dateNaissPereFemme;

    private String  lieuNaissPereFemme;

    private String professionPereFemme;

    private String adressePereFemme;


    //MERE FEMME
    private String nomMereFemme;

    private String prenomsMereFemme;

    private String dateNaissMereFemme;

    private String lieuNaissMereFemme;

    private String professionMereFemme;

    private String adresseMereFemme;
}
