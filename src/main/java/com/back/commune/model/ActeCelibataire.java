package com.back.commune.model;

import java.time.Instant;

import javax.persistence.*;

import com.back.commune.model.auth.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="acteCelibataire")
public class ActeCelibataire {
	@Id
	@Column(name = "idActeCelibataire")
	private String idActeCelibataire;

	@Column(name = "nomFkt")
	private String nomFkt;

    @Column(name = "chefFkt")
    private String chefFkt;

	@Column(name = "numCin")
	private String numCin;

	@Column(name = "dateCin")
	private String dateCin;

	@Column(name = "lieuCin")
	private String lieuCin;

	@Column(name = "dateActe")
	private String dateActe;

	@ManyToOne
	@JoinColumn(name="idPremierCopie")
	private PremierCopie premierecopie;

	@Column(name = "numero")
    private Long numero;

    @Column(name = "annee")
    private int annee;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

	@CreationTimestamp
	private Instant createdDate;
	public ActeCelibataire(String idActeCelibataire, String nomFkt, String chefFkt, String numCin, String dateCin, String lieuCin,
			String dateActe, PremierCopie premierecopie, Long numero, int annee) {
		this.idActeCelibataire = idActeCelibataire;
		this.nomFkt = nomFkt;
		this.numCin = numCin;
		this.dateCin = dateCin;
        this.chefFkt = chefFkt;
		this.lieuCin = lieuCin;
		this.dateActe = dateActe;
		this.premierecopie = premierecopie;
		this.numero = numero;
		this.annee = annee;
	}
}
