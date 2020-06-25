package com.jamakick.santasWorkshop2.dao;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.object.PastToy;

public interface ToyHistoryDAO {
	
	public ArrayList<PastToy> getFullToyHistory();
	public ArrayList<PastToy> getSpecificYearToyHistory(int year);
	public ArrayList<PastToy> getChildToys(int childID);
	public ArrayList<PastToy> viewToysMadeByWorker(int elvenID);
	public Array totalDeliveredToys();
	public boolean insertIntoToyHistory(PastToy toy);

}
