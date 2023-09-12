package com.back.commune.model;

import javax.persistence.*;

@Entity
@Table(name="defunt")
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

	public long getIdDefunt() {
		return idDefunt;
	}

	public void setIdDefunt(long idDefunt) {
		this.idDefunt = idDefunt;
	}

	public String getProfessionDefunt() {
		return professionDefunt;
	}

	public void setProfessionDefunt(String professionDefunt) {
		this.professionDefunt = professionDefunt;
	}

	public String getAdresseDefunt() {
		return adresseDefunt;
	}

	public void setAdresseDefunt(String adresseDefunt) {
		this.adresseDefunt = adresseDefunt;
	}

	public String getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(String dateDeces) {
		this.dateDeces = dateDeces;
	}

	public String getLieuDeces() {
		return lieuDeces;
	}

	public void setLieuDeces(String lieuDeces) {
		this.lieuDeces = lieuDeces;
	}

	public String getHeureDeces() {
		return heureDeces;
	}

	public void setHeureDeces(String heureDeces) {
		this.heureDeces = heureDeces;
	}

	public Defunt(String professionDefunt, String adresseDefunt, String dateDeces, String lieuDeces,
			String heureDeces) {
		this.professionDefunt = professionDefunt;
		this.adresseDefunt = adresseDefunt;
		this.dateDeces = dateDeces;
		this.lieuDeces = lieuDeces;
		this.heureDeces = heureDeces;
	}

	public Defunt() {
		super();
		// TODO Auto-generated constructor stub
	}


}
