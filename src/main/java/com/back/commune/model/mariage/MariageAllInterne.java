package com.back.commune.model.mariage;

import com.back.commune.model.PremierCopie;

import javax.persistence.*;


@Entity
@Table(name="mariage_interne")
@DiscriminatorColumn(name="Interne-Interne")
public class MariageAllInterne extends Mariage {
    @ManyToOne
    @JoinColumn(name="idPremierCopieHomme")
    private PremierCopie homme;

    @ManyToOne
    @JoinColumn(name="idPremierCopieFemme")
    private PremierCopie femme;

    public MariageAllInterne() {

    }

    public PremierCopie getHomme() {
        return homme;
    }

    public void setHomme(PremierCopie homme) {
        this.homme = homme;
    }

    public PremierCopie getFemme() {
        return femme;
    }

    public void setFemme(PremierCopie femme) {
        this.femme = femme;
    }

    public MariageAllInterne(Mariage mariage, PremierCopie homme, PremierCopie femme) {
        super(mariage);
        this.homme = homme;
        this.femme = femme;
    }
}
