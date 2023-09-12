package com.back.commune.model.mariage;

import com.back.commune.model.Homme;
import com.back.commune.model.PremierCopie;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name="Externe-Interne")
public class MariageMixteFemme extends Mariage {
    @ManyToOne
    @JoinColumn(name="femme")
    private PremierCopie femme;

    @ManyToOne()
    @JoinColumn(name ="idHomme")
    private Homme homme;

    public MariageMixteFemme() {

    }

    public PremierCopie getFemme() {
        return femme;
    }

    public void setFemme(PremierCopie femme) {
        this.femme = femme;
    }

    public Homme getHomme() {
        return homme;
    }

    public MariageMixteFemme(Mariage mariage, Homme homme,PremierCopie femme) {
        super(mariage);
        this.femme = femme;
        this.homme = homme;
    }
}
