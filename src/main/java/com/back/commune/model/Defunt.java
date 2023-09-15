package com.back.commune.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="defunt")
@Getter
@Setter
@NoArgsConstructor
public class Defunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Defunt(String professionDefunt, String adresseDefunt, String dateDeces, String lieuDeces,
			String heureDeces) {
		this.professionDefunt = professionDefunt;
		this.adresseDefunt = adresseDefunt;
		this.dateDeces = dateDeces;
		this.lieuDeces = lieuDeces;
		this.heureDeces = heureDeces;
	}
}
