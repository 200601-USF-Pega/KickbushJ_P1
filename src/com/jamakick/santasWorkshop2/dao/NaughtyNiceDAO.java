package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.object.Child;

public interface NaughtyNiceDAO {
	
	public ArrayList<Child> getFullNaughtyNiceList();
	public boolean addChildToList(Child child);
	public boolean changeChildNaughtyStatus(int childID, boolean naughty);

}
