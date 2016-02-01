package fr.afcepf.adopteundev.ucimpl.gestionpanier;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.ibusiness.gestion.panier.IBusinessPanier;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessDeveloppeur;

import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import java.util.List;

@Remote(IUCPanier.class)
@Stateless
public class UcPanierImpl implements IUCPanier {
    Logger log = Logger.getLogger(UcPanierImpl.class);
    @EJB
    private IBusinessPanier businessPanier;
    @EJB
    private IBusinessDeveloppeur businessDeveloppeur;
    
    
    @Override
    public List<DTODeveloppeur> recupererTousLesDeveloppeurs() {
        return businessPanier.recupererTousLesDeveloppeurs();
    }

    @Override
    public NoDeveloppeur recupererFicheResumeDeveloppeur(DTODeveloppeur dtoDeveloppeur) {
        return businessDeveloppeur.creerNoDeveloppeur(dtoDeveloppeur);
    }

    @Override
    public List<DTOProjet> recupererListProjetEnAttenteParUtilisateur(int idUtilisateur) {
        log.info("UcRecupListProjetParUtilisateur");
        return businessPanier.recupererListProjetEnAttenteParUtilisateur(idUtilisateur);

    }
}
