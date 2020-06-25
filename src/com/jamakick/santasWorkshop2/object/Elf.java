package com.jamakick.santasWorkshop2.object;

public class Elf {
	
	private int elvenID;
	private String elvenName;
	private int elvenAge;
	private String positionName;
	private int shiftNumber;
	private int numProducedToys;
	
	
	public Elf() {
		
	}
	
	public Elf(String elvenName, String positionName, int shiftNumber, int numProducedToys) {
		super();
		this.setElvenName(elvenName);
		this.setPositionName(positionName);
		this.setShiftNumber(shiftNumber);
		this.setNumProducedToys(numProducedToys);
		
	}
	
	public Elf(int elvenID, String elvenName, String positionName, int shiftNumber, int numProducedToys) {
		this(elvenName, positionName, shiftNumber, numProducedToys);
		this.setElvenID(elvenID);
	}
	
	public Elf(int elvenID, String elvenName, int elvenAge, String positionName, 
			int shiftNumber, int numProducedToys) {
		
		this(elvenID, elvenName, positionName, shiftNumber, numProducedToys);
		this.setElvenAge(elvenAge);
	}
	
	public Elf(String elvenName, int elvenAge, String positionName, int shiftNumber, int numProducedToys) {
		this(elvenName, positionName, shiftNumber, numProducedToys);
		this.setElvenAge(elvenAge);
	}
	
	

	@Override
	public String toString() {
		return "Elf [elvenID=" + elvenID + ", elvenName=" + elvenName + ", elvenAge=" + elvenAge + ", positionName="
				+ positionName + ", shiftNumber=" + shiftNumber + ", numProducedToys=" + numProducedToys + "]";
	}

	public int getElvenID() {
		return elvenID;
	}

	public void setElvenID(int elvenID) {
		this.elvenID = elvenID;
	}

	public String getElvenName() {
		return elvenName;
	}

	public void setElvenName(String elvenName) {
		this.elvenName = elvenName;
	}

	public int getElvenAge() {
		return elvenAge;
	}

	public void setElvenAge(int elvenAge) {
		this.elvenAge = elvenAge;
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
