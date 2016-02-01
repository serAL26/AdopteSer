package fr.afcepf.adopteundev.ibusiness.gestion.utilisateur;

import java.util.List;

import dto.DTODeveloppeur;
import dto.DTOTechnologie;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

public interface IBusinessDeveloppeur {
    List<DTODeveloppeur> recupererTousLesDeveloppeurs();
    NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur);
    List<DTODeveloppeur> recupDevWeb();
    List<DTODeveloppeur> recupDevParTechno(Integer id);
    List<DTODeveloppeur> recupDeveloppeurParNoteEtTechno(double note, DTOTechnologie techno );
    
}
