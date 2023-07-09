 package com.omraj.JPA;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;
import com.omraj.model.User;

public class UserJPADao {
		    
		 public void insertData(User user) throws ClassNotFoundException, SQLException {
			 EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
				em.close();
	   	  }
    	  
    	  public List<User> fetchAllData() {
    		  EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
				Query q = em.createNativeQuery("select * from user_table", User.class);
				List<User> list = q.getResultList();
				return list;  
    	  }
    	  
    	  public User fetchById(int id){
    		  EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
//				Query q = em.createNativeQuery("select * from user_table u where u.user_id=?1", User.class);
//				q.setParameter(1, id);
//				User user = (User) q.getSingleResult();
    		  
    		    User user=em.find(User.class,id);
				return user;
       	  }
	
    	  public boolean fetchLoginData(User user) {
			  EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
				Query q = em.createNativeQuery(
						"select u.uname,u.password from user_table u where u.uname=?1 and u.password=?2");
				q.setParameter(1, user.getUserName());
				q.setParameter(2, user.getPassword());
				int count =  q.getResultList().size();
				if (count>0)
					return true;
				return false;
		}
    	  public boolean fetchData(User user) {
			  EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
				Query q = em.createNativeQuery(
						"select u.uname from user_table u where u.uname=?1");
				q.setParameter(1, user.getUserName());
				//q.setParameter(2, user.getPassword());
				int count =  q.getResultList().size();
				if (count>0)
					return true;
				return false;
		}
		  
		public boolean updateData(User user) {
			EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
//			Query q = em.createNativeQuery(
//"update user_table u set u.fname= :fname, u.lname= :lname, u.uname= :uname, u.password= :pass where u.user_id= :id",
//					User.class);
//			q.setParameter("fname", user.getFirstname());
//			q.setParameter("lname", user.getLastname());
//			q.setParameter("uname", user.getUserName());
//			q.setParameter("pass", user.getPassword());
//			q.setParameter("id", user.getId());
			// em.merge(user);
			
			//Object u = q.executeUpdate();
			
//			User u=em.find(User.class, user.getId());
//			u.setFirstname(user.getFirstname());
//			u.setLastname(user.getLastname());
			User u=em.merge(user);
			em.getTransaction().commit();
			em.close();
			if (u != null)
				return true;
			return false;
		}
		
		public boolean deleteUser(int id) {
			EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createNativeQuery("delete from user_table u where u.user_id=?1", User.class);
			q.setParameter(1, id);
			
			int status = q.executeUpdate();
			
//			 User u=em.find(User.class,id);
//			 em.remove(u);
			em.getTransaction().commit();
			em.close();
			if (status > 0) 
				return true;
			return false;
			
		}
}
