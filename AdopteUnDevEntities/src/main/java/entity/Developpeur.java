package entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Developpeur extends Utilisateur {

    /**
     * Default constructor
     */
    public Developpeur() {
    }


    
    @OneToMany(mappedBy="developpeur")
    private Set<AssociationDevTechno> lesAssociationDevTechno;

    @OneToMany(mappedBy="developpeur")
    private Set<Proposition> listeProposition;

    @OneToMany(mappedBy="developpeur")
    private Set<Dispo> listeDispo;

	public Set<AssociationDevTechno> getLesAssociationDevTechno() {
		return lesAssociationDevTechno;
	}

	public void setLesAssociationDevTechno(
			Set<AssociationDevTechno> lesAssociationDevTechno) {
		this.lesAssociationDevTechno = lesAssociationDevTechno;
	}

	public Set<Proposition> getListeProposition() {
		return listeProposition;
	}

	public void setListeProposition(Set<Proposition> listeProposition) {
		this.listeProposition = listeProposition;
	}

	public Set<Dispo> getListeDispo() {
		return listeDispo;
	}

	public void setListeDispo(Set<Dispo> listeDispo) {
		this.listeDispo = listeDispo;
	}

    
}