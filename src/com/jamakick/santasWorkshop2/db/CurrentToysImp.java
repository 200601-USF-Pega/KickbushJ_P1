package com.jamakick.santasWorkshop2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jamakick.santasWorkshop2.dao.CurrentToysDAO;
import com.jamakick.santasWorkshop2.object.FullProductionObject;
import com.jamakick.santasWorkshop2.object.Toy;

public class CurrentToysImp  implements CurrentToysDAO {

	@Override
	public ArrayList<FullProductionObject> getFullToyProduction(Connection connection) {
		
		ArrayList<FullProductionObject> fullProd = new ArrayList<FullProductionObject>();
		
		try {
			Statement s = connection.createStatement();
			s.executeQuery("SELECT * FROM FullProduction ORDER BY toyID ASC;");
			
			ResultSet rs = s.getResultSet();
			
			while (rs.next()) {
				
				FullProductionObject obj = new FullProductionObject();
				obj.setToyID(rs.getInt("toyID"));
				obj.setToyName(rs.getString("toyName"));
				obj.setToyColor(rs.getString("toyColor"));
				obj.setWorkTime(rs.getFloat("workTime"));
				obj.setChildName(rs.getString("childName"));
				obj.setNaughty(rs.getBoolean("naughty"));
				obj.setElvenName(rs.getString("elvenName"));
				obj.setPositionName(rs.getString("positionName"));
				obj.setShiftNumber(rs.getInt("shiftNumber"));
				obj.setNumProducedToys(rs.getInt("numProducedToys"));
				
				fullProd.add(obj);
				
				
			}
			
			return fullProd;
			
		}
		
		catch (SQLException e) {
			return fullProd;
			
		}
		
		
	}

	@Override
	public boolean addCurrentToy(Connection connection, Toy toy) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call addToy(?, ?, ?, ?, ?);");
			
			pst.setString(1, toy.getToyName());
			pst.setString(2, toy.getToyColor());
			pst.setFloat(3, toy.getWorkTime());
			pst.setInt(4, toy.getChildID());
			pst.setInt(5, toy.getElvenID());
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			return false;
		}
		
	}

	@Override
	public boolean removeCurrentToy(Connection connection, int toyID) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("Call removeToy(?);");
			
			pst.setInt(1, toyID);
			
			pst.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			return false;
		}

		
	}

	@Override
	public Toy selectFromToysByID(Connection connection, int toyID) {
		
		Toy toy = new Toy();

		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM CurrentToys "
					+ "WHERE toyID = ? ORDER BY toyID ASC");
			pst.setInt(1, toyID);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();			
			
			while (rs.next()) {
				
				
				toy.setToyID(rs.getInt("toyID"));
				toy.setToyName(rs.getString("toyName"));
				toy.setToyColor(rs.getString("toyColor"));
				toy.setWorkTime(rs.getFloat("workTime"));
				toy.setChildID(rs.getInt("childID"));
				toy.setElvenID(rs.getInt("elvenID"));

			}
		
		return toy;
		}
		
		catch (SQLException e) {
			return toy;
		}

	}
}