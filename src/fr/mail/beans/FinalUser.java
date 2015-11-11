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


	public FinalUser(long id,String userName) {
		super();
		this.setId(id);
		this.setUserName(userName);
	}
	
	public FinalUser(String userName) {
		super();
		this.setUserName(userName);
	}



	public void setId(long id){
		this.id=id;
	}
	 
	public long getId(){
		return this.id;
	} 	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	

}
