package model;

public class ModelColor {
	
	private Model model;
	private String color;
	
	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s)", model, color);
	}
	
}

