package com.back.commune.model.deces;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="defunt")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Defunt {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idDefunt")
	private long idDefunt;

	@Column(name = "professionDefunt")
	private String professionDefunt;

	@Column(name = "adresseDefunt")
	private String adresseDefunt;

	@Column(name = "dateDeces")
	private String dateDeces;

	@Column(name = "lieuDeces")
	private String lieuDeces;

	@Column(name = "heureDeces")
	private String heureDeces;

    private String dateEnterement;

    private String heureEnterement;

    private String lieuEnterement;

    private String communeEnterement;

    private String districtEnterement;

    private String regionEnterement;

    private String nomDefunt;

    private String PrenomDefunt;

    private String dateDeNaissDefunt;

    private String lieuDeNaissDefunt;

    private String cinDefunt;

    private String dateCinDefunt;

    private String lieuCinDefunt;

    private String nomMereDefunt;

    private String nomPereDefunt;

    private boolean FasanDehibe;
}
