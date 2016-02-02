package fr.afcepf.adopteundev.idao.gestion.utilisateur;

import java.util.List;
import java.util.Set;

import entity.Developpeur;
import entity.Projet;

/**
 * Created by Stagiaire on 29/01/2016.
 */
public interface IDaoDeveloppeur {
	List<Developpeur> recupererTousLesDeveloppeurs();

	List<Developpeur> recupDeveloppeurWeb();

	List<Developpeur> recupDeveloppeursParTechno(Integer id);

	Set<Developpeur> recupDeveloppeursParTechnoSet(Integer id);

	Developpeur obtenirDeveloppeurParId(int idUtilisateur);

	List<Projet> obtenirProjetParDev(int idDev);

	Set<Developpeur> recupDeveloppeurParNoteEtTechno(double note, int idTechno);

	Set<Developpeur> recupDevParNote(double note);
}
