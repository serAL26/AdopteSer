package fr.afcepf.adopteundev.idao.messagerie;

import java.util.List;

import entity.Message;

public interface IDaoMessagerie {
	Message creerNouveauFil(Message message);
	List<Message> recupereTousLesMessMere(int idUtilisateur);
}
