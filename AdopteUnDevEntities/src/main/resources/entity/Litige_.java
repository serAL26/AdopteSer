package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.343+0100")
@StaticMetamodel(Litige.class)
public class Litige_ {
	public static volatile SingularAttribute<Litige, String> motif;
	public static volatile SingularAttribute<Litige, Integer> idLitige;
	public static volatile SingularAttribute<Litige, String> libelle;
	public static volatile SingularAttribute<Litige, Projet> projet;
}
