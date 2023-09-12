package com.back.commune.model;

import javax.persistence.*;

@Entity
@Table(name="pieceDeces")
public class PieceDeces {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPieceDeces")
	private long idPieceDeces;

	@Column(name = "nomPiece")
	private boolean nomPiece;

	public long getIdPieceDeces() {
		return idPieceDeces;
	}

	public void setIdPieceDeces(long idPieceDeces) {
		this.idPieceDeces = idPieceDeces;
	}

	public boolean isNomPiece() {
		return nomPiece;
	}

	public void setNomPiece(boolean nomPiece) {
		this.nomPiece = nomPiece;
	}

	public PieceDeces(boolean nomPiece) {
		this.nomPiece = nomPiece;
	}

	public PieceDeces() {
		super();
		// TODO Auto-generated constructor stub
	}


}
