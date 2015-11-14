package fr.mail.ejb;

import fr.mail.beans.*;

import java.util.*;
import javax.ejb.*;
import javax.persistence.*;

@Stateless(name="fr/mail/ejb/MailBoxManagerInterface")
public class MailBoxManager implements MailBoxManagerInterface{

	@PersistenceContext(unitName="pu1")
    	private EntityManager em;



	public void MailBoxManager(){


	}
	

	public List <Object[]> readAUserNewMessages(String receiverName){
		Query q = em.createQuery("select m.id, m.senderName, m.sendingDate, m.subject, m.body from Message m where m.receiverName = :receiverName and m.alreadyRead = :alreadyRead");
		q.setParameter("receiverName",receiverName);
		q.setParameter("alreadyRead",false);
        	List <Object[]> results = q.getResultList();

		Query q2 = em.createQuery("update Message m set m.alreadyRead = :alreadyRead where m.alreadyRead = :alreadyRead2 and m.receiverName = :receiverName");
		q2.setParameter("alreadyRead",true);
		q2.setParameter("alreadyRead2",false);
		q2.setParameter("receiverName",receiverName);
		q2.executeUpdate();

		return results;
	}



	public List <Object[]> readAUserAllMessages(String receiverName){
		Query q = em.createQuery("select  m.id, m.senderName, m.sendingDate, m.subject, m.body from Message m where m.receiverName = :receiverName");
		q.setParameter("receiverName",receiverName);
        	List <Object[]> results = q.getResultList();

		Query q2 = em.createQuery("update Message m set m.alreadyRead = :alreadyRead where m.alreadyRead = :alreadyRead2 and m.receiverName = :receiverName");
		q2.setParameter("alreadyRead",true);
		q2.setParameter("alreadyRead2",false);
		q2.setParameter("receiverName",receiverName);
		q2.executeUpdate();

		return results;
	}



	public void deleteAUserMessage(long id){
		Message message = new Message();
		message.setId(id);
		message=em.merge(message);
		em.remove(message);

	}



	public void deleteAUserReadMessages(String receiverName){
		Query q = em.createQuery("delete from Message m where m.receiverName = :receiverName and m.alreadyRead = :alreadyRead");
		q.setParameter("receiverName",receiverName);
		q.setParameter("alreadyRead",true);
		q.executeUpdate();
	}



	public void sendAMessageToBox ( String senderName,String receiverName, String subject, String body, long idBox){

	Box box = new Box();
	box.setId(idBox);

	Message message = new Message();

	message.setBox(box);
	message.setSenderName(senderName);
	message.setReceiverName(receiverName);
	message.setSendingDate(new Date() );
	message.setSubject(subject);
	message.setBody(body);

	em.persist(message);
	}


	public void addBox(String boxName){
		Box box = new Box(boxName);
		em.persist(box);	
	}







}
