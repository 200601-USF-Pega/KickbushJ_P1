package com.jamakick.santasWorkshop2.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import com.jamakick.santasWorkshop2.object.Toy;

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
	
	@PUT
	@Path("/sendtoy/{id},{year},{deliv}")
	public Response sendToyToHistory(@PathParam("id") int id,
			@PathParam("year") int year,
			@PathParam("deliv") boolean delivered) {
		
		compImp.sendToyToHistory(id, year, delivered);
		return Response.status(200).build();
	}
	
	@GET
	@Path("/yearhist/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getYearHistory(@PathParam("year") int year) {
		return Response.ok((ArrayList<PastToy>)pastToyImp.getSpecificYearToyHistory(year)).build();

	}
	
	@GET
	@Path("/childtoy/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getChildToy(@PathParam("id") int id) {
		return Response.ok((ArrayList<PastToy>)pastToyImp.getChildToys(id)).build();

	}
	
	@GET
	@Path("/workertoy/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkerToy(@PathParam("id") int id) {
		return Response.ok((ArrayList<PastToy>)pastToyImp.viewToysMadeByWorker(id)).build();

	}
	
	@GET
	@Path("/totaldeliv")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalDeliv() {
		return Response.ok(pastToyImp.totalDeliveredToys()).build();
	}
	
	@POST
	@Path("/addtoy")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addToy(Toy toy) {
		curToyImp.addCurrentToy(toy);
		return Response.status(201).build();
	}

	@DELETE
	@Path("/deletetoy/{id}")
	public Response deleteToy(@PathParam("id") int id) {
		curToyImp.removeCurrentToy(id);
		return Response.status(201).build();
	}
	
	@GET
	@Path("/gettoy/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getToy(@PathParam("id") int id) {
		return Response.ok(curToyImp.selectFromToysByID(id)).build();
	}
	

}
