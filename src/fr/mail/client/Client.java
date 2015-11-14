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

			UsersDirectoryInterface usersDirectory = (UsersDirectoryInterface) ic.lookup("fr.mail.ejb.UsersDirectoryInterface");



	/*	Scanner pause = new Scanner(System.in);
		pause.nextLine();
	*/

	usersDirectory.deleteAllUser();

	usersDirectory.addUser("basri");
	usersDirectory.addUser("louis");
	usersDirectory.addUser("caroline");
	usersDirectory.addUser("maryon");	

	a.addBox("Box de test");
	a.sendAMessageToBox("basri","louis","sujet1","message1",1);
	a.sendAMessageToBox("caroline","basri","sujet2","message2",1);
	a.sendAMessageToBox("louis","caroline","sujet3","message3",1);
	a.sendAMessageToBox("louis","basri","sujet4","message4",1);


	List <Object[]> message = a.readAUserNewMessages("basri");	

	System.out.println("\nLecture des messages reçu(non lu) par 'basri'\n");
	 for (Object[] m : message) 
		{
      		System.out.println(m[0]+" || "+m[1]+" || "+m[2]+" || "+m[3]+" || "+m[4]);
  		}

	a.sendAMessageToBox("maryon","basri","sujet5","message5",1);
	a.deleteAUserReadMessages("basri");

	System.out.println("\nSuppression des messages lu par 'basri'");

	System.out.println("\nLecture des messages reçu(non lu) par 'basri'\n");

	message = a.readAUserNewMessages("basri");	


	 for (Object[] m : message) 
		{
      		System.out.println(m[0]+" || "+m[1]+" || "+m[2]+" || "+m[3]+" || "+m[4]);
  		}

	System.out.println("\nSuppression de plusieurs utilisateurs");
	usersDirectory.removeUser(1);
	usersDirectory.removeUser(3);

	usersDirectory.addUser("françois");
	
	System.out.println("\nListe de tous les utilisateurs actif\n");
	List <Object[]> finalUsers = usersDirectory.lookupAllUsers();	
 	for (Object[] user : finalUsers) {
 		System.out.println(user[0]+" || "+user[1]);
 		}


	System.out.println("\nliste des droits de louis\n");
	FinalUser user = (FinalUser) usersDirectory.lookupAUserRights("louis");	
	System.out.println(user.getUserName()+" || "+user.getReadRightGroup()+" || "+user.getWriteRightGroup());      		

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
