package dao;
import java.sql.ResultSet;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class ModelDao {
	
	public String getBrandName(Model model){
		int brandId = model.getBrandId();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String brandName = "";
		try{
			con = DbUtil.getConnection();
			String query = "select name from Brand where id=?";
			ps.setInt(1, brandId);
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()){
				brandName = rs.getString("name");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return brandName;
	}
	
	public String getModelDimensions(Model model){
		int modelId = model.getModelId();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dimensions = "";
		int length =0;
		int width = 0;
		int height = 0;
		try{
			con = DbUtil.getConnection();
			String query = "select length, width, height from Dimensions where id=?";
			ps.setInt(1, modelId);
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()){
				length = rs.getInt("length");
				width = rs.getInt("width");
				height = rs.getInt("height");
				dimensions = "Length = "+length+" mm, and Width = "+width+" mm, and Height = "+height;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dimensions;
	}
	public Model getModelById(int id){
		Model model = new Model();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = DbUtil.getConnection();
			String query = "select * from Model where id=?";
			ps.setInt(1, id);
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
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
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		return model;
	}
	
	public Model getModelByName(String name){
		Model model = new Model();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = DbUtil.getConnection();
			String query = "select * from Model where model=?";
			ps = con.prepareStatement(query);
			ps.setString(1,name);
			rs = ps.executeQuery();
			
			if(rs.next()){
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
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		return model;
	}
	

}
