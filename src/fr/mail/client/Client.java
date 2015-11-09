package fr.mail.client;

import javax.naming.InitialContext;

import javax.ejb.*;

import java.util.Collection;
import java.util.List;

import fr.mail.ejb.*;
import fr.mail.beans.*;

public class JavaClient {
	public static void main(String args[]) {


	        try {
			InitialContext ic = new InitialContext();
			// (Test) ic.lookup("");



		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}

