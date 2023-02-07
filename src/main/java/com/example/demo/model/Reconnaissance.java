package com.example.demo.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "reconnaissances")
	@JsonIgnore
	private Set<PremierCopie> premierCopies = new HashSet<>();

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

	public Set<PremierCopie> getPremierCopies() {
		return premierCopies;
	}

	public void setPremierCopies(Set<PremierCopie> premierCopies) {
		this.premierCopies = premierCopies;
	}

	public Reconnaissance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reconnaissance(String dateDeclaration, String heureDeclaration, String infoPersonDeclarant,
			Instant createdDate, Set<PremierCopie> premierCopies) {
		this.dateDeclaration = dateDeclaration;
		this.heureDeclaration = heureDeclaration;
		this.infoPersonDeclarant = infoPersonDeclarant;
		this.createdDate = createdDate;
		this.premierCopies = premierCopies;
	}
	
	
}
