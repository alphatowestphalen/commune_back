package com.back.commune.request;

public class MariageIIRequest extends  MariageRequest{

    private String idPremierCopieHomme;
    private String idPremierCopieFemme;

    public String getIdPremierCopieHomme() {
        return idPremierCopieHomme;
    }

    public void setIdPremierCopieHomme(String idPremierCopieHomme) {
        this.idPremierCopieHomme = idPremierCopieHomme;
    }

    public String getIdPremierCopieFemme() {
        return idPremierCopieFemme;
    }

    public void setIdPremierCopieFemme(String idPremierCopieFemme) {
        this.idPremierCopieFemme = idPremierCopieFemme;
    }
}
