package model;

import java.util.ArrayList;

public class Account {
	private int accountId;
	private String email;
	private String password;
	private String Fname;
	private String Lname;
	private boolean valid;
	private Wishlist wishlist; //idk if this should be here
	
	public int getAccountId(){
		return accountId;
	}
	public void setAccountId(int id){
		this.accountId = id;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getFname(){
		return Fname;
	}
	public void setFname(String firstName){
		this.Fname = firstName;
	}
	public String getLname(){
		return Lname;
	}
	public void setLname(String lastName){
		this.Lname = lastName;
	}
	public void setValid(boolean newValid) {
		valid = newValid;
	} 
	public boolean isValid() {
		return valid;
	}
	public Wishlist getWishlist(){
		return this.wishlist;
	}
	
}
