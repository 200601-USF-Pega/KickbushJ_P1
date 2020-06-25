package com.jamakick.santasWorkshop2.dao;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.object.PastToy;

public interface ToyHistoryDAO {
	
	public ArrayList<PastToy> getFullToyHistory(Connection connection);
	public ArrayList<PastToy> getSpecificYearToyHistory(Connection connection, int year);
	public ArrayList<PastToy> getChildToys(Connection connection, int childID);
	public ArrayList<PastToy> viewToysMadeByWorker(Connection connection, int elvenID);
	public Array totalDeliveredToys(Connection connection);
	public boolean insertIntoToyHistory(Connection connection, PastToy toy);

}
