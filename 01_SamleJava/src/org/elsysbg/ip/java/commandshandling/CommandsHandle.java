package org.elsysbg.ip.java.commandshandling;

import java.util.Scanner;

public class CommandsHandle {

	public static void main(String[] args) {
		System.out.print("Enter command: ");
		
		final Scanner in = new Scanner(System.in);
		final String command = in.next();
		final CommandHandler handler = parse(command);
		
		final int result = handler.execute();
		System.out.println("Result: " + result);
		in.close();
	}
	
	// @param command -> sum:1:2
	// @return result
	// @throw Ilthrow new IllegalArgumentException("Unknown command: " + command); if command is incorrect
	private static CommandHandler parse(String command) {
		final String[] split = command.split(":");
		if("sum".equals(split[0])) {
			return new SumCommandHandler(split);
		}
		throw new IllegalArgumentException("Unknown command: " + command);
	}
	
	public int run() {
		return 0;
	}
}
