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
				
				member.setAccountId(id);
				member.setEmail(email);
				member.setPassword(password);
				member.setFname(firstName);
				member.setLname(lastName);
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
	

}


