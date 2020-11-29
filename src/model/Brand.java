package model;

public class Brand {
	
	private int id;
	private String name;
	private String manufacturer; 
	
	public int getId() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString() {
		return String.format("(%d) %s Brand by %s", id, name, manufacturer);
	}
}
