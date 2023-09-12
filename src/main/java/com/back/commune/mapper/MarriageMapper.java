package com.back.commune.mapper;

import com.back.commune.model.*;
import com.back.commune.model.mariage.GenreMariage;
import com.back.commune.model.mariage.Mariage;
import com.back.commune.model.mariage.MariageAllInterne;
import com.back.commune.request.*;
import org.springframework.stereotype.Service;

@Service
public class MarriageMapper {

    public Mariage extractMariage(MariageRequest request){
        Mariage mariage = new Mariage();
        mariage.setDateMariage(request.getDateMariage());
        mariage.setHeureMariage(request.getHeureMariage());
        mariage.setDescription(request.getDescription());
        mariage.setNumeroCopieMariage(request.getNumeroCopieMariage());
        return mariage;
    }

    public Temoin extractTemoin(MariageRequest request, GenreMariage genreMariage){
        Temoin temoin = new Temoin();
        if(genreMariage.equals(GenreMariage.HOMME)){
            temoin.setNomTemoin(request.getNomTemoinHomme());
            temoin.setDatenaissTemoin(request.getDatenaissTemoinHomme());
            temoin.setPrenomsTemoin(request.getPrenomsTemoinHomme());
            temoin.setAdresseTemoin(request.getAdresseTemoinHomme());
            temoin.setLieunaissTemoin(request.getLieunaissTemoinHomme());
            temoin.setProfessionTemoin(request.getProfessionTemoinHomme());
            return temoin;
        }
        else if(genreMariage.equals(GenreMariage.FEMME)){
            temoin.setNomTemoin(request.getNomTemoinFemme());
            temoin.setDatenaissTemoin(request.getDatenaissTemoinFemme());
            temoin.setPrenomsTemoin(request.getPrenomsTemoinFemme());
            temoin.setAdresseTemoin(request.getAdresseTemoinFemme());
            temoin.setLieunaissTemoin(request.getLieunaissTemoinFemme());
            temoin.setProfessionTemoin(request.getProfessionTemoinFemme());
            return temoin;
        }
        throw new IllegalArgumentException("Genre de mariage non reconnu");
    }

    public Homme extractHomme(MariageEERequest request){
        Homme homme = new Homme();
        homme.setAdresseHomme(request.getAdresseHomme());
        homme.setNomHomme(request.getNomHomme());
        homme.setPrenomsHomme(request.getPrenomsHomme());
        homme.setDateNaissHomme(request.getDateNaissHomme());
        homme.setLieuNaissHomme(request.getLieuNaissHomme());
        homme.setProfessionHomme(request.getProfessionHomme());
        homme.setNationaliteHomme(request.getNationaliteHomme());
        return homme;
    }
    public Homme extractHomme(MariageEIRequest request){
        Homme homme = new Homme();
        homme.setAdresseHomme(request.getAdresseHomme());
        homme.setNomHomme(request.getNomHomme());
        homme.setPrenomsHomme(request.getPrenomsHomme());
        homme.setDateNaissHomme(request.getDateNaissHomme());
        homme.setLieuNaissHomme(request.getLieuNaissHomme());
        homme.setProfessionHomme(request.getProfessionHomme());
        homme.setNationaliteHomme(request.getNationaliteHomme());
        return homme;
    }

    public Femme extractFemme(MariageIERequest request) {
        Femme femme = new Femme();
        femme.setNomFemme(request.getNomFemme());
        femme.setPrenomsFemme(request.getPrenomsFemme());
        femme.setDateNaissFemme(request.getDateNaissFemme());
        femme.setAdresseFemme(request.getAdresseFemme());
        femme.setLieuNaissFemme(request.getLieuNaissFemme());
        femme.setProfessionFemme(request.getProfessionFemme());
        femme.setNationaliteFemme(request.getNationaliteFemme());
        return femme;
    }
    public Femme extractFemme(MariageEERequest request) {
        Femme femme = new Femme();
        femme.setNomFemme(request.getNomFemme());
        femme.setPrenomsFemme(request.getPrenomsFemme());
        femme.setDateNaissFemme(request.getDateNaissFemme());
        femme.setAdresseFemme(request.getAdresseFemme());
        femme.setLieuNaissFemme(request.getLieuNaissFemme());
        femme.setProfessionFemme(request.getProfessionFemme());
        femme.setNationaliteFemme(request.getNationaliteFemme());
        return femme;
    }

    public Pere extractPere(MariageIERequest request) {
        Pere pere = new Pere();
        pere.setNomPere(request.getNomPereFemme());
        pere.setDateNaissPere(request.getDateNaissPereFemme());
        pere.setPrenomsPere(request.getPrenomsPereFemme());
        pere.setAdressePere(request.getAdressePereFemme());
        pere.setProfessionPere(request.getProfessionPereFemme());
        pere.setLieuNaissPere(request.getLieuNaissPereFemme());
        return pere;
    }

    public Pere extractPere(MariageEIRequest request) {
        Pere pere = new Pere();
        pere.setNomPere(request.getNomPereHomme());
        pere.setDateNaissPere(request.getDateNaissPereHomme());
        pere.setPrenomsPere(request.getPrenomsPereHomme());
        pere.setAdressePere(request.getAdressPereHomme());
        pere.setProfessionPere(request.getProfessionPereHomme());
        pere.setLieuNaissPere(request.getLieuNaissHomme());
        return pere;
    }

    public Pere extractPere(MariageEERequest request, GenreMariage genreMariage) {
       Pere pere = new Pere();
       if(genreMariage.equals(GenreMariage.HOMME)){
            pere.setNomPere(request.getNomPereHomme());
            pere.setDateNaissPere(request.getDateNaissPereHomme());
            pere.setPrenomsPere(request.getPrenomsPereHomme());
            pere.setAdressePere(request.getAdressePereHomme());
            pere.setProfessionPere(request.getProfessionPereHomme());
            pere.setLieuNaissPere(request.getLieuNaissPereHomme());
            return pere;
       }
       else if(genreMariage.equals(GenreMariage.FEMME)){
            pere.setNomPere(request.getNomPereFemme());
            pere.setDateNaissPere(request.getDateNaissPereFemme());
            pere.setPrenomsPere(request.getPrenomsPereFemme());
            pere.setAdressePere(request.getAdressePereFemme());
            pere.setProfessionPere(request.getProfessionPereFemme());
            pere.setLieuNaissPere(request.getLieuNaissPereFemme());
            return pere;
       }
       throw new IllegalArgumentException("Genre de mariage non reconnu");
    }
    public Mere extractMere(MariageIERequest request) {
        Mere mere = new Mere();
        mere.setNomMere(request.getNomMereFemme());
        mere.setDateNaissMere(request.getDateNaissMereFemme());
        mere.setPrenomsMere(request.getPrenomsMereFemme());
        mere.setAdresseMere(request.getAdresseMereFemme());
        mere.setProfessionMere(request.getProfessionMereFemme());
        mere.setLieuNaissMere(request.getLieuNaissMereFemme());
        return mere;
    }
    public Mere extractMere(MariageEIRequest request) {
        Mere mere = new Mere();
        mere.setNomMere(request.getNomMereHomme());
        mere.setDateNaissMere(request.getDateNaissMereHomme());
        mere.setPrenomsMere(request.getPrenomsMereHomme());
        mere.setAdresseMere(request.getAdresseMereHomme());
        mere.setProfessionMere(request.getProfessionMereHomme());
        mere.setLieuNaissMere(request.getLieuNaissMereHomme());
        return mere;
    }
    public Mere extractMere(MariageEERequest request,GenreMariage genreMariage){
        Mere mere = new Mere();

        if(genreMariage.equals(GenreMariage.FEMME)){
            mere.setNomMere(request.getNomMereFemme());
            mere.setDateNaissMere(request.getDateNaissMereFemme());
            mere.setPrenomsMere(request.getPrenomsMereFemme());
            mere.setAdresseMere(request.getAdresseMereFemme());
            mere.setProfessionMere(request.getProfessionMereFemme());
            mere.setLieuNaissMere(request.getLieuNaissMereFemme());
            return mere;
        } else if (genreMariage.equals(GenreMariage.HOMME)){
            mere.setNomMere(request.getNomMereHomme());
            mere.setDateNaissMere(request.getDateNaissMereHomme());
            mere.setPrenomsMere(request.getPrenomsMereHomme());
            mere.setAdresseMere(request.getAdresseMereHomme());
            mere.setProfessionMere(request.getProfessionMereHomme());
            mere.setLieuNaissMere(request.getLieuNaissMereHomme());
            return mere;
        }
        throw new IllegalArgumentException("Genre de mariage non reconnu");
    }


}
