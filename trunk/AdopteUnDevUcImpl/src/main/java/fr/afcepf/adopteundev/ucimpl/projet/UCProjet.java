package fr.afcepf.adopteundev.ucimpl.projet;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOTypeAppli;
import dto.DTOTypeService;
import fr.afcepf.adopteundev.business.projet.IBusinessTypeAppli;
import fr.afcepf.adopteundev.business.projet.IBusinessTypeService;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;

@Remote(IUCProjet.class)
@Stateless
public class UCProjet implements IUCProjet {
	
	@EJB
	private IBusinessTypeAppli businessTypeAppli;

	@EJB
	private IBusinessTypeService businessTypeService;

	@Override
	public Set<DTOTypeAppli> rechercherTousApplication() {
		return businessTypeAppli.getAllApplis();
	}

	@Override
	public Set<DTOTypeService> rechercherTousServices() {
		return businessTypeService.getAllServices();
	}

	@Override
	public Set<DTOTypeService> rechercherServicesParAppli(
			DTOTypeAppli application) {
		return businessTypeService.getServicesByAppli(application);
	}

}
