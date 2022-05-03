package com.example.tutorme.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

interface Profile {
	public int getID();
	public boolean isRegistered();
	public boolean authenticate(String username, String password);
	public boolean isOnline();
}

 class Account implements Profile{
	
	int id, numOfSessions, rating;
	long phone;
	String username, password, email;
	boolean registered, authenticated, online;
	String reviews[];
	protected String userType;


	Account(String username, String password, String email){
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public void setPhone(long phone){
		if(phone > 999999999 && phone < 999999999 ){
			this.phone = phone;
		}
	}

	protected void changePwd(String oldPwd, String newPwd){
		if(oldPwd.equals(password)){
			password = newPwd;
		}
	}
	
	public int getID(){
		return id;
	};
	public boolean isRegistered(){
		return registered;
	}
	public boolean authenticate(String username, String password){
		if(username.equals(username) && password.equals(this.password)){
			return true;
		}else{
			return false;
		}
	}
	public boolean isOnline(){
		return online;
	};
}