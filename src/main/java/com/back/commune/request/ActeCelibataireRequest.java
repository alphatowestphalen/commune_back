package com.back.commune.request;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActeCelibataireRequest {
    private String nomFkt;
    private String chefFkt;
    private String numCin;
	private String dateCin;
	private String lieuCin;
	private String dateActe;
    private String idPremierCopie;
}
