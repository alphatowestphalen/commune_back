package com.example.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pieceJustificative")
public class PieceJustificative {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPieceJustificative")
	private long idPieceJustificative;
	
	@Column(name = "certificatAccouch")
	private Boolean certificatAccouch;
	
	@Column(name = "livretFamille")
	private Boolean livretFamille;
	
	@Column(name = "cinMere")
	private Boolean cinMere;
	
	@Column(name = "cinDeclarant")
	private Boolean cinDeclarant;

	public Boolean getCertificatAccouch() {
		return certificatAccouch;
	}

	public void setCertificatAccouch(Boolean certificatAccouch) {
		this.certificatAccouch = certificatAccouch;
	}

	public Boolean getLivretFamille() {
		return livretFamille;
	}

	public void setLivretFamille(Boolean livretFamille) {
		this.livretFamille = livretFamille;
	}

	public Boolean getCinMere() {
		return cinMere;
	}

	public void setCinMere(Boolean cinMere) {
		this.cinMere = cinMere;
	}

	public Boolean getCinDeclarant() {
		return cinDeclarant;
	}

	public void setCinDeclarant(Boolean cinDeclarant) {
		this.cinDeclarant = cinDeclarant;
	}

	public PieceJustificative(Boolean certificatAccouch, Boolean livretFamille, Boolean cinMere, Boolean cinDeclarant) {
		this.certificatAccouch = certificatAccouch;
		this.livretFamille = livretFamille;
		this.cinMere = cinMere;
		this.cinDeclarant = cinDeclarant;
	}

	public PieceJustificative() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
