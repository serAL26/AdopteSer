package fr.afcepf.adopteundev.ucimpl.gestionpanier;

import dto.DTODeveloppeur;
import dto.DTOProposition;
import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.ibusiness.gestion.panier.IBusinessPanier;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(IUCPanier.class)
@Stateless
public class UcPanierImpl implements IUCPanier {
    @EJB
    private IBusinessPanier businessPanier;
    @Override
    public List<DTOProposition> recupererPanier() {
        return null;
    }

    @Override
    public List<DTODeveloppeur> recupererTousLesDeveloppeurs() {
        return businessPanier.recupererTousLesDeveloppeurs();
    }

    @Override
    public List<NoDeveloppeur> recupererFicheResumeDeveloppeur() {
        return businessPanier.recupererFicheResumeDeveloppeur();
    }

    @Override
    public void ajouterProposition(DTOProposition proposition) {

    }

    @Override
    public void retirerProposition(DTOProposition proposition) {

    }

}
