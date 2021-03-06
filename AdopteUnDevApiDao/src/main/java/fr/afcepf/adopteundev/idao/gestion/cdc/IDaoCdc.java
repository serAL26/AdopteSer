package fr.afcepf.adopteundev.idao.gestion.cdc;

import java.util.List;

import entity.AssociationCdcFonctionnalite;
import entity.Cdc;
import entity.Fonctionnalite;
import entity.TypeCdc;
import entity.TypeFonctionnalite;

public interface IDaoCdc {
	
	Cdc ajouterCdc (Cdc cdc);
	Cdc modifierCdc (Cdc cdc);
	List<TypeFonctionnalite> getAll();
	Fonctionnalite ajouterFonctionnalite (Fonctionnalite fonct);
	AssociationCdcFonctionnalite ajouterAssociationCdcFonctionnalite (AssociationCdcFonctionnalite association);
	List<TypeCdc> recupTouslesTypesCdc();
	TypeCdc recupTypeRemarque();
	Cdc recupCdcParId(Integer id);
	List<Cdc> recupRemarqueParIdDevEtIdProjet(Integer idDev, Integer idProjet);

	Cdc recupCdcFinalParidProjet(int idProjet);
	List<Cdc> recupCdcParidProjet(Integer idProjet);
}
