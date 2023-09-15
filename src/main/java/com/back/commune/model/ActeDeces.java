package com.back.commune.model;

import java.time.Instant;

import javax.persistence.*;

import com.back.commune.model.auth.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="acteDeces")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idActeDeces")
public class ActeDeces {
	@Id
	@Column(name = "idActeDeces")
	private String idActeDeces;

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

	@ManyToOne(cascade = CascadeType.PERSIST)
	  @JoinColumn(name = "idMaire")
	  private Maire maire;

	@ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name ="idDefunt")
	private Defunt defunt;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="idPieceDeces")
	private PieceDeces pieceDeces;

	@CreationTimestamp
	private Instant createdDate;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPremierCopie")
	private PremierCopie premierCopie;

	@Column(name = "numero")
    private Long numero;

    @Column(name = "annee")
    private int annee;

	public ActeDeces(String idActeDeces, String dateDeclaration, String heureDeclaration, String nomDeclarant,
			String prenomsDeclarant, String professionDeclarant, String lieuNaissanceDeclarant, String adresseDeclarant,
			String dateNaissanceDeclarant, String date, Maire maire, Defunt defunt, PieceDeces pieceDeces,
			PremierCopie premierCopie, long numero, int annee) {
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
		this.premierCopie = premierCopie;
		this.numero = numero;
		this.annee = annee;
	}
}
