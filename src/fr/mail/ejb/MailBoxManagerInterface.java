package fr.mail.manager;

import fr.mail.beans.*;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import fr.mail.beans.FinalUser;
import fr.mail.beans.Message;

import javax.persistence.*;

@Remote 
public interface MailBoxManagerInterface {
	
	public List<Message> readAUserNewMessages(long id);
	public List<Message> readAUserAllMessages(long id);
	public void deleteAUserMessage(long id);
	public void deleteAUserReadMessages(long id);
	public void sendAMessageToBox(String senderName,String receiverName, String subject, String body, boolean alreadyRead);
	public void addUser(String userName);
	public void removeUser(long id);
	/* partie 2 du projet*/ //public void sendNews(/**/);
}
