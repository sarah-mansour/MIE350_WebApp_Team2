package model;

public class Model {
	
	private int id;
	private String model;
	private int year_issued;
	private double battery;
	private double power;
	private int battery_range;
	private double top_speed;
	private double acceleration;
	private String drive_type;
	private int number_of_seats;
	private int number_of_doors;
	private int starting_price;
	private String power_source;
	private String category;
	private Brand brand;
	private int brandId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getBrandId() {
		return brandId;
	}
	
	public void setBrandId(int Brandid) {
		this.brandId = Brandid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearIssued() {
		return year_issued;
	}

	public void setYearIssued(int year_issued) {
		this.year_issued = year_issued;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getBattery() {
		return battery;
	}

	public void setBattery(double battery) {
		this.battery = battery;
	}

	public double getTopSpeed() {
		return top_speed;
	}

	public void setTopSpeed(double top_speed) {
		this.top_speed = top_speed;
	}

	public int getBatteryRange() {
		return battery_range;
	}

	public void setBatteryRange(int battery_range) {
		this.battery_range = battery_range;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public String getDriveType() {
		return drive_type;
	}

	public void setDriveType(String drive_type) {
		this.drive_type = drive_type;
	}

	public int getNumberOfDoors() {
		return number_of_doors;
	}

	public void setNumberOfDoors(int number_of_doors) {
		this.number_of_doors = number_of_doors;
	}

	public int getNumberOfSeats() {
		return number_of_seats;
	}

	public void setNumberOfSeats(int number_of_seats) {
		this.number_of_seats = number_of_seats;
	}

	public String getPowerSource() {
		return power_source;
	}

	public void setPowerSource(String power_source) {
		this.power_source = power_source;
	}

	public int getStartingPrice() {
		return starting_price;
	}

	public void setStartingPrice(int starting_price) {
		this.starting_price = starting_price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return String.format("(%d) %s Model", id, model);
	}
	
	

}

