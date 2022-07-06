package com.flyaway.entities;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;


@Entity
@Table(name = "usermgmt")
@DynamicInsert
@org.hibernate.annotations.NamedQueries({
	
	
	@org.hibernate.annotations.NamedQuery(name = "UserMgmt_FindByEmailId", 
    query = "from UserMgmt where emailId = :emailId and password = :password and typeOfUser = :typeOfUser"),
	
	@org.hibernate.annotations.NamedQuery(name = "UserMgmt_UpdatePassword", 
    query = "Update UserMgmt set password = :password where emailId = :emailId and typeOfUser = :typeOfUser")
	
})
public class UserMgmt implements Serializable
{
	private static final long serialVersionUID = 3756680645803624405L;
	@Id
	@ColumnDefault("'admin@flyaway.com'")
	private String emailId;  
	@ColumnDefault("'flyaway'")
	private String password; 
	@ColumnDefault("'Admin'")
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



	@Override
	public String toString() {
		return "UserMgmt [emailId=" + emailId + ", password=" + password + ", typeOfUser=" + typeOfUser + "]";
	}
	
	
	
}
