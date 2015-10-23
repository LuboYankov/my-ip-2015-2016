package org.elsysbg.ip.java;

import java.util.*;

public class TextInput {

	public static void main(String[] args) {
		System.out.print("Enter your name: ");
		// standard input is held by System.in
		final Scanner in = new Scanner(System.in);
		// get text from standard input
		// scanner is used
		final String name = in.next();
		// instead we can use: BufferedReader, DataInputStream, InputStream, ObjectInputStream, ect.
		System.out.println("Hello, " + name);
		// closing the scanner
		in.close();
	}

}
