package fr.mail.ejb;

import fr.mail.beans.*;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import fr.mail.beans.FinalUser;
import fr.mail.beans.Message;

import javax.persistence.*;

@Remote 
public interface MailBoxManagerInterface {
	
	public List <Message> readAUserNewMessages(String receiverName);
	public List <Message> readAUserAllMessages(String receiverName);
	public void deleteAUserMessage(long id);
	public void deleteAUserReadMessages(String receiverName);
	public void sendAMessageToBox(String senderName,String receiverName, String subject, String body, long idBox);
	public void addBox(String boxName);
}
