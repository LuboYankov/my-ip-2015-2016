package org.elsysbg.ip.availability;

public class User {
	
	private String name;
	private int loginCount;
	private boolean in;
	
	public User(String username) {
		this.name = username;
		this.loginCount = 0;
		this.in = false;
	}
	
	public String login() {
		if(isIn()) {
			return this.getName() + " is already logged in.";
		}
		this.in = true;
		this.loginCount++;
		return this.getName() + " logged in."; 
	}
	
	public String logout() {
		if(!isIn()) {
			return this.getName() + " is already logged out.";
		}
		this.in = false;
		return this.getName() + " logged out.";
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLoginCounts() {
		return this.loginCount;
	}
	
	public boolean isIn() {
		return in;
	}
	
	public String info() {
		if(isIn()) {
			return this.getName() + " is logged in. Logins count: " + this.getLoginCounts();
		} else {
			return this.getName() + " is logged out. Logins count: " + this.getLoginCounts();
		}
	}

}
