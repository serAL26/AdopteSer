package fr.afcepf.adopteundev.business.gestion.proposition;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOProposition;
import entity.Proposition;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.ibusiness.gestion.proposition.IBusinessProposition;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoProposition;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoTypeProposition;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;

@Remote(IBusinessProposition.class)
@Stateless
public class BusinessPropositionImpl implements IBusinessProposition {
    @EJB
    private IDaoProposition daoProposition;

    @EJB
    private IDaoTypeProposition daoTypeProposition;
    @EJB
    private IDaoGestionProjet daoProjet;
    
    @Override
    public DTOProposition recupPropositionValiderParProjet(Integer idProjet) {
        Proposition proposition = daoProposition.recupPropositionValiderParProjet(idProjet);
        return EntityToDTO.propositionToDTOProposition(proposition);
    }

	@Override
	public void validerPanier(Map<Integer, Set<NoDeveloppeur>> map) {
		Set<Integer> setProjet = map.keySet();
		for (Integer integer : setProjet) {
			ajouterLesPropositionsAuxDevParProjet(integer, map.get(integer));
		}
	}

	private void ajouterLesPropositionsAuxDevParProjet(Integer integer, Set<NoDeveloppeur> set) {
		for (NoDeveloppeur noDeveloppeur : set) {
			Proposition proposition = new Proposition();
			proposition.setProjet(daoProjet.recupProjetParId(integer));
			proposition.setDate(new Date());
			proposition.setDeveloppeur(DTOToEntity.dtoDeveloppeurToDeveloppeur(noDeveloppeur.getDeveloppeur()));
			proposition.setLu(false);
			proposition.setTitre("");
			proposition.setTypeProposition(daoTypeProposition.recupTypePropositionParId(1));
			daoProposition.ajouterPropositionAuDev(proposition);
		}
	}
}
