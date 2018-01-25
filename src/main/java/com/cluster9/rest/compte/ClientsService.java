package com.cluster9.rest.compte;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/clients")
public class ClientsService {

	@GET
	@Path("/accounts/{num}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientAccount getAccount(@PathParam(value="num") int code){
		return new ClientAccount(code, "Dupont", "Lille", (int)(Math.random())*100);
	}
	
	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClientAccount> getAccountList(){
		ArrayList<ClientAccount> list = new ArrayList<ClientAccount>();
		for (int i=0; i<5; i++){
			list.add(new ClientAccount((int)(Math.random())*100, "Durant", "Paris", (int)(Math.random())*100));
		}
		return list;
	}
}
