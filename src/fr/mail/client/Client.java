package fr.mail.client;

import javax.naming.InitialContext;

import javax.ejb.*;

import java.util.*;
import java.io.*;

import fr.mail.ejb.*;
import fr.mail.beans.*;

public class Client {
	public static void main(String args[]) {
 System.out.println("-----------------TEST---------------------");

	        try {
			InitialContext ic = new InitialContext();
			MailBoxManagerInterface a = (MailBoxManagerInterface) ic.lookup("fr.mail.ejb.MailBoxManagerInterface");





	/*	Scanner pause = new Scanner(System.in);
		pause.nextLine();
	*/



	a.addUser("basri");
	a.addUser("anas");
	a.addUser("abdsamad");	

	a.addBox("Box de test");
	a.sendAMessageToBox("basri","anas","sujet1","message1",1);
	a.sendAMessageToBox("anas","basri","sujet2","message2",1);
	a.sendAMessageToBox("abdsamad","anas","sujet3","message3",1);
	a.sendAMessageToBox("abdsamad","basri","sujet4","message4",1);

	//a.deleteAUserMessage(2);


	List <Object[]> message = a.readAUserNewMessages("basri");	


	 for (Object[] m : message) 
		{
      		System.out.println(m[0]+" || "+m[1]+" || "+m[2]+" || "+m[3]);
  		}

	a.sendAMessageToBox("anas","basri","sujet5","message5",1);
	a.deleteAUserReadMessages("basri");

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
