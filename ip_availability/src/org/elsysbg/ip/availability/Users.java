package org.elsysbg.ip.availability;

public interface Users {
	public String login();
	public String logout();
	public String getName();
	public int getLoginCounts();
	public boolean isIn();
	public String info();
}
