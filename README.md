# mailBox

1. Telecharger glassfish 4

2. Configurer les variables d'environnement:
	GLASSFISH_HOME={repertoire de glassfish}/glassish
	PATH=$GLASSFISH_HOME/bin:$PATH 
	DERBY_HOME={repertoire de glassfish}/javadb 
	PATH=$PATH:$DERBY_HOME/bin 

	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/* 
	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/appserv-rt.jar 
	CLASSPATH=$CLASSPATH:$GLASSFISH_HOME/lib/javaee.jar 

	export PATH CLASSPATH GLASSFISH_HOME DERBY_HOME

3. demarer le serveur d'application en plus de la base de donné Derby:
	asadmin start-domain domain1
	asadmin start-database


4. cloner le projet : git clone git@github.com:basrimed/mailBox.git et ouvrir le repertoire creer "mailBox" dans un terminal


5. compiler - deployer l'application : 
	ant all

6. lancer le client :
	 java fr.mail.client.Client


7. scenario de notre client : 
	1.1 creation d'utilisateur
	1.2 creation d'une Box	
	1.3 envoie de message entre utilisateur
	1.4 l'utilisateur X consulte ses messages non lu (les messages deviennent lu)
	1.5 l'utilisateur X reçois un nouveau message
	1.6 l'utilisateur supprime les messae lu
	1.7 l'utilisateur X consulte ses messages non lu


	2.1 suppression de plusieurs utilisateur
	2.2 ajout d'un utilisateur
	2.3 récuperer la liste de tous les utilisateurs
	2.4 récuperer la liste de tous les utilisateurs avec leur droits R/W sur les news






8. utilisation de l'application:
	1. MailBoxManagerInterface mailBoxManagerInterface = new mailBoxManagerInterface()
		1.1 List <Object[]> readAUserNewMessages(String receiverName)
	 	1.2 List <Object[]> readAUserAllMessages(String receiverName)
	 	1.3 void deleteAUserMessage(long id)
	 	1.4 void deleteAUserReadMessages(String receiverName)
	 	1.5 void sendAMessageToBox(String senderName,String receiverName, String subject, String body, long idBox)
	 	1.6 void addBox(String boxName)


	2. UsersDirectoryInterface
		2.1 void addUser(String userName)
	 	2.2 void removeUser(long id)
	 	2.3 List<Object[]> lookupAllUsers()
	 	2.4 Object lookupAUserRights(String userName)
	 	2.5 void updateAUserRigts(long id,String userName,boolean readRightGroup,boolean writeRightGroup)
		



