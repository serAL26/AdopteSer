package fr.afcepf.adopteundev.idao.gestion.utilisateur;

import entity.Developpeur;
import entity.Projet;
import entity.Technologie;

import java.util.List;

/**
 * Created by Stagiaire on 29/01/2016.
 */
public interface IDaoDeveloppeur {
    List<Developpeur> recupererTousLesDeveloppeurs();
    List<Developpeur> recupDeveloppeurWeb();
    List<Developpeur> recupDeveloppeursParTechno(Integer id);
    Developpeur obtenirDeveloppeurParId(int idUtilisateur);
    List<Projet> obtenirProjetParDev(int idDev);
    List<Developpeur> recupDeveloppeurParNoteEtTechno(double note, int idTechno );
}
