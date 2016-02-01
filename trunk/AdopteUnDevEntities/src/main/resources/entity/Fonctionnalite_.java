package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.341+0100")
@StaticMetamodel(Fonctionnalite.class)
public class Fonctionnalite_ {
	public static volatile SingularAttribute<Fonctionnalite, Integer> idFonctionnalite;
	public static volatile SingularAttribute<Fonctionnalite, String> commentaire;
	public static volatile SingularAttribute<Fonctionnalite, TypeFonctionnalite> typeFonctionnalite;
	public static volatile SetAttribute<Fonctionnalite, AssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite;
}
