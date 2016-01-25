package entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
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