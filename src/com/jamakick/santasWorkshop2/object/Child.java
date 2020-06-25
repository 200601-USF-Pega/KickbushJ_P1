package com.jamakick.santasWorkshop2.object;

public class Child {
	
	private int childID;
	private String childName;
	private int childAge;
	private Boolean naughty;
	
	public Child() {
		
	}
	
	public Child(String childName, Boolean naughty) {
		super();
		this.setChildName(childName);
		this.setNaughty(naughty);
	}
	
	public Child(String childName, int childAge, Boolean naughty) {
		this(childName, naughty);
		this.setChildAge(childAge);
	}
	
	public Child(int childID, String childName, Boolean naughty) {
		this(childName, naughty);
		this.setChildID(childID);
	}
	
	public Child(int childID, String childName, int childAge, Boolean naughty) {
		this(childName, childAge, naughty);
		this.setChildID(childID);
	}

	
	@Override
	public String toString() {
		return "Child [childID=" + childID + ", childName=" + childName + ", childAge=" + childAge + ", naughty="
				+ naughty + "]";
	}

	public int getChildID() {
		return childID;
	}
	public void setChildID(int childID) {
		this.childID = childID;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public int getChildAge() {
		return childAge;
	}
	public void setChildAge(int childAge) {
		this.childAge = childAge;
	}
	public Boolean getNaughty() {
		return naughty;
	}
	public void setNaughty(Boolean naughty) {
		this.naughty = naughty;
	}
		

}
