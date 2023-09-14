package com.back.commune.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MariageEIRequest extends  MariageRequest{
    private String idPremierCopieFemme;
    // Info Homme
    private String nationaliteHomme;

    private String nomHomme;

    private String prenomsHomme;

    private String professionHomme;

    @JsonFormat(pattern ="dd/MM/yyyy")
    private String dateNaissHomme;

    private String lieuNaissHomme;

    private String adresseHomme;

    private String typeHomme;

    // PERE HOMME
    private long idPereHomme;

    private String nomPereHomme;

    private String prenomsPereHomme;

    private String dateNaissPereHomme;

    private String  lieuNaissPereHomme;

    private String professionPereHomme;

    private String adressPereHomme;


    //MERE HOMME

    private long idMereHomme;

    private String nomMereHomme;

    private String prenomsMereHomme;

    private String dateNaissMereHomme;

    private String lieuNaissMereHomme;

    private String professionMereHomme;

    private String adresseMereHomme;
}
