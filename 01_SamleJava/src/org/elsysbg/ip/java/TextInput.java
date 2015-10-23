package org.elsysbg.ip.java;

import java.util.*;

public class TextInput {

	public static void main(String[] args) {
		System.out.print("Enter your name: ");
		final Scanner in = new Scanner(System.in);
		final String name = in.next();
		System.out.println("Hello, " + name);
		in.close();
	}

}
