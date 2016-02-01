package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.373+0100")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ {
	public static volatile SingularAttribute<Utilisateur, String> mail;
	public static volatile SingularAttribute<Utilisateur, String> mdp;
	public static volatile SingularAttribute<Utilisateur, String> Nom;
	public static volatile SingularAttribute<Utilisateur, String> Prenom;
	public static volatile SingularAttribute<Utilisateur, String> Portable;
	public static volatile SingularAttribute<Utilisateur, String> Fixe;
	public static volatile SingularAttribute<Utilisateur, String> Photo;
	public static volatile SingularAttribute<Utilisateur, Integer> idUtilisateur;
	public static volatile SingularAttribute<Utilisateur, Date> DateInscription;
	public static volatile SetAttribute<Utilisateur, Message> lesMessages1;
	public static volatile SingularAttribute<Utilisateur, Adresse> adresse;
	public static volatile SetAttribute<Utilisateur, Message> lesMessages2;
}
