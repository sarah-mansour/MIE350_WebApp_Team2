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
				preparedStatement.setInt(1,member.getAccountId());
				preparedStatement.setInt(2,model.getModelId());
				
				preparedStatement.executeUpdate();
				
				//add model to the wishlist arraylist of that member
				member.getWishlist().addModel(model);
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
				preparedStatement.setInt(1, member.getAccountId());
				preparedStatement.setInt(2, model.getModelId());
				
				preparedStatement.executeUpdate();
				
				member.getWishlist().deleteModel(model);
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
			preparedStatement.setInt(1,member.getAccountId());
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
				Model model = new Model();
				
				model.setModelId(rs.getInt("id"));
				model.setModelName(rs.getString("model"));
				model.setYearIssued(rs.getInt("year_issued"));
				model.setBattery(rs.getInt("battery"));
				model.setPower(rs.getInt("power"));
				model.setRange(rs.getInt("battery_range"));
				model.setSpeed(rs.getInt("top_speed"));
				model.setAcceleration(rs.getInt("acceleration"));
				model.setDriveType(rs.getString("drive_type"));
				model.setNumofSeats(rs.getInt("number_of_seats"));
				model.setNumofDoors(rs.getInt("number_of_doors"));
				model.setPrice(rs.getInt("starting_price"));
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
