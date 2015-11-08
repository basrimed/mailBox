package fr.mail.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Message")
public class Message {

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	public long id;

	@Column(name = "senderName")
	public String senderName;

	@Column(name = "receiverName")
	public String receiverName;

	@Column(name = "sendingDate")
	public Date sendingDate;

	@Column(name = "subject")
	public String subject;

	@Column(name = "body")
	public String body;

	@Column(name = "alreadyRead")
	public boolean alreadyRead;
	
	
		
	
	public Message() {
		super();
	}


	public Message(String senderName, String receiverName, Date sendingDate, String subject, String body,
			boolean alreadyRead) {
		super();
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.sendingDate = sendingDate;
		this.subject = subject;
		this.body = body;
		this.alreadyRead = alreadyRead;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getReceiverName() {
		return receiverName;
	}


	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}


	public Date getSendingDate() {
		return sendingDate;
	}


	public void setSendingDate(Date sendingDate) {
		this.sendingDate = sendingDate;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}

	
	 public void setIsRead(){
	 	this.alreadyRead=true;
	 }
	 
	 public boolean isRead(){
	 	return this.alreadyRead;
	 } 
	
	
	
	
	

}
