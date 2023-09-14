package com.back.commune.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="temoinMariage")
public class Temoin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTemoinMariage")
	private long idTemoinMariage;

	@Column(name = "nomTemoin")
	private String nomTemoin;

	@Column(name = "prenomsTemoin")
	private String prenomsTemoin;

	@Column(name = "professionTemoin")
	private String professionTemoin;

	@Column(name = "datenaissTemoin")
	private String datenaissTemoin;

	@Column(name = "lieunaissTemoin")
	private String lieunaissTemoin;

	@Column(name = "adresseTemoin")
	private String adresseTemoin;

	public Temoin(String nomTemoin, String prenomsTemoin, String professionTemoin, String datenaissTemoin,
			String lieunaissTemoin, String adresseTemoin) {
		this.nomTemoin = nomTemoin;
		this.prenomsTemoin = prenomsTemoin;
		this.professionTemoin = professionTemoin;
		this.datenaissTemoin = datenaissTemoin;
		this.lieunaissTemoin = lieunaissTemoin;
		this.adresseTemoin = adresseTemoin;
	}
    @Override
    public String toString() {
        return "Temoin{" +
            "idTemoinMariage=" + idTemoinMariage +
            ", nomTemoin='" + nomTemoin + '\'' +
            '}';
    }
}
