package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.object.Elf;

public interface ElvenWorkersDAO {
	
	public boolean addElvenWorker(Elf elf);
	public boolean removeElvenWorker(int elvenID);
	public boolean updateElvenWorkerToys(int elvenID);
	public ArrayList<Elf> viewElvenWorkers();

}
