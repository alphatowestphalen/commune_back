package com.back.commune.request;

import java.time.Instant;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class DecesRequest {

	private String dateDeclaration;
    private String idPremierCopie;

	private String heureDeclaration;

	private String nomDeclarant;

	private String prenomsDeclarant;

	private String professionDeclarant;

	private String lieuNaissanceDeclarant;

	private String adresseDeclarant;

	private String dateNaissanceDeclarant;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String date;

	private long idMaire;

	private String professionDefunt;

	private String adresseDefunt;

	private String dateDeces;

	private String lieuDeces;

	private String heureDeces;

	private boolean nomPiece;
}
