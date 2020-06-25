package com.jamakick.santasWorkshop2.object;

public class PastToy extends Toy{
	
	private int yearProduced;
	private boolean delivered;
	
	public PastToy() {
		
	}
	
	public PastToy(Toy toy) {
		super(toy.getToyName(), toy.getToyColor(), toy.getWorkTime(), toy.getChildID(), toy.getElvenID());
	}
	
	public PastToy(int toyID, String toyName, float workTime, int childID, int elvenID) {
		super(toyID, toyName, workTime, childID, elvenID);
	}
	
	public PastToy(int toyID, String toyName, String toyColor,
			float workTime, int childID, int elvenID) {
		super(toyID, toyName, toyColor, workTime, childID, elvenID);
	}
	
	public PastToy(int toyID, String toyName, float workTime,
			int childID, int elvenID, int yearProduced, boolean delivered) {
		this(toyID, toyName, workTime, childID, elvenID);
		this.setYearProduced(yearProduced);
		this.setDelivered(delivered);
	}
	
	public PastToy(int toyID, String toyName, String toyColor,
			float workTime, int childID, int elvenID, int yearProduced, boolean delivered) {
		this(toyID, toyName, toyColor, workTime, childID, elvenID);
		this.setYearProduced(yearProduced);
		this.setDelivered(delivered);
	}
	
	
	

	@Override
	public String toString() {
		return "PastToy [getToyID()=" + getToyID() + ", getToyName()=" + getToyName() + ", getToyColor()="
				+ getToyColor() + ", getWorkTime()=" + getWorkTime() + ", getChildID()=" + getChildID()
				+ ", getElvenID()=" + getElvenID() + ", yearProduced=" + yearProduced + ", delivered=" + delivered
				+ "]";
	}
	
	

	public int getYearProduced() {
		return yearProduced;
	}
	public void setYearProduced(int yearProduced) {
		this.yearProduced = yearProduced;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	

}
