package fr.afcepf.adopteundev.business.gestion.panier;

import assembleur.EntityToDTO;
import dto.DTODeveloppeur;
import dto.DTOProposition;
import entity.Developpeur;
import fr.afcepf.adopteundev.ibusiness.gestion.panier.IBusinessPanier;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
@Remote(IBusinessPanier.class)
@Stateless
public class BusinessPanierImpl implements IBusinessPanier {
    @EJB
    private IDaoDeveloppeur daoDeveloppeur;

    @Override
    public List<DTOProposition> recupererPanier() {
        return null;
    }

    @Override
    public List<DTODeveloppeur> recupererTousLesDeveloppeurs() {
        List<Developpeur> liste = daoDeveloppeur.recupererTousLesDeveloppeurs();
        List<DTODeveloppeur>listDto = new ArrayList<>();
        for (Developpeur dev :
                liste) {
            listDto.add(EntityToDTO.developpeurToDTODeveloppeur(dev));
        }
        return listDto;
    }

    @Override
    public void ajouterProposition(DTODeveloppeur developpeur) {
        DTOProposition proposition = new DTOProposition();
    }

    @Override
    public void retirerProposition(DTOProposition proposition) {

    }

}
