package com.jamakick.santasWorkshop2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.dao.ElvenWorkersDAO;
import com.jamakick.santasWorkshop2.object.Elf;

public class ElvenWorkersImp implements ElvenWorkersDAO {

	@Override
	public boolean addElvenWorker(Connection connection, Elf elf) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call addElf(?, ?, ?, ?, ?);");
			
			pst.setString(1, elf.getElvenName());
			pst.setInt(2, elf.getElvenAge());
			pst.setString(3, elf.getPositionName());
			pst.setInt(4, elf.getShiftNumber());
			pst.setInt(5, elf.getNumProducedToys());
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean removeElvenWorker(Connection connection, int elvenID) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call removeElf(?);");
			
			pst.setInt(1, elvenID);
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			return false;
		}

	}

	@Override
	public boolean updateElvenWorkerToys(Connection connection, int elvenID) {

		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("UPDATE ElvenWorkers "
					+ "SET numProducedToys = numProducedToys + 1 "
					+ "WHERE elvenID = ?");
			
			pst.setInt(1, elvenID);
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			return false;
		}

	}

	@Override
	public ArrayList<Elf> viewElvenWorkers(Connection connection) {
		
		ArrayList<Elf> elves = new ArrayList<Elf>();
		
		try {
			Statement s = connection.createStatement();
			s.executeQuery("SELECT * FROM ElvenWorkers ORDER BY elvenID ASC;");
			
			ResultSet rs = s.getResultSet();
			
			while (rs.next()) {
				
				Elf elf = new Elf();
				elf.setElvenID(rs.getInt("elvenID"));
				elf.setElvenName(rs.getString("elvenName"));
				elf.setElvenAge(rs.getInt("elvenAge"));
				elf.setPositionName(rs.getString("positionName"));
				elf.setShiftNumber(rs.getInt("shiftNumber"));
				elf.setNumProducedToys(rs.getInt("numProducedToys"));
				
				elves.add(elf);
				
			}
			
			return elves;
			
		}
		
		catch (SQLException e) {
			return elves;
			
		}
		
	}

}
