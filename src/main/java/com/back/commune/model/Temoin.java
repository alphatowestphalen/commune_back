package com.back.commune.model;

import javax.persistence.*;

@Entity
@Table(name="temoinMariage")
public class Temoin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTemoinMariage")
	private long idTemoinMariage;

	@Column(name = "nomTemoin")
	private String nomTemoin;

	@Column(name = "prenomsTemoin")
	private String prenomsTemoin;

	@Column(name = "professionTemoin")
	private String professionTemoin;

	@Column(name = "datenaissTemoin")
	private String datenaissTemoin;

	@Column(name = "lieunaissTemoin")
	private String lieunaissTemoin;

	@Column(name = "adresseTemoin")
	private String adresseTemoin;

	public long getIdTemoinMariage() {
		return idTemoinMariage;
	}

	public void setIdTemoinMariage(long idTemoinMariage) {
		this.idTemoinMariage = idTemoinMariage;
	}

	public String getNomTemoin() {
		return nomTemoin;
	}

	public void setNomTemoin(String nomTemoin) {
		this.nomTemoin = nomTemoin;
	}

	public String getPrenomsTemoin() {
		return prenomsTemoin;
	}

	public void setPrenomsTemoin(String prenomsTemoin) {
		this.prenomsTemoin = prenomsTemoin;
	}

	public String getProfessionTemoin() {
		return professionTemoin;
	}

	public void setProfessionTemoin(String professionTemoin) {
		this.professionTemoin = professionTemoin;
	}

	public String getDatenaissTemoin() {
		return datenaissTemoin;
	}

	public void setDatenaissTemoin(String datenaissTemoin) {
		this.datenaissTemoin = datenaissTemoin;
	}

	public String getLieunaissTemoin() {
		return lieunaissTemoin;
	}

	public void setLieunaissTemoin(String lieunaissTemoin) {
		this.lieunaissTemoin = lieunaissTemoin;
	}

	public String getAdresseTemoin() {
		return adresseTemoin;
	}

	public void setAdresseTemoin(String adresseTemoin) {
		this.adresseTemoin = adresseTemoin;
	}

	public Temoin(String nomTemoin, String prenomsTemoin, String professionTemoin, String datenaissTemoin,
			String lieunaissTemoin, String adresseTemoin) {
		this.nomTemoin = nomTemoin;
		this.prenomsTemoin = prenomsTemoin;
		this.professionTemoin = professionTemoin;
		this.datenaissTemoin = datenaissTemoin;
		this.lieunaissTemoin = lieunaissTemoin;
		this.adresseTemoin = adresseTemoin;
	}

	public Temoin() {
		super();
		// TODO Auto-generated constructor stub
	}


}
