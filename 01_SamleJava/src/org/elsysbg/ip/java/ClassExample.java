package org.elsysbg.ip.java;

public class ClassExample {

	public static void main(String[] args) {
		// navigate cursor to Room() and press Ctrl+2 L - local variable
		// press Ctrl+2 F to create class field
		// create object of class room
		final Room room = new Room();
		// final -> can't points to another object(room = new Room();)
		
		room.setHeight(12);
		room.setWidth(10);
		
		final int height = room.getHeight();
		System.out.println("Height: " + height);
		
		final int width = room.getWidth();
		System.out.println("Width: " + width);
		
		System.out.println("Area: " + room.calculateArea());
	}

}
