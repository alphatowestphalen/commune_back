package com.back.commune.model.celibataire;

import java.time.Instant;

import javax.persistence.*;

import com.back.commune.model.PremierCopie;
import com.back.commune.model.auth.User;
import com.back.commune.model.mariage.GenreMariage;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name="acteCelibataire")
@AllArgsConstructor
public class ActeCelibataire {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "idActeCelibataire")
	private Long idActeCelibataire;

	@Column(name = "nomFkt")
	private String nomFkt;

    private String nom;

	@Column(name = "numCin")
	private String numCin;

	@Column(name = "dateCin")
	private String dateCin;

	@Column(name = "lieuCin")
	private String lieuCin;

    private String nomPere;

    private String nomMere;

    private String lieuDeNaiss;

    private String dateDeNaiss;

    @Enumerated(EnumType.STRING)
    private GenreMariage genre;

	@ManyToOne
	@JoinColumn(name="idPremierCopie")
	private PremierCopie premierecopie;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

	@CreationTimestamp
	private Instant createdDate;
}
