package com.back.commune.model.mariage;

import com.back.commune.model.PremierCopie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="mariage_interne")
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorColumn(name="Interne-Interne")
public class MariageAllInterne extends Mariage {
    @ManyToOne
    @JoinColumn(name="idPremierCopieHomme")
    private PremierCopie homme;
    @ManyToOne
    @JoinColumn(name="idPremierCopieFemme")
    private PremierCopie femme;
    public MariageAllInterne(Mariage mariage, PremierCopie homme, PremierCopie femme) {
        super(mariage);
        this.homme = homme;
        this.femme = femme;
    }
}
