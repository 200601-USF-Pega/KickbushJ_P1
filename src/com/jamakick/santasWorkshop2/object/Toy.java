package com.jamakick.santasWorkshop2.object;

public class Toy {
	
	private int toyID;
	private String toyName;
	private String toyColor;
	private float workTime;
	private int childID;
	private int elvenID;
	
	public Toy() {
		
	}
	
	public Toy(String toyName, float workTime) {
		super();
		this.setToyName(toyName);
		this.setWorkTime(workTime);
	}
	
	public Toy(String toyName, String toyColor, float workTime) {
		this(toyName, workTime);
		this.setToyColor(toyColor);
	}
	
	public Toy(String toyName, String toyColor, float workTime, int childID, int elvenID) {
		this(toyName, toyColor, workTime);
		this.setChildID(childID);
		this.setElvenID(elvenID);
	}
	
	public Toy(int toyID, String toyName, float workTime) {
		this(toyName, workTime);
		this.setToyID(toyID);
	}
	
	public Toy(int toyID, String toyName, String toyColor, float workTime) {
		this(toyName, toyColor, workTime);
		this.setToyID(toyID);
	}
	
	public Toy(int toyID, String toyName, float workTime, int childID, int elvenID) {
		this(toyID, toyName, workTime);
		this.setChildID(childID);
		this.setElvenID(elvenID);
	}
	
	public Toy(int toyID, String toyName, String toyColor, float workTime, int childID, int elvenID) {
		this(toyID, toyName, workTime, childID, elvenID);
		this.setToyColor(toyColor);
	}
	
	
	@Override
	public String toString() {
		return "Toy [toyID=" + toyID + ", toyName=" + toyName + ", toyColor=" + toyColor + ", workTime=" + workTime
				+ ", childID=" + childID + ", elvenID=" + elvenID + "]";
	}

	public int getToyID() {
		return toyID;
	}
	public void setToyID(int toyID) {
		this.toyID = toyID;
	}
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public String getToyColor() {
		return toyColor;
	}
	public void setToyColor(String toyColor) {
		this.toyColor = toyColor;
	}
	public float getWorkTime() {
		return workTime;
	}
	public void setWorkTime(float workTime) {
		this.workTime = workTime;
	}
	public int getChildID() {
		return childID;
	}
	public void setChildID(int childID) {
		this.childID = childID;
	}
	public int getElvenID() {
		return elvenID;
	}
	public void setElvenID(int elvenID) {
		this.elvenID = elvenID;
	}
	
	
	
	

}
