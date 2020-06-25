package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.object.FullProductionObject;
import com.jamakick.santasWorkshop2.object.Toy;

public interface CurrentToysDAO {
	
	public ArrayList<FullProductionObject> getFullToyProduction(Connection connection);
	public boolean addCurrentToy(Connection connection, Toy toy);
	public boolean removeCurrentToy(Connection connection, int toyID);
	public Toy selectFromToysByID(Connection connection, int toyID);

}
