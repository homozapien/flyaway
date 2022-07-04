package com.flyaway.entities;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usermgmt")
public class UserMgmt implements Serializable
{
	private static final long serialVersionUID = 3756680645803624405L;
	@Id
	@Column(columnDefinition = "varchar(255) default 'admin@flyaway.com'")
	private String emailId;  
	@Column(columnDefinition = "varchar(255) default 'admin'")
	private String password; 
	@Column(columnDefinition = "varchar(255) default 'Admin'")
	private String typeOfUser;	
	
	public UserMgmt() {
		super();		
	}
	
	
	
	public UserMgmt(String emailId, String password, String typeOfUser) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.typeOfUser = typeOfUser;
	}



	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getTypeOfUser() {
		return typeOfUser;
	}



	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	
}
