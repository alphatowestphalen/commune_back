package com.example.demo.request;

import com.example.demo.model.demande.TypeDemande;

public class DemandeEtatCivileRequest {
    private String idPremierCopie;
    private TypeDemande typeDemande;


    public DemandeEtatCivileRequest(String idPremierCopie, TypeDemande typeDemande) {
        this.idPremierCopie = idPremierCopie;
        this.typeDemande = typeDemande;
    }

    public DemandeEtatCivileRequest() {
    }

    public String getIdPremierCopie() {
        return idPremierCopie;
    }

    public void setIdPremierCopie(String idPremierCopie) {
        this.idPremierCopie = idPremierCopie;
    }

    public TypeDemande getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(TypeDemande typeDemande) {
        this.typeDemande = typeDemande;
    }
}
