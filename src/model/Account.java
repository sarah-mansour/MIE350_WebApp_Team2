package model;

public class Account {
	private int id;
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	private boolean isValid;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
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
	
	public String getFirstName(){
		return first_name;
	}
	
	public void setFirstName(String firstName){
		this.first_name = firstName;
	}
	
	public String getLastName(){
		return last_name;
	}
	
	public void setLastName(String lastName){
		this.last_name = lastName;
	}
	
	@Override
	public String toString() {
		return String.format("(%d) %s (%s %s)", id, email, first_name, last_name);
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}

