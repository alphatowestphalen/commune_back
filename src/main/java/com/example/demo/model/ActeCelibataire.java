package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="acteCelibataire")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idActeCelibataire")
public class ActeCelibataire {
	
	@Id
	@Column(name = "idActeCelibataire")
	private String idActeCelibataire;
	
	@ManyToOne
	@JoinColumn(name="idPremierCopie")
	private PremierCopie premierCopie;
	
	@Column(name="numCin")
	private String numCin;
	
	@Column(name="dateCin")
	private String dateCin;
	
	@Column(name="lieuCin")
	private String lieuCin;
	
	@Column(name="dateDelivrance")
	private String dateDelivrance;

	public String getIdActeCelibataire() {
		return idActeCelibataire;
	}

	public void setIdActeCelibataire(String idActeCelibataire) {
		this.idActeCelibataire = idActeCelibataire;
	}

	public PremierCopie getPremierCopie() {
		return premierCopie;
	}

	public void setPremierCopie(PremierCopie premierCopie) {
		this.premierCopie = premierCopie;
	}

	public String getNumCin() {
		return numCin;
	}

	public void setNumCin(String numCin) {
		this.numCin = numCin;
	}

	public String getDateCin() {
		return dateCin;
	}

	public void setDateCin(String dateCin) {
		this.dateCin = dateCin;
	}

	public String getLieuCin() {
		return lieuCin;
	}

	public void setLieuCin(String lieuCin) {
		this.lieuCin = lieuCin;
	}

	public String getDateDelivrance() {
		return dateDelivrance;
	}

	public void setDateDelivrance(String dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}

	public ActeCelibataire(String idActeCelibataire, PremierCopie premierCopie, String numCin, String dateCin,
			String lieuCin, String dateDelivrance) {
		this.idActeCelibataire = idActeCelibataire;
		this.premierCopie = premierCopie;
		this.numCin = numCin;
		this.dateCin = dateCin;
		this.lieuCin = lieuCin;
		this.dateDelivrance = dateDelivrance;
	}

	public ActeCelibataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
