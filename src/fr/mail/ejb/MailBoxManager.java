package fr.mail.manager;

import fr.mail.beans.*;

import java.util.List;
import javax.ejb.*;
import javax.persistence.*;

import java.sql.Date;


@Stateless
public class MailBoxManager implements MailBoxManagerInterface{



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


	}



	public void removeUser(long id){

	}




}
