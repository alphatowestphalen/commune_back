package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="premierCopie")
public class PremierCopie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPremierCopie")
	private long idPremierCopie;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "mention")
	private String mention;
	
	@ManyToOne()
	  @JoinColumn(name ="idDeclarant")
	 private Declarant declarant;
	
	@ManyToOne()
	  @JoinColumn(name = "idMaire")
	  private Maire maire;
	
	@ManyToOne()
	  @JoinColumn(name = "idMere")
	  @JsonIgnore
	  private Mere mere;
	
	@ManyToOne()
	  @JoinColumn(name = "idPere")
	  @JsonIgnore
	  private Pere pere;
	
	@ManyToOne()
	  @JoinColumn(name = "idPersonne")
	  @JsonIgnore
	  private Personne personne;
	
	@ManyToOne()
	  @JoinColumn(name = "idPieceJustificative")
	  @JsonIgnore
	  private PieceJustificative pieceJustificative;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMention() {
		return mention;
	}

	public void setMention(String mention) {
		this.mention = mention;
	}

	public Declarant getDeclarant() {
		return declarant;
	}

	public void setDeclarant(Declarant declarant) {
		this.declarant = declarant;
	}

	public Maire getMaire() {
		return maire;
	}

	public void setMaire(Maire maire) {
		this.maire = maire;
	}

	public Mere getMere() {
		return mere;
	}

	public void setMere(Mere mere) {
		this.mere = mere;
	}

	public Pere getPere() {
		return pere;
	}

	public void setPere(Pere pere) {
		this.pere = pere;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public PieceJustificative getPieceJustificative() {
		return pieceJustificative;
	}

	public void setPieceJustificative(PieceJustificative pieceJustificative) {
		this.pieceJustificative = pieceJustificative;
	}

	public PremierCopie(String description, String mention, Declarant declarant, Maire maire, Mere mere, Pere pere,
			Personne personne, PieceJustificative pieceJustificative) {
		this.description = description;
		this.mention = mention;
		this.declarant = declarant;
		this.maire = maire;
		this.mere = mere;
		this.pere = pere;
		this.personne = personne;
		this.pieceJustificative = pieceJustificative;
	}

	public PremierCopie() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
