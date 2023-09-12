package com.back.commune.model;

import javax.persistence.*;

@Entity
@Table(name="poste")
public class Poste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPoste")
	private long idPoste;

	@Column(name = "nomPoste")
	private String nomPoste;

	@Column(name = "descriptionPoste")
	private String descriptionPoste;

	public long getIdPoste() {
		return idPoste;
	}

	public void setIdPoste(long idPoste) {
		this.idPoste = idPoste;
	}

	public String getNomPoste() {
		return nomPoste;
	}

	public void setNomPoste(String nomPoste) {
		this.nomPoste = nomPoste;
	}

	public String getDescriptionPoste() {
		return descriptionPoste;
	}

	public void setDescriptionPoste(String descriptionPoste) {
		this.descriptionPoste = descriptionPoste;
	}

	public Poste(String nomPoste, String descriptionPoste) {
		this.nomPoste = nomPoste;
		this.descriptionPoste = descriptionPoste;
	}

	public Poste() {
		super();
		// TODO Auto-generated constructor stub
	}


}
