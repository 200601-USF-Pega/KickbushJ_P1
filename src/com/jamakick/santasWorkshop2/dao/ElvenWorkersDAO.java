package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.object.Elf;

public interface ElvenWorkersDAO {
	
	public boolean addElvenWorker(Connection connection, Elf elf);
	public boolean removeElvenWorker(Connection connection, int elvenID);
	public boolean updateElvenWorkerToys(Connection connection, int elvenID);
	public ArrayList<Elf> viewElvenWorkers(Connection connection);

}
