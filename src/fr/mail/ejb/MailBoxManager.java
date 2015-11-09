package fr.mail.ejb;

import fr.mail.beans.*;

import java.util.List;
import javax.ejb.*;
import javax.persistence.*;

import java.sql.Date;


@Stateless(name="fr/mail/ejb/MailBoxManagerInterface")
public class MailBoxManager implements MailBoxManagerInterface{

	@PersistenceContext(unitName="pu1")
    	private EntityManager em;


	public void MailBoxManager(){


	}
	

	public List<Message> readAUserNewMessages(long id){


		return null;
	}



	public List<Message> readAUserAllMessages(long id){


		return null;
	}



	public void deleteAUserMessage(long id){

	}



	public void deleteAUserReadMessages(long id){
	
	}



	public void sendAMessageToBox ( String senderName,String receiverName, String subject, String body, boolean alreadyRead){

	}



	public void addUser(String userName){

	FinalUser finalUser = new FinalUser(userName);

	em.persist(finalUser);

	}



	public void removeUser(long id){

	}




}
