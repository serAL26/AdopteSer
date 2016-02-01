package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.336+0100")
@StaticMetamodel(Dispo.class)
public class Dispo_ {
	public static volatile SingularAttribute<Dispo, Integer> idDispo;
	public static volatile SingularAttribute<Dispo, Date> debutDispo;
	public static volatile SingularAttribute<Dispo, Date> finDispo;
	public static volatile SingularAttribute<Dispo, Developpeur> developpeur;
	public static volatile SingularAttribute<Dispo, TypeDispo> typeDispo;
}
