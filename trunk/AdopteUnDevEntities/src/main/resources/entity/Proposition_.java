package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.355+0100")
@StaticMetamodel(Proposition.class)
public class Proposition_ {
	public static volatile SingularAttribute<Proposition, Boolean> Lu;
	public static volatile SingularAttribute<Proposition, Date> date;
	public static volatile SingularAttribute<Proposition, Integer> idProposition;
	public static volatile SingularAttribute<Proposition, String> titre;
	public static volatile SingularAttribute<Proposition, Projet> projet;
	public static volatile SingularAttribute<Proposition, Developpeur> developpeur;
	public static volatile SingularAttribute<Proposition, TypeProposition> typeProposition;
}
