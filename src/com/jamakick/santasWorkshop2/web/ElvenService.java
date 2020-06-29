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

import com.jamakick.santasWorkshop2.dao.ElvenWorkersDAO;
import com.jamakick.santasWorkshop2.db.ElvenWorkersImp;
import com.jamakick.santasWorkshop2.object.Elf;

@Path("/elvenservice")
public class ElvenService {
	
	ElvenWorkersDAO elvenImp = new ElvenWorkersImp();
	
	@GET
	@Path("/viewworkers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewWorkers() {
		return Response.ok((ArrayList<Elf>)elvenImp.viewElvenWorkers()).build();
	}
	
	@POST
	@Path("/addworker")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addWorker(Elf elf) {
		elvenImp.addElvenWorker(elf);
		return Response.status(201).build();
	}
	
	@DELETE
	@Path("/deleteworker/{id}")
	public Response deleteWorker(@PathParam("id") int id) {
		elvenImp.removeElvenWorker(id);
		return Response.status(201).build();
	}
	

	@PUT
	@Path("/workertoyadd/{id}")
	public Response incrementWorkerToy(@PathParam("id") int id) {
		elvenImp.updateElvenWorkerToys(id);
		return Response.status(201).build();
	}
	
}
