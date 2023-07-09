package com.omraj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_table")
public class User {
	@Id
	@Column(name="user_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
	@Column(name="fname")
   private String firstname;
	@Column(name="lname")
   private String lastname;
	@Column(name="uname")
   private String userName;
	@Column(name="password")
   private String password;
   
   public User() {
	   
   }
    public User(String firstname, String lastname, String userName, String password) {
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.userName = userName;
		this.password = password;
     }
   
	public User(int id, String firstname, String lastname, String userName, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.userName = userName;
		this.password = password;
	}
	public User(String userName,String password) {
		this.userName = userName;
		this.password = password;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
    
   
   
}
