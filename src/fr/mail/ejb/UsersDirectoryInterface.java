package fr.mail.ejb;


import fr.mail.beans.*;
import javax.ejb.Remote;
import java.util.*;

@Remote
public interface UsersDirectoryInterface {

	public void addUser(String userName) ;
	public void removeUser(long id) ;
	public List<Object[]> lookupAllUsers() ;
	public Object lookupAUserRights(String userName) ;
	public void updateAUserRigts(long id,String userName,boolean readRightGroup,boolean writeRightGroup) ;
	public void deleteAllUser();
}
