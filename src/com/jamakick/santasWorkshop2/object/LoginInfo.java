package com.jamakick.santasWorkshop2.object;

public class LoginInfo {
	
	private int empID;
	private String pass;
	private boolean manager;
	
	public LoginInfo() {
		
	}
	
	public LoginInfo(int empID, String pass, boolean manager) {
		this.setEmpID(empID);
		this.setPass(pass);
		this.setManager(manager);
		
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

}
