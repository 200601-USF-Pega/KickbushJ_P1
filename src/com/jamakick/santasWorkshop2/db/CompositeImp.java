package com.jamakick.santasWorkshop2.db;

import com.jamakick.santasWorkshop2.dao.CompositeDAO;
import com.jamakick.santasWorkshop2.dao.CurrentToysDAO;
import com.jamakick.santasWorkshop2.dao.ElvenWorkersDAO;
import com.jamakick.santasWorkshop2.dao.ToyHistoryDAO;
import com.jamakick.santasWorkshop2.object.PastToy;
import com.jamakick.santasWorkshop2.object.Toy;

public class CompositeImp implements CompositeDAO {
	
	private CurrentToysDAO currentToysService = new CurrentToysImp();
	private ElvenWorkersDAO elvenWorkersService = new ElvenWorkersImp();
	private ToyHistoryDAO toyHistoryService = new ToyHistoryImp();

	@Override
	public boolean sendToyToHistory(int toyID, int newToyYear,
			boolean newToyDelivered) {
		
			Toy selectToy = currentToysService.selectFromToysByID(toyID);
			
			if (selectToy.getToyName() == null) {
				return false;
			}
			
			PastToy toy = new PastToy(selectToy);
			toy.setYearProduced(newToyYear);
			toy.setDelivered(newToyDelivered);
			
			currentToysService.removeCurrentToy(toyID);
			
			elvenWorkersService.updateElvenWorkerToys(toy.getElvenID());
		
			toyHistoryService.insertIntoToyHistory(toy);
			
			return true;
			
		}
		
	}

