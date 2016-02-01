package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.375+0100")
@StaticMetamodel(Ville.class)
public class Ville_ {
	public static volatile SingularAttribute<Ville, Integer> idVille;
	public static volatile SingularAttribute<Ville, String> nom;
	public static volatile SingularAttribute<Ville, String> cp;
	public static volatile SingularAttribute<Ville, Departement> departement;
}
