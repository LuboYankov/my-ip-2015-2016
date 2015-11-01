package org.elsysbg.ip.availability;

import java.util.*;

public class HandleInput implements HandleInputs {

	List<User> USERS = new ArrayList<User>();
	
	public int getUserIndex(String name) {
		for(int i = 0; i < USERS.size(); i++) {
			if(name.equals(USERS.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}
	
	public void listavailable() {
		List<String> onlineUsers = new ArrayList<String>();
		for(int i = 0; i < USERS.size(); i++) {
			if((USERS.get(i).isIn())) {
				onlineUsers.add(USERS.get(i).getName());
			}
		}
		if(onlineUsers.size() != 0) {
			System.out.println("Logged in users:");
			for(int i = 0; i < onlineUsers.size(); i++) {
				System.out.println(onlineUsers.get(i));
			}
		} else {
			System.out.println("No one is logged in.");
		}
	}
	
	public void getInput() {
		final Scanner in = new Scanner(System.in);
		System.out.print("Въведете команда: ");
		while(in.hasNext()) {
			parse(in.next());
			System.out.print("Въведете команда: ");
		}
		in.close();
	}
	
	public void parse(String command) throws IllegalArgumentException {
		final String[] cmds = command.split(":");
		if("in".equals(cmds[1])) {
			final int returnCode = this.getUserIndex(cmds[0]);
			if(returnCode != -1){
				System.out.println(USERS.get(returnCode).login());
			} else {
				final User st = new User(cmds[0]);
				System.out.println(st.login());
				USERS.add(st);
			}
		} else if("out".equals(cmds[1])) {
			final int returnCode = this.getUserIndex(cmds[0]);
			if(returnCode != -1){
				System.out.println(USERS.get(returnCode).logout());
			} else {
				final User st = new User(cmds[0]);
				System.out.println(st.logout());
				USERS.add(st);
			}
		} else if("listavaible".equals(cmds[1])) {
			this.listavailable();
		} else if(("info".equals(cmds[1])) && (cmds.length == 3)) {
			System.out.println(cmds[0] + " requested info about " + cmds[2] + ".");
			final int returnCode = this.getUserIndex(cmds[2]);
			if(returnCode != -1){
				System.out.println(USERS.get(returnCode).info());
			} else {
				System.out.println("No information about " + cmds[2] + ".");
			}
		} else if("shutdown".equals(cmds[1])) {
			final int returnCode = this.getUserIndex(cmds[0]);
			if(returnCode != -1 && USERS.get(returnCode).isIn()) {
				System.exit(0);
			} else {
				System.out.println("Please login first.");
			}
		} else {
			throw new IllegalArgumentException("Unknown command: " + command);
		}
	}

}
