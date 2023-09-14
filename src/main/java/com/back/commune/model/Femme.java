package com.back.commune.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="femme")
@JsonInclude(Include.NON_NULL)
public class Femme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFemme")
	private long idFemme;

	@Column(name = "nationalite")
	private String nationaliteFemme;

	@Column(name = "nom")
	private String nomFemme;

	@Column(name = "prenoms")
	private String prenomsFemme;

	@Column(name = "profession")
	private String professionFemme;

	@Column(name = "datenaiss")
	private String dateNaissFemme;

	@Column(name = "lieunaiss")
	private String lieuNaissFemme;

	@Column(name = "adresse")
	private String adresseFemme;

	@Column(name = "type")
	private String typeFemme;

	@ManyToOne()
	@JoinColumn(name = "idMere")
	private Mere mereFemme;

	@ManyToOne()
	@JoinColumn(name = "idPere")
	private Pere pereFemme;
	public Femme( String nationaliteFemme, String nomFemme, String prenomsFemme, String professionFemme,
			String dateNaissFemme, String lieuNaissFemme, String adresseFemme, String typeFemme, Mere mereFemme,
			Pere pereFemme) {

		this.nationaliteFemme = nationaliteFemme;
		this.nomFemme = nomFemme;
		this.prenomsFemme = prenomsFemme;
		this.professionFemme = professionFemme;
		this.dateNaissFemme = dateNaissFemme;
		this.lieuNaissFemme = lieuNaissFemme;
		this.adresseFemme = adresseFemme;
		this.typeFemme = typeFemme;
		this.mereFemme = mereFemme;
		this.pereFemme = pereFemme;
	}
}
