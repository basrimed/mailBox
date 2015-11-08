package fr.mail.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "FinalUser")
public class FinalUser {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column(name = "id")	
	private long id;

	@Column(name = "userName")
	private String userName ;

	
	
	
	public FinalUser() {
		super();
	}
	
	public FinalUser(String userName) {
		super();
		this.setUserName(userName);
	}

	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	

}
