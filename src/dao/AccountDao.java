package dao;


import util.DbUtil;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static String logMessage; // this holds the last message by the last action/method called
	static int actionResult; // this indicates if the action/method was successful or not
	// a return value of 0 means the action was successful and other numbers means failure otherwise
	// you can see the log message to know what exactly happened during the failure
	
	public static Account login(Account member) {

		/**
		 * This method attempts to find the member that is trying to log in by
		 * first retrieving the email and password entered by the user.
		 */
		Statement stmt = null;

		String email = member.getEmail();
		String password = member.getPassword();

		/**
		 * Prepare a query that searches the account table in the database
		 * with the given email and password.
		 */
		String searchQuery = "select * from Account where email='"
				+ email + "' AND password='" + password + "'";

		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			/**
			 * If there are no results from the query, set the account to false.
			 * The person attempting to log in will be redirected to the home
			 * page when isValid is false.
			 */
			
			if (!more) {
				member.setValid(false);
			}

			/**
			 * If the query results in an database entry that matches the
			 * email and password, assign the appropriate information to
			 * the account object.
			 */
			else if (more) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int id = rs.getInt("id");
				
				member.setId(id);
				member.setEmail(email);
				member.setPassword(password);
				member.setFirstName(firstName);
				member.setLastName(lastName);
				member.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed"+ ex);
		}
		/**
		 * Return the Account object.
		 */
		return member;

	}
	
	public static Account logout (Account member) {
		member.setValid(false); // invalidate the user in order to logout
		return member;
	}
	
	public static Account signup(Account newMember){	
		
		int id = newMember.getId();
		String firstName = newMember.getFirstName();
		String lastName = newMember.getLastName();
		String email = newMember.getEmail();
		String password = newMember.getPassword();
		
		//Statement preparedStatement = null;	
		try{
			currentCon = DbUtil.getConnection();
			String query = "insert into Account(id, email,password,first_name,last_name) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = currentCon.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, lastName);
			
			int i = preparedStatement.executeUpdate();
			if (i !=0){
				logMessage = "Account Created!";
				actionResult = 0; // this means it was successful
			}
			
		}catch(SQLException e){
			logMessage =  "Account creation failed: An Exception has occurred!";
			actionResult = -1; // this indicates that the method failed
		}
		//return "Failed to Create Account";
		return newMember;
	}
	

}


