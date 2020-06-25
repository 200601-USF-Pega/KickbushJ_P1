package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.object.FullProductionObject;
import com.jamakick.santasWorkshop2.object.Toy;

public interface CurrentToysDAO {
	
	public ArrayList<FullProductionObject> getFullToyProduction();
	public boolean addCurrentToy(Toy toy);
	public boolean removeCurrentToy(int toyID);
	public Toy selectFromToysByID(int toyID);

}
