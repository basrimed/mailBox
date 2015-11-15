package fr.mail.beans;

import java.util.Date;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;



@Entity(name = "Box")
public class Box implements Serializable{

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private long id;

	@Column(name = "boxName")
	private String boxName;

	@OneToMany(mappedBy="box")
	private Collection <Message> messages;

	@OneToMany(mappedBy="box")
	private Collection <NewsBox> newsBox;
	
		
	
	public Box() {
		super();
	}

	public Box(String boxName) {
		super();
		this.setBoxName(boxName);
	}

	public Box(long id, String boxName) {
		super();
		this.setId(id);
		this.setBoxName(boxName);
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


	public void setNewsBox(Collection <NewsBox> newsBox){
		this.newsBox = newsBox;
	}

	public Collection <NewsBox> getNewsBox(){
		return this.newsBox;
	}
	

	
	
	

}
