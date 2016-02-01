package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.335+0100")
@StaticMetamodel(Developpeur.class)
public class Developpeur_ extends Utilisateur_ {
	public static volatile SetAttribute<Developpeur, AssociationDevTechno> lesAssociationDevTechno;
	public static volatile SetAttribute<Developpeur, Proposition> listeProposition;
	public static volatile SetAttribute<Developpeur, Dispo> listeDispo;
}
