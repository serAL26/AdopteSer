package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.328+0100")
@StaticMetamodel(Cdc.class)
public class Cdc_ {
	public static volatile SingularAttribute<Cdc, Integer> idCdc;
	public static volatile SingularAttribute<Cdc, String> Contexte;
	public static volatile SingularAttribute<Cdc, Boolean> lu;
	public static volatile SingularAttribute<Cdc, String> Besoin;
	public static volatile SingularAttribute<Cdc, String> Existant;
	public static volatile SingularAttribute<Cdc, Double> tarif;
	public static volatile SingularAttribute<Cdc, Date> dateFinEstimee;
	public static volatile SingularAttribute<Cdc, Projet> projet;
	public static volatile SingularAttribute<Cdc, Cdc> remarque;
	public static volatile ListAttribute<Cdc, Cdc> lesCdc;
	public static volatile SingularAttribute<Cdc, TypeCdc> typeCdc;
	public static volatile SingularAttribute<Cdc, Developpeur> developpeurCdc;
	public static volatile SetAttribute<Cdc, AssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite;
}
