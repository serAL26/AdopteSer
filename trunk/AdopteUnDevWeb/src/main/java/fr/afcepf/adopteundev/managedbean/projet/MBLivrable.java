package fr.afcepf.adopteundev.managedbean.projet;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOLivrable;
import dto.DTOOperation;
import fr.afcepf.adopteundev.dto.nosobjets.NoLivrable;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBLivrable {
	private DTOLivrable dtoLivrable = new DTOLivrable();
	private DTOOperation dtoOperation = new DTOOperation();
	private NoLivrable noLivrable = new NoLivrable();
	private boolean isPaye = false;
	@ManagedProperty(value="#{mBCreationProjet}")
	private MBCreationProjet mBCreationProjet;
	
	private IUCProjet ucProjet;
	
	@PostConstruct
	public void obtenirLesInterfaces() {
		ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
	}
	
	public String payerLivrable() {
		ucProjet.payerLivrable(dtoOperation);
		return "";
	}
	
	public void initIsPaye() {
		isPaye = ucProjet.initIsPaye(dtoLivrable);
	}
	
	public String creerLivrable() {
		ucProjet.creerLivrable(dtoLivrable);
		dtoLivrable = new DTOLivrable();
		return "";
	}

	public DTOLivrable getDtoLivrable() {
		return dtoLivrable;
	}

	public void setDtoLivrable(DTOLivrable dtoLivrable) {
		this.dtoLivrable = dtoLivrable;
	}

	public NoLivrable getNoLivrable() {
		return noLivrable;
	}

	public void setNoLivrable(NoLivrable noLivrable) {
		this.noLivrable = noLivrable;
	}

	public MBCreationProjet getmBCreationProjet() {
		return mBCreationProjet;
	}

	public void setmBCreationProjet(MBCreationProjet mBCreationProjet) {
		this.mBCreationProjet = mBCreationProjet;
	}

	public DTOOperation getDtoOperation() {
		return dtoOperation;
	}

	public void setDtoOperation(DTOOperation dtoOperation) {
		this.dtoOperation = dtoOperation;
	}

	public boolean isPaye() {
		return isPaye;
	}

	public void setPaye(boolean isPaye) {
		this.isPaye = isPaye;
	}
	
}
