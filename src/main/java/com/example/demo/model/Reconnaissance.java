package com.example.demo.model;

import java.time.Instant;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="reconnaissance")
public class Reconnaissance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReconnaissance")
	private long idReconnaissance;
	
	@Column(name = "dateDeclaration")
	private String dateDeclaration;
	
	@Column(name = "heureDeclaration")
	private String heureDeclaration;
	
	@Column(name = "infoPersonDeclarant")
	private String infoPersonDeclarant;
	
	@CreatedDate
	private Instant createdDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPremierCopie")
	@JsonManagedReference
	private PremierCopie premierCopie;

	public long getIdReconnaissance() {
		return idReconnaissance;
	}

	public void setIdReconnaissance(long idReconnaissance) {
		this.idReconnaissance = idReconnaissance;
	}

	public String getDateDeclaration() {
		return dateDeclaration;
	}

	public void setDateDeclaration(String dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}

	public String getHeureDeclaration() {
		return heureDeclaration;
	}

	public void setHeureDeclaration(String heureDeclaration) {
		this.heureDeclaration = heureDeclaration;
	}

	public String getInfoPersonDeclarant() {
		return infoPersonDeclarant;
	}

	public void setInfoPersonDeclarant(String infoPersonDeclarant) {
		this.infoPersonDeclarant = infoPersonDeclarant;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	
	public PremierCopie getPremierCopie() {
		return premierCopie;
	}

	public void setPremierCopie(PremierCopie premierCopie) {
		this.premierCopie = premierCopie;
	}

	public Reconnaissance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reconnaissance( String dateDeclaration, String heureDeclaration,
			String infoPersonDeclarant, Instant createdDate, PremierCopie premierCopie) {
		this.dateDeclaration = dateDeclaration;
		this.heureDeclaration = heureDeclaration;
		this.infoPersonDeclarant = infoPersonDeclarant;
		this.createdDate = createdDate;
		this.premierCopie = premierCopie;
	}

	
}
