package com.example.demo.model.demande;

import com.example.demo.model.Maire;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.auth.User;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "demande_etat_civile")
public class DemandeEtatCivile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDemande;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPremierCopie")
    private PremierCopie premierCopie;
    @Enumerated(EnumType.STRING)
    private TypeDemande typeDemande;

    @CreatedDate
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "maire_id_maire")
    private Maire maire;


    public Maire getMaire() {
        return maire;
    }

    public void setMaire(Maire maire) {
        this.maire = maire;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Long getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Long idDemande) {
        this.idDemande = idDemande;
    }

    public PremierCopie getPremierCopie() {
        return premierCopie;
    }

    public void setPremierCopie(PremierCopie premierCopie) {
        this.premierCopie = premierCopie;
    }

    public TypeDemande getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(TypeDemande typeDemande) {
        this.typeDemande = typeDemande;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public DemandeEtatCivile() {
    }

    public DemandeEtatCivile(Long idDemande, PremierCopie premierCopie, TypeDemande typeDemande, Instant createdAt, User createdBy, Maire maire) {
        this.idDemande = idDemande;
        this.premierCopie = premierCopie;
        this.typeDemande = typeDemande;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.maire = maire;
    }

    public DemandeEtatCivile(PremierCopie premierCopie, TypeDemande typeDemande, Instant createdAt, User createdBy, Maire maire) {
        this.premierCopie = premierCopie;
        this.typeDemande = typeDemande;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.maire = maire;
    }
}
