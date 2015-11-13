# mailBox

1. Telecharger glassfish 4

2. Configurer les variables d'environnement: <br/>
	GLASSFISH_HOME={repertoire de glassfish}/glassish <br/>
	PATH=$GLASSFISH_HOME/bin:$PATH <br/>
	DERBY_HOME={repertoire de glassfish}/javadb <br/>
	PATH=$PATH:$DERBY_HOME/bin <br/>

	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/* <br/>
	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/appserv-rt.jar <br/>
	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/javaee.jar <br/>

	export PATH CLASSPATH GLASSFISH_HOME DERBY_HOME <br/>

3. demarer le serveur d'application en plus de la base de donné Derby: <br/>
	asadmin start-domain domain1 <br/>
	asadmin start-database <br/>


4. cloner le projet : git clone git@github.com:basrimed/mailBox.git et ouvrir le repertoire creer "mailBox" dans un terminal <br/>


5. compiler - deployer l'application :  <br/>
	ant all <br/>

6. lancer le client : <br/>
	 java fr.mail.client.Client <br/>


7. scenario de notre client : 
	1.1 creation d'utilisateur <br/>
	1.2 creation d'une Box	<br/>
	1.3 envoie de message entre utilisateur <br/>
	1.4 l'utilisateur X consulte ses messages non lu (les messages deviennent lu) <br/>
	1.5 l'utilisateur X reçois un nouveau message <br/>
	1.6 l'utilisateur supprime les messae lu <br/>
	1.7 l'utilisateur X consulte ses messages non lu <br/>


	2.1 suppression de plusieurs utilisateur <br/>
	2.2 ajout d'un utilisateur <br/>
	2.3 récuperer la liste de tous les utilisateurs <br/>
	2.4 récuperer la liste de tous les utilisateurs avec leur droits R/W sur les news <br/>






8. utilisation de l'application: <br/>
	1. MailBoxManagerInterface mailBoxManagerInterface = new mailBoxManagerInterface() <br/>
		1.1 List <Object[]> readAUserNewMessages(String receiverName) <br/>
	 	1.2 List <Object[]> readAUserAllMessages(String receiverName) <br/>
	 	1.3 void deleteAUserMessage(long id) <br/>
	 	1.4 void deleteAUserReadMessages(String receiverName) <br/>
	 	1.5 void sendAMessageToBox(String senderName,String receiverName, String subject, String body, long idBox) <br/>
	 	1.6 void addBox(String boxName) <br/>


	2. UsersDirectoryInterface usersDirectoryInterface = new UsersDirectoryInterface() <br/>
		2.1 void addUser(String userName) <br/>
	 	2.2 void removeUser(long id) <br/>
	 	2.3 List<Object[]> lookupAllUsers() <br/>
	 	2.4 Object lookupAUserRights(String userName) <br/>
	 	2.5 void updateAUserRigts(long id,String userName,boolean readRightGroup,boolean writeRightGroup) <br/>
