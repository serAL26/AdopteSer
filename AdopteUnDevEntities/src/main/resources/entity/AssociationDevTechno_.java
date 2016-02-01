package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.323+0100")
@StaticMetamodel(AssociationDevTechno.class)
public class AssociationDevTechno_ {
	public static volatile SingularAttribute<AssociationDevTechno, Integer> idAssociationDevTechno;
	public static volatile SingularAttribute<AssociationDevTechno, Developpeur> developpeur;
	public static volatile SingularAttribute<AssociationDevTechno, Technologie> technologie;
}
