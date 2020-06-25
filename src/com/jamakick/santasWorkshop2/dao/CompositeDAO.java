package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface CompositeDAO {
	
	public boolean sendToyToHistory(int toyID,
			int newToyYear, boolean newToyDelivered);

}
