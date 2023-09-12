package com.back.commune.request;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MariageEERequest extends  MariageRequest{

    // Info Homme

    private String nationaliteHomme;

    private String idPremierCopieHomme;

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

    private String adressePereHomme;


    //MERE HOMME

    private long idMereHomme;

    private String nomMereHomme;

    private String prenomsMereHomme;

    private String dateNaissMereHomme;

    private String lieuNaissMereHomme;

    private String professionMereHomme;

    private String adresseMereHomme;


    // Info Femme

    private String idPremierCopieFemme;

    private String nationaliteFemme;

    private String nomFemme;

    private String prenomsFemme;

    private String professionFemme;

    @JsonFormat(pattern ="dd/MM/yyyy")
    private String dateNaissFemme;

    private String lieuNaissFemme;

    private String adresseFemme;


    // PERE FEMME
    private long idPereFemme;

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

    public String getNationaliteHomme() {
        return nationaliteHomme;
    }

    public void setNationaliteHomme(String nationaliteHomme) {
        this.nationaliteHomme = nationaliteHomme;
    }

    public String getIdPremierCopieHomme() {
        return idPremierCopieHomme;
    }

    public void setIdPremierCopieHomme(String idPremierCopieHomme) {
        this.idPremierCopieHomme = idPremierCopieHomme;
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

    public String getAdressePereHomme() {
        return adressePereHomme;
    }

    public void setAdressePereHomme(String adressePereHomme) {
        this.adressePereHomme = adressePereHomme;
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

    public String getIdPremierCopieFemme() {
        return idPremierCopieFemme;
    }

    public void setIdPremierCopieFemme(String idPremierCopieFemme) {
        this.idPremierCopieFemme = idPremierCopieFemme;
    }

    public String getNationaliteFemme() {
        return nationaliteFemme;
    }

    public void setNationaliteFemme(String nationaliteFemme) {
        this.nationaliteFemme = nationaliteFemme;
    }

    public String getNomFemme() {
        return nomFemme;
    }

    public void setNomFemme(String nomFemme) {
        this.nomFemme = nomFemme;
    }

    public String getPrenomsFemme() {
        return prenomsFemme;
    }

    public void setPrenomsFemme(String prenomsFemme) {
        this.prenomsFemme = prenomsFemme;
    }

    public String getProfessionFemme() {
        return professionFemme;
    }

    public void setProfessionFemme(String professionFemme) {
        this.professionFemme = professionFemme;
    }

    public String getDateNaissFemme() {
        return dateNaissFemme;
    }

    public void setDateNaissFemme(String dateNaissFemme) {
        this.dateNaissFemme = dateNaissFemme;
    }

    public String getLieuNaissFemme() {
        return lieuNaissFemme;
    }

    public void setLieuNaissFemme(String lieuNaissFemme) {
        this.lieuNaissFemme = lieuNaissFemme;
    }

    public String getAdresseFemme() {
        return adresseFemme;
    }

    public void setAdresseFemme(String adresseFemme) {
        this.adresseFemme = adresseFemme;
    }

    public long getIdPereFemme() {
        return idPereFemme;
    }

    public void setIdPereFemme(long idPereFemme) {
        this.idPereFemme = idPereFemme;
    }

    public String getNomPereFemme() {
        return nomPereFemme;
    }

    public void setNomPereFemme(String nomPereFemme) {
        this.nomPereFemme = nomPereFemme;
    }

    public String getPrenomsPereFemme() {
        return prenomsPereFemme;
    }

    public void setPrenomsPereFemme(String prenomsPereFemme) {
        this.prenomsPereFemme = prenomsPereFemme;
    }

    public String getDateNaissPereFemme() {
        return dateNaissPereFemme;
    }

    public void setDateNaissPereFemme(String dateNaissPereFemme) {
        this.dateNaissPereFemme = dateNaissPereFemme;
    }

    public String getLieuNaissPereFemme() {
        return lieuNaissPereFemme;
    }

    public void setLieuNaissPereFemme(String lieuNaissPereFemme) {
        this.lieuNaissPereFemme = lieuNaissPereFemme;
    }

    public String getProfessionPereFemme() {
        return professionPereFemme;
    }

    public void setProfessionPereFemme(String professionPereFemme) {
        this.professionPereFemme = professionPereFemme;
    }

    public String getAdressePereFemme() {
        return adressePereFemme;
    }

    public void setAdressePereFemme(String adressePereFemme) {
        this.adressePereFemme = adressePereFemme;
    }

    public long getIdMereFemme() {
        return idMereFemme;
    }

    public void setIdMereFemme(long idMereFemme) {
        this.idMereFemme = idMereFemme;
    }

    public String getNomMereFemme() {
        return nomMereFemme;
    }

    public void setNomMereFemme(String nomMereFemme) {
        this.nomMereFemme = nomMereFemme;
    }

    public String getPrenomsMereFemme() {
        return prenomsMereFemme;
    }

    public void setPrenomsMereFemme(String prenomsMereFemme) {
        this.prenomsMereFemme = prenomsMereFemme;
    }

    public String getDateNaissMereFemme() {
        return dateNaissMereFemme;
    }

    public void setDateNaissMereFemme(String dateNaissMereFemme) {
        this.dateNaissMereFemme = dateNaissMereFemme;
    }

    public String getLieuNaissMereFemme() {
        return lieuNaissMereFemme;
    }

    public void setLieuNaissMereFemme(String lieuNaissMereFemme) {
        this.lieuNaissMereFemme = lieuNaissMereFemme;
    }

    public String getProfessionMereFemme() {
        return professionMereFemme;
    }

    public void setProfessionMereFemme(String professionMereFemme) {
        this.professionMereFemme = professionMereFemme;
    }

    public String getAdresseMereFemme() {
        return adresseMereFemme;
    }

    public void setAdresseMereFemme(String adresseMereFemme) {
        this.adresseMereFemme = adresseMereFemme;
    }
}
