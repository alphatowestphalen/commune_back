package com.back.commune.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;


import com.back.commune.model.auth.User;
import com.back.commune.utils.AuditTrailListener;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="reconnaissance")
@EntityListeners(AuditTrailListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idReconnaissance")
public class Reconnaissance implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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

	@ManyToOne(fetch = FetchType.EAGER)
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

    @Override
    public String toString() {
        return "Reconnaissance{" +
            "idReconnaissance=" + idReconnaissance +
            ", dateDeclaration='" + dateDeclaration + '\'' +
            ", heureDeclaration='" + heureDeclaration + '\'' +
            ", infoPersonDeclarant='" + infoPersonDeclarant + '\'' +
            ", createdBy=" + createdBy +
            ", createdDate=" + createdDate +
            ", premierecopie=" + premierecopie.getEnfant() +
            '}';
    }
}
