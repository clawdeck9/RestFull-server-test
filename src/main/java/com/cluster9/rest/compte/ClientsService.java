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
	@Path("/conversion/{montant}")
	@Produces(MediaType.APPLICATION_JSON)
	public double convert(@PathParam(value="montant") double mt){
		return mt*13;
	}

	@GET
	@Path("/accounts/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientAccount getAccount(@PathParam(value="code") int code){
		return new ClientAccount(code, "Alfred", "Maubeuge", 55);
	}
	
	@GET
	@Path("/accounts/list")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClientAccount> getAccountList(){
		ArrayList<ClientAccount> list = new ArrayList<ClientAccount>();
		int n=0;
		for (int i=0; i<5; i++){
			n = (int)(Math.random()*100);
			System.out.println("age = " + n);
			list.add(new ClientAccount(13, "Cyril", "Bois-Blancs", n ));
		}
		return list;
	}
}
