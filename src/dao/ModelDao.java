package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Brand;
import model.Model;
import util.DbUtil;

public class ModelDao {

	static Connection connection = null;
	static ResultSet result = null;
	static String logMessage = "";
	static int actionResult = 0;

	public static Model createModel(Model model, ResultSet result) throws SQLException {
		
		Integer id = result.getInt("model.id");
		String model_name = result.getString("model");
		Integer year_issued = result.getInt("year_issued");
		String category = result.getString("category");
		String brand_name = result.getString("name");
		//---------------------------------------------
		Double battery = result.getDouble("battery");
		Double power = result.getDouble("power");
		Integer battery_range = result.getInt("battery_range");
		Double acceleration = result.getDouble("acceleration");
		Double top_speed = result.getDouble("top_speed");
		String drive_type = result.getString("drive_type");
		Integer number_of_seats = result.getInt("number_of_seats");
		Integer number_of_doors = result.getInt("number_of_doors");
		Integer starting_price = result.getInt("starting_price");
		String power_source = result.getString("power_source");
		
		
		Brand brand = new Brand();
		
		brand.setName(brand_name);

		model.setId(id);
		model.setModel(model_name);
		model.setYearIssued(year_issued);
		model.setCategory(category);
		model.setBrand(brand);
		model.setBattery(battery);
		model.setPower(power);
		model.setBatteryRange(battery_range);
		model.setAcceleration(acceleration);
		model.setTopSpeed(top_speed);
		model.setDriveType(drive_type);
		model.setNumberOfSeats(number_of_seats);
		model.setNumberOfDoors(number_of_doors);
		model.setStartingPrice(starting_price);
		model.setPowerSource(power_source);

		return model;

	}

	public static ArrayList<Model> findModels(String brand, String model, String year) {

		ArrayList<Model> models = new ArrayList<Model>();

		connection = DbUtil.getConnection();

		String query = "SELECT * FROM Model, Brand WHERE Model.brand = Brand.id";

		// generate the right query string

		if (!model.equals("null")) {
			query += String.format(" AND model = \"%s\"", model);
		} else if (!brand.equals("null")) {
			query += String.format(" AND Brand.name = \"%s\"", brand);
		}

		if (!year.equals("null")) {
			query += String.format(" AND year_issued = %s", year);
		}

		// execute the query

		try {
			result = connection.createStatement().executeQuery(query);

			while (result.next()) {

				Model m = createModel(new Model(), result);

				models.add(m);
			}

			logMessage = "search models query was successful";
			actionResult = 0;
		} catch (SQLException e) {
			e.printStackTrace();
			logMessage = "error occurred while searching for models";
			actionResult = -1;
		}

		return models;
	}
	
	public static Model loadModel(Model model) {
		
		int id = model.getId();
		
		String query = "SELECT * FROM Model, Brand WHERE Model.brand = Brand.id";
		
		query += String.format(" AND Model.id = %d", id);
		
		connection = DbUtil.getConnection();
		
		try {
			result = connection.createStatement().executeQuery(query);
			if(result.next()) {
				createModel(model, result);
			}
			logMessage = String.format("Model %d was loaded successfully", id);
			actionResult = 0;
		} catch (SQLException e) {
			e.printStackTrace();
			logMessage = String.format("error loading Model %d", id);
			actionResult = -1;
		}
		
		return model;
	}

	public static String getLogMessage() {
		return logMessage;
	}

}
