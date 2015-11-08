package fr.mail.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Box")
public class Box {

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private long id;

	@Column(name = "boxName")
	private String boxName;

	@OneToMany(cascade=ALL, mappedBy="box")
	private Collection <Message> messages;
	
		
	
	public Box() {
		super();
	}


	public Box(long id, String boxName) {
		super();
		this.id = id;
		this.boxName = boxName;
	}


	
	 public void setId(long id){
	 	this.id=id;
	 }
	 
	 public long getId(){
	 	return this.id;
	 } 	
	


	 public void setBoxName(String boxName){
	 	this.boxName=boxName;

	 }
	 
	 public String getBoxName(){
	 	return this.boxName;
	 } 	



	public void setMessages(Collection <Message> messages){
		this.messages = messages;
	}

	public Collection <Message> getMessages(){
		return this.messages;
	}
	

	
	
	

}
