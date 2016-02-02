package fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dto.DTOTechnologie;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@FacesConverter(value="technoConverter")
public class TechnoConverter implements Converter {
	IUcUtilisateur ucUtilisateur;
	
	private void init() {
        ucUtilisateur = (IUcUtilisateur)ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
    }
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String idTechno) {
		init();
		System.out.println("techno id " + idTechno);
		DTOTechnologie dto = ucUtilisateur.recupTechnoById(Integer.parseInt(idTechno));
		System.out.println(dto);
		return dto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object techno) {
		DTOTechnologie technologie = (DTOTechnologie)techno;
		//System.out.println("techno id " + technologie.getTechnologieLibelle());
		return technologie.getIdTechnologie().toString();
	}

}
