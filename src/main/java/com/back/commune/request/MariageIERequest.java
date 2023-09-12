package com.back.commune.request;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    public String getIdPremierCopieHomme() {
        return idPremierCopieHomme;
    }

    public void setIdPremierCopieHomme(String idPremierCopieHomme) {
        this.idPremierCopieHomme = idPremierCopieHomme;
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

    public void setDateNaissFemme(String datenaissFemme) {
        this.dateNaissFemme = datenaissFemme;
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

    public String getTypeFemme() {
        return typeFemme;
    }

    public void setTypeFemme(String typeFemme) {
        this.typeFemme = typeFemme;
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

    public void setLieunaissMereFemme(String lieuNaissMereFemme) {
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
