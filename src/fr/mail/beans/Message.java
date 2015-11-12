package fr.mail.beans;

import java.util.Date;

import javax.persistence.*;



@Entity(name = "Message")
public class Message {

	@ManyToOne
	@JoinColumn(name = "idBox", referencedColumnName="id")
	private Box box;

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private long id;

	@Column(name = "senderName")
	private String senderName;

	@Column(name = "receiverName")
	private String receiverName;

	@Column(name = "sendingDate")
	private Date sendingDate;

	@Column(name = "subject")
	private String subject;

	@Column(name = "body")
	private String body;

	@Column(name = "alreadyRead")
	private boolean alreadyRead;


	
	
	
		
	
	public Message() {
		super();
	}


	public Message(String senderName, String receiverName, Date sendingDate, String subject, String body,
			boolean alreadyRead,Box box) {
		super();
		this.setBox(box);
		this.setSenderName(senderName);
		this.setReceiverName(receiverName);
		this.setSendingDate(sendingDate);
		this.setSubject(subject);
		this.setBody(body);
		this.alreadyRead=false;
	}


	public Message(String senderName, String receiverName, Date sendingDate, String subject, String body,
			boolean alreadyRead) {
		super();
		this.setId(id);
		this.setBox(box);
		this.setSenderName(senderName);
		this.setReceiverName(receiverName);
		this.setSendingDate(sendingDate);
		this.setSubject(subject);
		this.setBody(body);
		this.alreadyRead=false;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public Box getBox() {
		return this.box;
	}


	public void setBox(Box box) {
		this.box = box;
	}

	
	 public void setIsRead(){
	 	this.alreadyRead=true;
	 }
	 
	 public boolean isRead(){
	 	return this.alreadyRead;
	 } 
	
	
	
	
	

}
