package com.dovile.userlogin.entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	
	 @OneToMany(mappedBy="user")
	private List <Records> records;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Records> getRecords() {
		return records;
	}
	public void setRecords(List<Records> records) {
		this.records = records;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", records=" + records + "]";
	}
	
	
	public String hardcodePass(String name) {
		
		MessageDigest md;
		 StringBuilder sb=null;
		try {
			md = MessageDigest.getInstance("MD5");
			 byte[] hashInBytes = md.digest(name.getBytes(StandardCharsets.UTF_8));

		        sb = new StringBuilder();
		        for (byte b : hashInBytes) {
		            sb.append(String.format("%02x", b));
		        }
		} catch (NoSuchAlgorithmException e) {
			 System.out.println("Exception occurred");
		}
		
		
		return sb.toString();
		
	}
	
	
	
	

}
