package com.jamakick.santasWorkshop2.object;

public class LoginReturn {
	
	private boolean correctLoginInfo;
	
	public LoginReturn() {
		
	}
	
	public LoginReturn(boolean info) {
		this.setCorrectLoginInfo(info);
	}

	public boolean isCorrectLoginInfo() {
		return correctLoginInfo;
	}

	public void setCorrectLoginInfo(boolean correctLoginInfo) {
		this.correctLoginInfo = correctLoginInfo;
	}
	
	

}
