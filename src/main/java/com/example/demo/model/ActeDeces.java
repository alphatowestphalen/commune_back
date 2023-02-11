package com.example.demo.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="acteDeces")
public class ActeDeces {

	@Id
	@Column(name = "idActeDeces")
	private long idActeDeces;
	
	@Column(name = "dateDeclaration")
	private String dateDeclaration;
	
	@Column(name = "heureDeclaration")
	private String heureDeclaration;
	
	@Column(name = "nomDeclarant")
	private String nomDeclarant;
	
	@Column(name = "prenomsDeclarant")
	private String prenomsDeclarant;
	
	@Column(name = "professionDeclarant")
	private String professionDeclarant;
	
	@Column(name = "lieuNaissanceDeclarant")
	private String lieuNaissanceDeclarant;
	
	@Column(name = "adresseDeclarant")
	private String adresseDeclarant;
	
	@Column(name = "dateNaissanceDeclarant")
	private String dateNaissanceDeclarant;
	
	@Column(name = "date")
	private String date;
	
	@ManyToOne()
	  @JoinColumn(name = "idMaire")
	  private Maire maire;
	
	@ManyToOne()
	  @JoinColumn(name ="idDefunt")
	private Defunt defunt;
	
	@ManyToOne()
	  @JoinColumn(name ="idPieceDeces")
	private PieceDeces pieceDeces;
	
	@CreatedDate
	private Instant createdDate;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "acteDeces")
	@JsonIgnore
	private Set<PremierCopie> premierCopies = new HashSet<>();

	public long getIdActeDeces() {
		return idActeDeces;
	}

	public void setIdActeDeces(long idActeDeces) {
		this.idActeDeces = idActeDeces;
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

	public String getNomDeclarant() {
		return nomDeclarant;
	}

	public void setNomDeclarant(String nomDeclarant) {
		this.nomDeclarant = nomDeclarant;
	}

	public String getPrenomsDeclarant() {
		return prenomsDeclarant;
	}

	public void setPrenomsDeclarant(String prenomsDeclarant) {
		this.prenomsDeclarant = prenomsDeclarant;
	}

	public String getProfessionDeclarant() {
		return professionDeclarant;
	}

	public void setProfessionDeclarant(String professionDeclarant) {
		this.professionDeclarant = professionDeclarant;
	}

	public String getLieuNaissanceDeclarant() {
		return lieuNaissanceDeclarant;
	}

	public void setLieuNaissanceDeclarant(String lieuNaissanceDeclarant) {
		this.lieuNaissanceDeclarant = lieuNaissanceDeclarant;
	}

	public String getAdresseDeclarant() {
		return adresseDeclarant;
	}

	public void setAdresseDeclarant(String adresseDeclarant) {
		this.adresseDeclarant = adresseDeclarant;
	}

	public String getDateNaissanceDeclarant() {
		return dateNaissanceDeclarant;
	}

	public void setDateNaissanceDeclarant(String dateNaissanceDeclarant) {
		this.dateNaissanceDeclarant = dateNaissanceDeclarant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Maire getMaire() {
		return maire;
	}

	public void setMaire(Maire maire) {
		this.maire = maire;
	}

	public Defunt getDefunt() {
		return defunt;
	}

	public void setDefunt(Defunt defunt) {
		this.defunt = defunt;
	}

	public PieceDeces getPieceDeces() {
		return pieceDeces;
	}

	public void setPieceDeces(PieceDeces pieceDeces) {
		this.pieceDeces = pieceDeces;
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

	public ActeDeces(long idActeDeces, String dateDeclaration, String heureDeclaration, String nomDeclarant,
			String prenomsDeclarant, String professionDeclarant, String lieuNaissanceDeclarant, String adresseDeclarant,
			String dateNaissanceDeclarant, String date, Maire maire, Defunt defunt, PieceDeces pieceDeces, Instant createdDate) {
		this.idActeDeces = idActeDeces;
		this.dateDeclaration = dateDeclaration;
		this.heureDeclaration = heureDeclaration;
		this.nomDeclarant = nomDeclarant;
		this.prenomsDeclarant = prenomsDeclarant;
		this.professionDeclarant = professionDeclarant;
		this.lieuNaissanceDeclarant = lieuNaissanceDeclarant;
		this.adresseDeclarant = adresseDeclarant;
		this.dateNaissanceDeclarant = dateNaissanceDeclarant;
		this.date = date;
		this.maire = maire;
		this.defunt = defunt;
		this.pieceDeces = pieceDeces;
		this.createdDate = createdDate;
	}

	public ActeDeces() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}