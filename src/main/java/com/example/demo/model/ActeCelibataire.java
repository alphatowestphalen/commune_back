package com.example.demo.model;

import java.time.Instant;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="acteCelibataire")
public class ActeCelibataire {
	
	@Id
	@Column(name = "idActeCelibataire")
	private String idActeCelibataire;
	
	@Column(name = "nomFkt")
	private String nomFkt;
	
	@Column(name = "numCin")
	private String numCin;
	
	@Column(name = "dateCin")
	private String dateCin;
	
	@Column(name = "lieuCin")
	private String lieuCin;
	
	@Column(name = "dateActe")
	private String dateActe;
	 
	@ManyToOne
	@JoinColumn(name="idPremierCopie")
	private PremierCopie premierecopie;

	@Column(name = "numero")
	 private Long numero;
	 
	 @Column(name = "annee")
	 private int annee;
	 
	@CreatedDate
	private Instant createdDate;
	
	public String getIdActeCelibataire() {
		return idActeCelibataire;
	}

	public void setIdActeCelibataire(String idActeCelibataire) {
		this.idActeCelibataire = idActeCelibataire;
	}

	public String getNomFkt() {
		return nomFkt;
	}

	public void setNomFkt(String nomFkt) {
		this.nomFkt = nomFkt;
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

	public String getDateActe() {
		return dateActe;
	}

	public void setDateActe(String dateActe) {
		this.dateActe = dateActe;
	}

	public PremierCopie getPremierecopie() {
		return premierecopie;
	}

	public void setPremierecopie(PremierCopie premierecopie) {
		this.premierecopie = premierecopie;
	}

	
	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}


	public ActeCelibataire(String idActeCelibataire, String nomFkt, String numCin, String dateCin, String lieuCin,
			String dateActe, PremierCopie premierecopie, Long numero, int annee, Instant createdDate) {
		this.idActeCelibataire = idActeCelibataire;
		this.nomFkt = nomFkt;
		this.numCin = numCin;
		this.dateCin = dateCin;
		this.lieuCin = lieuCin;
		this.dateActe = dateActe;
		this.premierecopie = premierecopie;
		this.numero = numero;
		this.annee = annee;
		this.createdDate = createdDate;
	}

	public ActeCelibataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
