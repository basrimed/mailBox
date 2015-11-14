# mailBox

1. Télécharger glassfish 4

2. Configurer les variables d'environnement: <br/>
	GLASSFISH_HOME={repertoire de glassfish}/glassish <br/>
	PATH=$GLASSFISH_HOME/bin:$PATH <br/>
	DERBY_HOME={repertoire de glassfish}/javadb <br/>
	PATH=$PATH:$DERBY_HOME/bin <br/>

	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/* <br/>
	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/appserv-rt.jar <br/>
	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/javaee.jar <br/>

	export PATH CLASSPATH GLASSFISH_HOME DERBY_HOME <br/>

3. Démarrer le serveur d'application en plus de la base de donné Derby: <br/>
	asadmin start-domain domain1 <br/>
	asadmin start-database <br/>


4. Cloner le projet : git clone <a href="">git@github.com:basrimed/mailBox.git et ouvrir le repertoire creer "mailBox" dans un terminal <br/>


5. Compiler et déployer l'application :  <br/>
	ant all <br/>

6. Lancer le client : <br/>
	 java fr.mail.client.Client <br/>


7. Scenario de notre client : 
	7.1 création de plusieurs d'utilisateurs <br/>
	7.2 création d'une Box	<br/>
	7.3 envoie de message entre utilisateurs <br/>
	7.4 l'utilisateur X consulte ses messages non lu (les messages deviennent lu) <br/>
	7.5 l'utilisateur X reçois un nouveau message <br/>
	7.6 l'utilisateur supprime les messages lu <br/>
	7.7 l'utilisateur X consulte ses messages non lu <br/>


	7.8 suppression de plusieurs utilisateurs <br/>
	7.9 ajout d'un utilisateur <br/>
	7.10 récupérer la liste de tous les utilisateurs <br/>
	7.11 récupérer la liste de tous les utilisateurs avec leur droits R/W sur les news <br/>






8. Utilisation de l'application: <br/>
	8.a MailBoxManagerInterface mailBoxManagerInterface = new mailBoxManagerInterface() <br/>
		8.a.1 List <Object[]> readAUserNewMessages(String receiverName) <br/>
	 	8.a.1.2 List <Object[]> readAUserAllMessages(String receiverName) <br/>
	 	8.a.1.3 void deleteAUserMessage(long id) <br/>
	 	8.a.1.4 void deleteAUserReadMessages(String receiverName) <br/>
	 	8.a.1.5 void sendAMessageToBox(String senderName,String receiverName, String subject, String body, long idBox) <br/>
	 	8.a.1.6 void addBox(String boxName) <br/>


	8.b UsersDirectoryInterface usersDirectoryInterface = new UsersDirectoryInterface() <br/>
		8.b.1 void addUser(String userName) <br/>
	 	8.b.2 void removeUser(long id) <br/>
	 	8.b.3 List<Object[]> lookupAllUsers() <br/>
	 	8.b.4 Object lookupAUserRights(String userName) <br/>
	 	8.b.5 void updateAUserRigts(long id,String userName,boolean readRightGroup,boolean writeRightGroup) <br/>
