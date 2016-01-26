package entity;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="CLIENT")
public class Client extends Utilisateur {

    /**
     * Default constructor
     */
    public Client() {
    }
    
    @OneToMany(mappedBy="client")
    private Set<Projet> lesProjet;

	public Set<Projet> getLesProjet() {
		return lesProjet;
	}

	public void setLesProjet(Set<Projet> lesProjet) {
		this.lesProjet = lesProjet;
	}

}