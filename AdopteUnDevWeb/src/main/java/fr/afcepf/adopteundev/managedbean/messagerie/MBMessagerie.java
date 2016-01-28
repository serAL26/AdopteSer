package fr.afcepf.adopteundev.managedbean.messagerie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTOMessage;

@ManagedBean
@SessionScoped
public class MBMessagerie {
	private String message;
	private DTOMessage messageCree;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public DTOMessage getMessageCree() {
		return messageCree;
	}
	public void setMessageCree(DTOMessage messageCree) {
		this.messageCree = messageCree;
	}
	

}
