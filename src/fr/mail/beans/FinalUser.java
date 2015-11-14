package fr.mail.beans;
import java.io.Serializable;

import javax.persistence.*;


@Entity(name = "FinalUser")
public class FinalUser implements Serializable{
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column(name = "id")	
	private long id;

	@Column(name = "userName")
	private String userName ;

	@Column(name = "readRightGroup")
	private boolean readRightGroup;

	@Column(name = "writeRightGroup")
	private boolean writeRightGroup;

	
	
	
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



	public boolean getReadRightGroup() {
		return readRightGroup;
	}

	public void updateReadRightGroup(boolean readRightGroup) {
		this.readRightGroup = readRightGroup;
	}


	public boolean getWriteRightGroup() {
		return writeRightGroup;
	}

	public void updateWriteRightGroup(boolean writeRightGroup) {
		this.writeRightGroup = writeRightGroup;
	}
	
	
	
	
	

}
