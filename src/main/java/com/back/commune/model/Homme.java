package com.back.commune.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "homme")
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Homme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHomme")
	private long idHomme;

	@Column(name = "nationalite")
	private String nationaliteHomme;

	@Column(name = "nom")
	private String nomHomme;

	@Column(name = "prenoms")
	private String prenomsHomme;

	@Column(name = "profession")
	private String professionHomme;

	@Column(name = "datenaiss")
	private String dateNaissHomme;

	@Column(name = "lieunaiss")
	private String lieuNaissHomme;

	@Column(name = "adresse")
	private String adresseHomme;

	@Column(name = "type")
	private String typeHomme;

	@ManyToOne()
	@JoinColumn(name = "idMere")
	private Mere mereHomme;

	@ManyToOne()
	@JoinColumn(name = "idPere")
	private Pere pereHomme;

	public Homme( String nationaliteHomme, String nomHomme, String prenomsHomme, String professionHomme,
			String dateNaissHomme, String lieuNaissHomme, String adresseHomme, String typeHomme, Mere mereHomme,
			Pere pereHomme) {

		this.nationaliteHomme = nationaliteHomme;
		this.nomHomme = nomHomme;
		this.prenomsHomme = prenomsHomme;
		this.professionHomme = professionHomme;
		this.dateNaissHomme = dateNaissHomme;
		this.lieuNaissHomme = lieuNaissHomme;
		this.adresseHomme = adresseHomme;
		this.typeHomme = typeHomme;
		this.mereHomme = mereHomme;
		this.pereHomme = pereHomme;
	}

}
