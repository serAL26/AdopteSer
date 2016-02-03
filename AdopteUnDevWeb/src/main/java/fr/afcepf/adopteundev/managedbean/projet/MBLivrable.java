package fr.afcepf.adopteundev.managedbean.projet;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOLivrable;
import dto.DTOOperation;
import fr.afcepf.adopteundev.dto.nosobjets.NoLivrable;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBLivrable {
	private DTOLivrable dtoLivrable = new DTOLivrable();
	private DTOOperation dtoOperation = new DTOOperation();
	private DTOOperation dtoOperationACreationLivrable = new DTOOperation();
	private NoLivrable noLivrable = new NoLivrable();
	private int somme;
	private boolean isPaye = false;
	@ManagedProperty(value="#{mBCreationProjet}")
	private MBCreationProjet mBCreationProjet;

	@ManagedProperty(value="#{mBConnexion}")
	private MBConnexion mBConnexion;

	private IUCProjet ucProjet;

	@PostConstruct
	public void obtenirLesInterfaces() {
		ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
	}

	public String payerLivrable() {
		ucProjet.payerLivrable(dtoOperation);
		return "";
	}

	public int obtenirArgent() {
		int retour =0;
		List<DTOOperation> listOperation = new ArrayList<>();
		if(mBConnexion.getTypeUtilisateur() == 1) {
			listOperation = ucProjet.obtenirSommeDev(mBConnexion.getUtilisateur().getIdUtilisateur(), 3);
		}
		else if(mBConnexion.getTypeUtilisateur()==2) {
			listOperation = ucProjet.obtenirSommeClient(mBConnexion.getUtilisateur().getIdUtilisateur(), 3);
		}
		if(listOperation != null &&listOperation.size() > 0) {
			for (DTOOperation dtoOperation : listOperation) {
				retour += dtoOperation.getMontant();
			}
		}
		return retour;
	}

	public void initIsPaye() {
		isPaye = ucProjet.initIsPaye(dtoLivrable);
	}

	public String creerLivrable() {
		DTOLivrable livrable = ucProjet.creerLivrable(dtoLivrable);
		dtoOperationACreationLivrable.setLivrable(livrable);
		ucProjet.creerOperationAttente(dtoOperationACreationLivrable);
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

	public int getSomme() {
		return somme;
	}

	public void setSomme(int somme) {
		this.somme = somme;
	}

	public MBConnexion getmBConnexion() {
		return mBConnexion;
	}

	public void setmBConnexion(MBConnexion mBConnexion) {
		this.mBConnexion = mBConnexion;
	}
}
