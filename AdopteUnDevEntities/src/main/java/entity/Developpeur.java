package entity;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="DEVELOPPEUR")
public class Developpeur extends Utilisateur {

    /**
     * Default constructor
     */
    public Developpeur() {
    }


    @OneToMany(mappedBy="developpeur")
    private Set<Livrable> lesLivrable;
    
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

	public Set<Livrable> getLesLivrable() {
		return lesLivrable;
	}

	public void setLesLivrable(Set<Livrable> lesLivrable) {
		this.lesLivrable = lesLivrable;
	}
    
}