package org.elsysbg.ip.java;

public class EqualsExample {

	private static final int WIDTH = 12;
	private static final int HEIGHT = 10;

	public static void main(String[] args) {
		final Room room1 = new Room();
		final Room room2 = new Room();
		
		setDimensions(room1);
		setDimensions(room2);

		// false(pointing to different memory locations)
		System.out.println("room1 == room2 => " + (room1 == room2));
		
		// true(pre-defined in Room class)
		System.out.println("room1.equals(room2) => " + (room1.equals(room2)));
	}

	private static void setDimensions(Room room) {
		room.setHeight(HEIGHT);
		room.setWidth(WIDTH);
	}

}
