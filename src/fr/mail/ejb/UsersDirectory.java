package fr.mail.ejb;

import fr.mail.beans.*;

import java.util.*;
import javax.ejb.*;
import javax.persistence.*;

@Stateless(name="fr/mail/ejb/UserDirectoryInterace")
public class UsersDirectory implements UsersDirectoryInterface{

	@PersistenceContext(unitName="pu1")
    	private EntityManager em;

	public void UsersDirectory(){
	}


	public void addUser(String userName) {
		FinalUser finalUser = new FinalUser(userName);
		em.persist(finalUser);

		}


	public void removeUser(long id){
		FinalUser finalUser = new FinalUser();
		finalUser.setId(id);
		finalUser=em.merge(finalUser);
		em.remove(finalUser);
	}



	public List<Object[]> lookupAllUsers() {
		Query q = em.createQuery("select u.id, u.userName from FinalUser u");
        	List <Object[]> results = q.getResultList();
		return results ;
		}


	public Object lookupAUserRights(String userName) {
		Query q = em.createQuery("select u from FinalUser u where u.userName = :userName");
		q.setParameter("userName",userName);
        	Object result = q.getSingleResult();
		return result ;
		}



	public void updateAUserRigts(long id,String userName,boolean readRightGroup,boolean writeRightGroup) {
		FinalUser finalUser = new FinalUser();
		finalUser.setId(id);
		finalUser.setUserName(userName);
		finalUser.updateReadRightGroup(readRightGroup);
		finalUser.updateWriteRightGroup( writeRightGroup);
		em.merge(finalUser);
		}



	public void deleteAllUser(){
		Query q = em.createQuery("delete from FinalUser");
		q.executeUpdate();
		}


}
