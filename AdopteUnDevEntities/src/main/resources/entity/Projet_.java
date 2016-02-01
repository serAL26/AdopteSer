package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.353+0100")
@StaticMetamodel(Projet.class)
public class Projet_ {
	public static volatile SingularAttribute<Projet, Integer> idProjet;
	public static volatile SingularAttribute<Projet, String> photo;
	public static volatile SingularAttribute<Projet, String> libelle;
	public static volatile SingularAttribute<Projet, Client> client;
	public static volatile SetAttribute<Projet, Note> lesNotes;
	public static volatile SingularAttribute<Projet, EtatProjet> etatProjet;
	public static volatile SetAttribute<Projet, Cdc> lesCdc;
	public static volatile SingularAttribute<Projet, TypeService> Service;
	public static volatile SetAttribute<Projet, Litige> lesLitige;
	public static volatile SetAttribute<Projet, Livrable> lesLivrable;
	public static volatile SetAttribute<Projet, Proposition> lesProposition;
}
