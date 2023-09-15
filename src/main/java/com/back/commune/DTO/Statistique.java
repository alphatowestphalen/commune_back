package com.back.commune.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Statistique {
    private StatistiqueAdoption adoption;
    private StatistiqueJugement jugement;
    private StatistiqueMariage mariage;
    private StatistiquePremierCopie premierCopie;
    private StatistiqueBulletinNaiss bulletinNaissance;
    private StatistiaqueDeces acteDeces;
    private StatistiqueReconnaissance reconnaissance;
}
