package com.example.demo.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


import com.example.demo.model.auth.User;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.example.demo.utils.*;


@Entity
@Table(name="reconnaissance")
@EntityListeners(AuditTrailListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idReconnaissance")
public class Reconnaissance implements Serializable{

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

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

	@CreationTimestamp
	private Instant createdDate;

	@ManyToOne
	@JoinColumn(name="idPremierCopie")
	private PremierCopie premierecopie;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

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




	public PremierCopie getPremierecopie() {
		return premierecopie;
	}

	public void setPremierecopie(PremierCopie premierecopie) {
		this.premierecopie = premierecopie;
	}

	public Reconnaissance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reconnaissance( String dateDeclaration, String heureDeclaration,
			String infoPersonDeclarant, PremierCopie premierCopie) {
		this.dateDeclaration = dateDeclaration;
		this.heureDeclaration = heureDeclaration;
		this.infoPersonDeclarant = infoPersonDeclarant;
		this.premierecopie = premierCopie;
	}




}
