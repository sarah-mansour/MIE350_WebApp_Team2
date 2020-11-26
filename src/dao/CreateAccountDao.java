package dao;
import util.DbUtil;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountDao {
	
	private Connection connection;
	
	public String createAccount(Account newMember){
		// this method adds a new account to the database 
		
		
		String firstName = newMember.getFname();
		String lastName = newMember.getLname();
		String email = newMember.getEmail();
		String password = newMember.getPassword();
		String msg = "";
		
		//Statement preparedStatement = null;	
		try{
			connection = DbUtil.getConnection();
			String query = "insert into Account(email,password,first_name,last_name) values (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, lastName);
			
			int i = preparedStatement.executeUpdate();
			if (i !=0){
				msg = "Account Created!";
			}
			
		}catch(SQLException e){
			msg =  "Account creation failed: An Exception has occurred!";
		}
		//return "Failed to Create Account";
		return msg;
	}

}
