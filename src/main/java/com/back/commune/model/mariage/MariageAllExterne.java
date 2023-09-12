package com.back.commune.model.mariage;

import com.back.commune.model.Femme;
import com.back.commune.model.Homme;

import javax.persistence.*;

@Entity
@Table(name="mariage_externe_externe")
@DiscriminatorColumn(name="Externe-Externe")
public class MariageAllExterne extends Mariage {
    @ManyToOne()
    @JoinColumn(name ="idHomme")
    private Homme homme;

    @ManyToOne()
    @JoinColumn(name ="idFemme")
    private Femme femme;

    public MariageAllExterne() {

    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

    public MariageAllExterne(Mariage mariage, Homme homme, Femme femme) {
        super(mariage);
        this.homme = homme;
        this.femme = femme;
    }
}
