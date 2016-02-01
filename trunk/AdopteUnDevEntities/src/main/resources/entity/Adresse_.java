package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.318+0100")
@StaticMetamodel(Adresse.class)
public class Adresse_ {
	public static volatile SingularAttribute<Adresse, Integer> idAdresse;
	public static volatile SingularAttribute<Adresse, String> numero;
	public static volatile SingularAttribute<Adresse, String> rue;
	public static volatile SingularAttribute<Adresse, Ville> ville;
}
