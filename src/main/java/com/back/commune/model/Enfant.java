package com.back.commune.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="enfant")
@Getter
@Setter
@NoArgsConstructor
public class Enfant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEnfant")
	private long idEnfant;

	@Column(name = "nomEnfant")
	private String nomEnfant;

	@Column(name = "prenomsEnfant")
	private String prenomsEnfant;

	@Column(name = "datenaissEnfant")
	private String datenaissEnfant;

	@Column(name = "lieunaissEnfant")
	private String lieunaissEnfant;

	@Column(name = "heurenaissEnfant")
	private String heurenaissEnfant;

	@Column(name = "sexeEnfant")
	private String sexeEnfant;

	@Column(name = "dateEnfant")
	private String dateEnfant;
	public Enfant(String nomEnfant, String prenomsEnfant, String datenaissEnfant, String lieunaissEnfant,
			String heurenaissEnfant, String sexeEnfant, String dateEnfant) {
		this.nomEnfant = nomEnfant;
		this.prenomsEnfant = prenomsEnfant;
		this.datenaissEnfant = datenaissEnfant;
		this.lieunaissEnfant = lieunaissEnfant;
		this.heurenaissEnfant = heurenaissEnfant;
		this.sexeEnfant = sexeEnfant;
		this.dateEnfant = dateEnfant;
	}
}
