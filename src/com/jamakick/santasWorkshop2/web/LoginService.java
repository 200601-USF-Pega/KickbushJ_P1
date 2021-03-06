package com.jamakick.santasWorkshop2.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jamakick.santasWorkshop2.dao.LoginDAO;
import com.jamakick.santasWorkshop2.db.LoginImp;
import com.jamakick.santasWorkshop2.object.LoginInfo;
import com.jamakick.santasWorkshop2.object.LoginReturn;

@Path("/loginservice")
public class LoginService {
	
	LoginDAO loginImp = new LoginImp();
	
	private static final Logger logger = LogManager.getLogger(LoginService.class);
	
	@POST
	@Path("login/{id},{pass}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("id") int id, @PathParam("pass") String pass) {
		LoginInfo info = loginImp.getLoginInfo(id);
		
		LoginReturn output = new LoginReturn();
		
		if (info.getPass().equals(pass)) {
			output.setCorrectLoginInfo(true);
			logger.debug("Login Succeed");
		}
		
		else {
			output.setCorrectLoginInfo(false);
			logger.debug("Login Fail");
		}
	
		
		return Response.ok(output).build();
		
	}
	

}
