package com.back.commune.request;

public class BulletinNaissanceRequest {
    private String idPremierCopie;
    private String type;
    private String nomPersonne;
    private String prenomsPersonne;
    private String dateNaissPersonne;
    private String lieuNaissPersonne;
    private String nomPere;
    private String prenomsPere;
    private String nomMere;
    private String prenomsMere;
    private String dateCopie;

    public String getIdPremierCopie() {
        return idPremierCopie;
    }

    public void setIdPremierCopie(String idPremierCopie) {
        this.idPremierCopie = idPremierCopie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNomPersonne() {
        return nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public String getPrenomsPersonne() {
        return prenomsPersonne;
    }

    public void setPrenomsPersonne(String prenomsPersonne) {
        this.prenomsPersonne = prenomsPersonne;
    }

    public String getDateNaissPersonne() {
        return dateNaissPersonne;
    }

    public void setDateNaissPersonne(String dateNaissPersonne) {
        this.dateNaissPersonne = dateNaissPersonne;
    }

    public String getLieuNaissPersonne() {
        return lieuNaissPersonne;
    }

    public void setLieuNaissPersonne(String lieuNaissPersonne) {
        this.lieuNaissPersonne = lieuNaissPersonne;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getPrenomsPere() {
        return prenomsPere;
    }

    public void setPrenomsPere(String prenomsPere) {
        this.prenomsPere = prenomsPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getPrenomsMere() {
        return prenomsMere;
    }

    public void setPrenomsMere(String prenomsMere) {
        this.prenomsMere = prenomsMere;
    }

    public String getDateCopie() {
        return dateCopie;
    }

    public void setDateCopie(String dateCopie) {
        this.dateCopie = dateCopie;
    }

    public BulletinNaissanceRequest() {
    }
}
