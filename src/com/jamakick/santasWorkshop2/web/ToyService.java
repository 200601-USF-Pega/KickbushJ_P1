package com.jamakick.santasWorkshop2.web;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jamakick.santasWorkshop2.dao.CompositeDAO;
import com.jamakick.santasWorkshop2.dao.CurrentToysDAO;
import com.jamakick.santasWorkshop2.dao.ToyHistoryDAO;
import com.jamakick.santasWorkshop2.db.CompositeImp;
import com.jamakick.santasWorkshop2.db.CurrentToysImp;
import com.jamakick.santasWorkshop2.db.ToyHistoryImp;
import com.jamakick.santasWorkshop2.object.FullProductionObject;
import com.jamakick.santasWorkshop2.object.PastToy;

@Path("/toyservice")
public class ToyService {
	
	CompositeDAO compImp = new CompositeImp();
	CurrentToysDAO curToyImp = new CurrentToysImp();
	ToyHistoryDAO pastToyImp = new ToyHistoryImp();
	
	@GET
	@Path("/fullprod")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduction() {
		return Response.ok((ArrayList<FullProductionObject>)curToyImp.getFullToyProduction()).build();
	}
	
	@GET
	@Path("/fullhist")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFullHistory() {
		return Response.ok((ArrayList<PastToy>)pastToyImp.getFullToyHistory()).build();

	}
	//sendToyToHistory (toyID, newToyYear, newToyDelivered)
	//getspecificyeartoyhistory (int year)
	//getchildtoys(int childid)
	//viewtoysmadebyworker(int elvenid)
	//totaldeliveredtoys()
	//addcurrenttoy(toy toy)
	//removecurrenttoy(int toyid)
	//selectfromtoysbyid(int toyid)
	

}
