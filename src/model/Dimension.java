package model;

public class Dimension {
	
	private Model model;
	private int width;
	private int height;
	private int length;
	
	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%d x %d x %d )", model, width, length, height);
	}
	
}
