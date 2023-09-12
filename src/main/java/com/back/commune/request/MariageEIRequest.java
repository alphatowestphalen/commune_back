package com.back.commune.request;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    public String getIdPremierCopieFemme() {
        return idPremierCopieFemme;
    }

    public void setIdPremierCopieFemme(String idPremierCopieFemme) {
        this.idPremierCopieFemme = idPremierCopieFemme;
    }

    public String getNationaliteHomme() {
        return nationaliteHomme;
    }

    public void setNationaliteHomme(String nationaliteHomme) {
        this.nationaliteHomme = nationaliteHomme;
    }

    public String getNomHomme() {
        return nomHomme;
    }

    public void setNomHomme(String nomHomme) {
        this.nomHomme = nomHomme;
    }

    public String getPrenomsHomme() {
        return prenomsHomme;
    }

    public void setPrenomsHomme(String prenomsHomme) {
        this.prenomsHomme = prenomsHomme;
    }

    public String getProfessionHomme() {
        return professionHomme;
    }

    public void setProfessionHomme(String professionHomme) {
        this.professionHomme = professionHomme;
    }

    public String getDateNaissHomme() {
        return dateNaissHomme;
    }

    public void setDateNaissHomme(String dateNaissHomme) {
        this.dateNaissHomme = dateNaissHomme;
    }

    public String getLieuNaissHomme() {
        return lieuNaissHomme;
    }

    public void setLieuNaissHomme(String lieuNaissHomme) {
        this.lieuNaissHomme = lieuNaissHomme;
    }

    public String getAdresseHomme() {
        return adresseHomme;
    }

    public void setAdresseHomme(String adresseHomme) {
        this.adresseHomme = adresseHomme;
    }

    public String getTypeHomme() {
        return typeHomme;
    }

    public void setTypeHomme(String typeHomme) {
        this.typeHomme = typeHomme;
    }

    public long getIdPereHomme() {
        return idPereHomme;
    }

    public void setIdPereHomme(long idPereHomme) {
        this.idPereHomme = idPereHomme;
    }

    public String getNomPereHomme() {
        return nomPereHomme;
    }

    public void setNomPereHomme(String nomPereHomme) {
        this.nomPereHomme = nomPereHomme;
    }

    public String getPrenomsPereHomme() {
        return prenomsPereHomme;
    }

    public void setPrenomsPereHomme(String prenomsPereHomme) {
        this.prenomsPereHomme = prenomsPereHomme;
    }

    public String getDateNaissPereHomme() {
        return dateNaissPereHomme;
    }

    public void setDateNaissPereHomme(String dateNaissPereHomme) {
        this.dateNaissPereHomme = dateNaissPereHomme;
    }

    public String getLieuNaissPereHomme() {
        return lieuNaissPereHomme;
    }

    public void setLieuNaissPereHomme(String lieuNaissPereHomme) {
        this.lieuNaissPereHomme = lieuNaissPereHomme;
    }

    public String getProfessionPereHomme() {
        return professionPereHomme;
    }

    public void setProfessionPereHomme(String professionPereHomme) {
        this.professionPereHomme = professionPereHomme;
    }

    public String getAdressPereHomme() {
        return adressPereHomme;
    }

    public void setAdressPereHomme(String adressPereHomme) {
        this.adressPereHomme = adressPereHomme;
    }

    public long getIdMereHomme() {
        return idMereHomme;
    }

    public void setIdMereHomme(long idMereHomme) {
        this.idMereHomme = idMereHomme;
    }

    public String getNomMereHomme() {
        return nomMereHomme;
    }

    public void setNomMereHomme(String nomMereHomme) {
        this.nomMereHomme = nomMereHomme;
    }

    public String getPrenomsMereHomme() {
        return prenomsMereHomme;
    }

    public void setPrenomsMereHomme(String prenomsMereHomme) {
        this.prenomsMereHomme = prenomsMereHomme;
    }

    public String getDateNaissMereHomme() {
        return dateNaissMereHomme;
    }

    public void setDateNaissMereHomme(String dateNaissMereHomme) {
        this.dateNaissMereHomme = dateNaissMereHomme;
    }

    public String getLieuNaissMereHomme() {
        return lieuNaissMereHomme;
    }

    public void setLieuNaissMereHomme(String lieuNaissMereHomme) {
        this.lieuNaissMereHomme = lieuNaissMereHomme;
    }

    public String getProfessionMereHomme() {
        return professionMereHomme;
    }

    public void setProfessionMereHomme(String professionMereHomme) {
        this.professionMereHomme = professionMereHomme;
    }

    public String getAdresseMereHomme() {
        return adresseMereHomme;
    }

    public void setAdresseMereHomme(String adresseMereHomme) {
        this.adresseMereHomme = adresseMereHomme;
    }
}
