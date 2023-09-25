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

    private String nomDefunt;

    private String prenomDefunt;

    private String dateDeNaissDefunt;

    private String lieuDeNaissDefunt;

    private String cinDefunt;

    private String dateCinDefunt;

    private String lieuCinDefunt;

	private String professionDefunt;

	private String adresseDefunt;

    private String nomMereDefunt;

    private String nomPereDefunt;

	private String dateDeces;

	private String lieuDeces;

	private String heureDeces;

    private String dateEnterement;

    private String heureEnterement;

    private String lieuEnterement;

    private String communeEnterement;

    private String regionEnterement;

    private boolean isFasanDehibe;

	private boolean nomPiece;
}
