package com.back.commune.model.mariage;

import com.back.commune.model.Femme;
import com.back.commune.model.Homme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="mariage_externe_externe")
@DiscriminatorColumn(name="Externe-Externe")
public class MariageAllExterne extends Mariage {
    @ManyToOne()
    @JoinColumn(name ="idHomme")
    private Homme homme;

    @ManyToOne()
    @JoinColumn(name ="idFemme")
    private Femme femme;
    public MariageAllExterne(Mariage mariage, Homme homme, Femme femme) {
        super(mariage);
        this.homme = homme;
        this.femme = femme;
    }
}
