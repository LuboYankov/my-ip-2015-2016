package org.elsysbg.ip.java;

public class Room {
	
	// define fields
	private int width;
	private int height;
	
	// getters and setters:
	// rigth click > Source > Generate getters and setters
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		// check value of width is positive
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int calculateArea() {
		// to change return type move cursor to return and press Ctrl+1
		return height * width;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Room) {
			final Room room2 = (Room) obj;
			return room2.height == height && room2.width == width;
		}
		return false;
	}
}
