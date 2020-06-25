package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface CompositeDAO {
	
	public boolean sendToyToHistory(Connection connection, int toyID,
			int newToyYear, boolean newToyDelivered);

}
