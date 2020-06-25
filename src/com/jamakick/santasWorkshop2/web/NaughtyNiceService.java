package com.jamakick.santasWorkshop2.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jamakick.santasWorkshop2.dao.NaughtyNiceDAO;
import com.jamakick.santasWorkshop2.db.NaughtyNiceImp;
import com.jamakick.santasWorkshop2.object.Child;

@Path("/nnservice")
public class NaughtyNiceService {
	
	NaughtyNiceDAO naughtyImp = new NaughtyNiceImp();
	
	@GET
	@Path("/allchildren")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllChildren() {
		return Response.ok((ArrayList<Child>)naughtyImp.getFullNaughtyNiceList()).build();
	}
	
	@POST
	@Path("/addchild")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addChild(Child child) {
		naughtyImp.addChildToList(child);
		return Response.status(201).build();
	}
	
	@PUT
	@Path("/updatenaughty")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateNaughty(Child child) {
		naughtyImp.changeChildNaughtyStatus(child.getChildID(), child.getNaughty());
		return Response.status(200).build();
	}

}
