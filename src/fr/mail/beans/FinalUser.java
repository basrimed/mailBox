package fr.mail.beans;


import javax.persistence.*;


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
