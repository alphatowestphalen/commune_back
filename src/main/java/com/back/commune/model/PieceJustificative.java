package com.back.commune.model;



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
	private boolean certificatAccouch;

	@Column(name = "livretFamille")
	private boolean livretFamille;

	@Column(name = "cinMere")
	private boolean cinMere;

	@Column(name = "cinDeclarant")
	private boolean cinDeclarant;

	public long getIdPieceJustificative() {
		return idPieceJustificative;
	}

	public void setIdPieceJustificative(long idPieceJustificative) {
		this.idPieceJustificative = idPieceJustificative;
	}

	public boolean isCertificatAccouch() {
		return certificatAccouch;
	}

	public void setCertificatAccouch(boolean certificatAccouch) {
		this.certificatAccouch = certificatAccouch;
	}

	public boolean isLivretFamille() {
		return livretFamille;
	}

	public void setLivretFamille(boolean livretFamille) {
		this.livretFamille = livretFamille;
	}

	public boolean isCinMere() {
		return cinMere;
	}

	public void setCinMere(boolean cinMere) {
		this.cinMere = cinMere;
	}

	public boolean isCinDeclarant() {
		return cinDeclarant;
	}

	public void setCinDeclarant(boolean cinDeclarant) {
		this.cinDeclarant = cinDeclarant;
	}


	public PieceJustificative(boolean certificatAccouch, boolean livretFamille, boolean cinMere, boolean cinDeclarant) {
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
