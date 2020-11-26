package model;

public class Model {
	private int modelId;
	private String modelName;
	private int yearIssued;
	private int battery;
	private int power;
	private int range;
	private int speed;
	private int acceleration;
	private String driveType;
	private int numOfSeats;
	private int numOfDoors;
	private int price;
	private String powerSource;
	private String category;
	private int brandId;
	
	
	public int getModelId(){
		return modelId;
	}
	public void setModelId(int id){
		this.modelId = id;
	}
	public String getModelName(){
		return modelName;
	}
	public void setModelName(String name){
		this.modelName = name;
	}
	public int getYearIssued(){
		return yearIssued;
	}
	public void setYearIssued(int year){
		this.yearIssued = year;
	}
	public int getBattery(){
		return battery;
	}
	public void setBattery(int battery){
		this.battery = battery;
	}
	public int getPower(){
		return power;
	}
	public void setPower(int power){
		this.power= power;
	}
	public int getRange(){
		return range;
	}
	public void setRange(int range){
		this.range = range;
	}
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public int getAcceleration(){
		return acceleration;
	}
	public void setAcceleration(int acceleration){
		this.acceleration= acceleration;
	}
	public String getDriveType(){
		return driveType;
	}
	public void setDriveType(String type){
		this.driveType = type;
	}
	public int getNumOfSeats(){
		return numOfSeats;
	}
	public void setNumofSeats(int numSeats){
		this.numOfSeats = numSeats;
	}
	public int getNumOfDoors(){
		return numOfDoors;
	}
	public void setNumofDoors(int numDoor){
		this.numOfDoors = numDoor;
	}
	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public String getPowerSource(){
		return powerSource;
	}
	public void setPowerSource(String powerS){
		this.powerSource= powerS;
	}
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public int getBrandId(){
		return brandId;
	}
	public void setBrandId(int brand){
		this.brandId = brand;
	}
}
