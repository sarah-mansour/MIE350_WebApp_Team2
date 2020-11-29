package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;
import model.*;

public class WishlistDao {
	
	private Connection connection;
	
	public void addToWishlist(Account member, Model model){
		//check if user is logged in in the servlett
		//check if account is valid then add model to the table
		if (member.isValid() == true){
			connection = DbUtil.getConnection();
			try{
				PreparedStatement preparedStatement = connection.
						prepareStatement("insert into Wishlist(account,model) values (?,?)");
				preparedStatement.setInt(1,member.getId());
				preparedStatement.setInt(2,model.getId());
				
				preparedStatement.executeUpdate();
				
				//add model to the wishlist arraylist of that member
				//Sarah removed this 
				//member.getWishlist().addModel(model);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void deleteFromWishlist(Account member, Model model){
		if (member.isValid() == true){
			connection = DbUtil.getConnection();
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from Wishlist where account=? AND model=?");
				preparedStatement.setInt(1, member.getId());
				preparedStatement.setInt(2, model.getId());
				
				preparedStatement.executeUpdate();
				//Sarah removed this 
				//member.getWishlist().deleteModel(model);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Model> viewWishlist(Account member){ // or list? idk
		
		List<Model> modelsInWishlist = new ArrayList<Model>();
		//String query = "select * from Wishlist where id =?";
				
		//member.getAccountId();
		//returns all model ids
		try{
			Statement statement = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Wishlist where id =?");
			preparedStatement.setInt(1,member.getId());
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
				Model model = new Model();
				
				model.setId(rs.getInt("id"));
				model.setModel(rs.getString("model"));
				model.setYearIssued(rs.getInt("year_issued"));
				model.setBattery(rs.getInt("battery"));
				model.setPower(rs.getInt("power"));
				model.setBatteryRange(rs.getInt("battery_range"));
				model.setTopSpeed(rs.getInt("top_speed"));
				model.setAcceleration(rs.getInt("acceleration"));
				model.setDriveType(rs.getString("drive_type"));
				model.setNumberOfSeats(rs.getInt("number_of_seats"));
				model.setNumberOfDoors(rs.getInt("number_of_doors"));
				model.setStartingPrice(rs.getInt("starting_price"));
				model.setPowerSource(rs.getString("power_source"));
				model.setCategory(rs.getString("category"));
				model.setBrandId(rs.getInt("brand"));
				
				modelsInWishlist.add(model);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelsInWishlist;
		
	}

}
