package com.back.commune.model.mariage;

import com.back.commune.model.Femme;
import com.back.commune.model.PremierCopie;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorColumn(name="Interne-Externe")
public class MariageMixteHomme extends Mariage {

    @ManyToOne
    @JoinColumn(name="homme")
    private PremierCopie homme;
    @ManyToOne()
    @JoinColumn(name ="idFemme")
    private Femme femme;

    public MariageMixteHomme() {

    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

    public PremierCopie getHomme() {
        return homme;
    }

    public void setHomme(PremierCopie homme) {
        this.homme = homme;
    }

    public MariageMixteHomme(Mariage mariage, PremierCopie homme, Femme femme) {
        super(mariage);
        this.homme = homme;
        this.femme = femme;
    }

}
