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

		MailBoxManagerInterface mailBoxManagerInterface = (MailBoxManagerInterface) ic.lookup("fr.mail.ejb.MailBoxManagerInterface");
		UsersDirectoryInterface usersDirectory = (UsersDirectoryInterface) ic.lookup("fr.mail.ejb.UsersDirectoryInterface");
		NewsBoxManagerInterface newsBoxManager = (NewsBoxManagerInterface) ic.lookup("fr.mail.ejb.NewsBoxManagerInterface");

		usersDirectory.deleteAllUser();

		usersDirectory.addUser("basri");
		usersDirectory.addUser("louis");
		usersDirectory.addUser("caroline");
		usersDirectory.addUser("maryon");	

		mailBoxManagerInterface.addBox("Box de test");
		mailBoxManagerInterface.sendAMessageToBox("basri","louis","sujet1","message1",1);
		mailBoxManagerInterface.sendAMessageToBox("caroline","basri","sujet2","message2",1);
		mailBoxManagerInterface.sendAMessageToBox("louis","caroline","sujet3","message3",1);
		mailBoxManagerInterface.sendAMessageToBox("louis","basri","sujet4","message4",1);


		List <Message> message = mailBoxManagerInterface.readAUserNewMessages("basri");	

		System.out.println("\n*** Lecture des messages reçu(non lu) par 'basri' ***\n");

	      	System.out.println("Id || SenderName || SendingDate || Subject || Body\n");
		 for (Message m : message) 
			{
	      		System.out.println(m.getId()+" || "+m.getSenderName()+" || "+m.getSendingDate()+" || "+m.getSubject()+" || "+m.getBody());
	  		}

		mailBoxManagerInterface.sendAMessageToBox("maryon","basri","sujet5","message5",1);

		System.out.println("\n*** Suppression des messages lu par 'basri' ***");
		mailBoxManagerInterface.deleteAUserReadMessages("basri");


		System.out.println("\n*** Lecture des messages reçu(non lu) par 'basri' ***\n");

		System.out.println("Id || SenderName || SendingDate || Subject || Body\n");
		message = mailBoxManagerInterface.readAUserNewMessages("basri");	

		 for (Message m : message) 
			{
	      		System.out.println(m.getId()+" || "+m.getSenderName()+" || "+m.getSendingDate()+" || "+m.getSubject()+" || "+m.getBody());
	  		}

		System.out.println("\n*** Suppression et ajout de plusieurs utilisateurs ***");
		usersDirectory.removeUser(3);
		usersDirectory.removeUser(4);

		usersDirectory.addUser("françois");
	
		System.out.println("\n*** Liste de tous les utilisateurs actif ***\n");
		System.out.println("Id || Name \n");
		List <FinalUser> finalUsers = usersDirectory.lookupAllUsers();	
	 	for (FinalUser user : finalUsers) {
	 		System.out.println(user.getId()+" || "+user.getUserName());
	 		}


		System.out.println("\n*** liste des droits de louis ***\n");
		System.out.println("Id || SenderName || Lecture || Ecriture\n");
		FinalUser user = usersDirectory.lookupAUserRights("louis");	
		System.out.println(user.getUserName()+" || "+user.getReadRightGroup()+" || "+user.getWriteRightGroup());      		




		System.out.println("\n*** basri envoie des news a la Box de test ***\n");

		newsBoxManager.sendNewsBox(1,"basri","news de test 1");
		newsBoxManager.sendNewsBox(1,"basri","news de test 2");
		newsBoxManager.sendNewsBox(1,"basri","news de test 3");



		System.out.println("\n*** lecture des news de la box de test ***\n");
		System.out.println("Id || SenderName || News || SendingDate\n");

		List<NewsBox> newsBox = newsBoxManager.lookupAllNewsBox(1);	

		 for (NewsBox n : newsBox) 
			{
	      		System.out.println(n.getId()+" || "+n.getSenderName()+" || "+n.getNews()+" || "+n.getSendingDate());
	  		}



		System.out.println("\n*** Suppression d'une news ***\n");

		newsBoxManager.removeNewsBox(2);


			} catch(Exception e) {
				e.printStackTrace();
			}

		}
	}
