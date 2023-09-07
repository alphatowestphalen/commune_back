package com.example.demo.request;

import com.example.demo.model.demande.TypeDemande;

public class DemandeEtatCivileRequest {
    private String idPremierCopie;
    private TypeDemande typeDemande;

    private Long createdBy;

    public DemandeEtatCivileRequest(String idPremierCopie, TypeDemande typeDemande, Long createdBy) {
        this.idPremierCopie = idPremierCopie;
        this.typeDemande = typeDemande;
        this.createdBy = createdBy;
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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
}
