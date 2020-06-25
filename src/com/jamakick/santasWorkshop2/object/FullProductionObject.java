package com.jamakick.santasWorkshop2.object;

public class FullProductionObject {
	
	private int toyID;
	private String toyName;
	private String toyColor;
	private float workTime;
	private String childName;
	private boolean naughty;
	private String elvenName;
	private String positionName;
	private int shiftNumber;
	private int numProducedToys;
	
	public FullProductionObject() {
		
	}
	
	public FullProductionObject(int toyID, String toyName, String toyColor,
			float workTime, String childName, boolean naughty, String elvenName,
			String positionName, int shiftNumber, int numProducedToys) {
		this.setToyID(toyID);
		this.setToyName(toyName);
		this.setToyColor(toyColor);
		this.setWorkTime(workTime);
		this.setChildName(childName);
		this.setNaughty(naughty);
		this.setElvenName(elvenName);
		this.setPositionName(positionName);
		this.setShiftNumber(shiftNumber);
		this.setNumProducedToys(numProducedToys);
		
	}
	
	@Override
	public String toString() {
		return "FullProductionObject [toyID=" + toyID + ", toyName=" + toyName + ", toyColor=" + toyColor
				+ ", workTime=" + workTime + ", childName=" + childName + ", naughty=" + naughty + ", elvenName="
				+ elvenName + ", positionName=" + positionName + ", shiftNumber=" + shiftNumber + ", numProducedToys="
				+ numProducedToys + "]";
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

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public boolean isNaughty() {
		return naughty;
	}

	public void setNaughty(boolean naughty) {
		this.naughty = naughty;
	}

	public String getElvenName() {
		return elvenName;
	}

	public void setElvenName(String elvenName) {
		this.elvenName = elvenName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getShiftNumber() {
		return shiftNumber;
	}

	public void setShiftNumber(int shiftNumber) {
		this.shiftNumber = shiftNumber;
	}

	public int getNumProducedToys() {
		return numProducedToys;
	}

	public void setNumProducedToys(int numProducedToys) {
		this.numProducedToys = numProducedToys;
	}

}
