package com.back.commune.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public abstract class MariageRequest{

	// temoin Homme
	private String nomTemoinHomme;

	private String prenomsTemoinHomme;

	private String professionTemoinHomme;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissTemoinHomme;

	private String lieunaissTemoinHomme;

	private String adresseTemoinHomme;


	// Temoin Femme

	private String nomTemoinFemme;

	private String prenomsTemoinFemme;

	private String professionTemoinFemme;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissTemoinFemme;

	private String lieunaissTemoinFemme;

	private String adresseTemoinFemme;

	private String description;

    private String numeroCopieMariage;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String dateMariage;

	private String heureMariage;

	private Long idMaire;
}
