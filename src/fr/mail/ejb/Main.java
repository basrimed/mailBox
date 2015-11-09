package fr.mail.ejb;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.mail.beans.*;


public class Main{


     public static void main(String [] args){

        System.out.println("-----------------TEST---------------------");

	MailBoxManager a = new MailBoxManager();
	a.addUser("aa");
	
	System.out.println("-----------------TEST---------------------");

     }
}
