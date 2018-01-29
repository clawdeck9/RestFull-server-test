package com.cluster9.rest.compte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/clients")
public class ClientsService {
	private static  Map<Integer, ClientAccount> comptes= new HashMap<>();
	
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
		//return new ClientAccount(code, "Alfred", "Maubeuge", 55);
		return comptes.get(code);
	}
	
	@GET
	@Path("/accounts/list")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClientAccount> getAccountList(){
		ArrayList<ClientAccount> list = new ArrayList<ClientAccount>(comptes.values());
		return list;
	}
	
	@POST
	@Path("/accounts/create")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientAccount save(ClientAccount ca){
		comptes.put(ca.getCode(), ca);
		return ca;
	}
	
	
	@PUT
	@Path("/accounts/create/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientAccount save(@PathParam(value="code") int code, ClientAccount ca){
		comptes.put(code, ca);
		return ca;
	}

	@DELETE
	@Path("/accounts/delete/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam(value="code") int code){
		comptes.remove(code);
		return true;
	}
	
	
}
