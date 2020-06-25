package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.object.Child;

public interface NaughtyNiceDAO {
	
	public ArrayList<Child> getFullNaughtyNiceList(Connection connection);
	public boolean addChildToList(Connection connection, Child child);
	public boolean changeChildNaughtyStatus(Connection connection, int childID, boolean naughty);

}
