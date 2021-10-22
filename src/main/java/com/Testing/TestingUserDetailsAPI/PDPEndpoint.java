package com.Testing.TestingUserDetailsAPI;

import java.sql.SQLException;

import com.users.CartDao;

import Models.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("pdp")
public class PDPEndpoint implements Helper{
	
	@Path("/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "Working";
	}
	
	@Path("/product/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
		ProductsDao productsDao=new ProductsDao();
		Product product=productsDao.getProduct(id);
		return product;
	}
	
	@Path("/itemCount/{username}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static int itemCount(@PathParam("username") String username, @PathParam("id") String id) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		int result=cartDao.itemCount(username, id);
		
		return result;
	}

	
	@Path("/changeQuantity/{username}/{id}/{quantity}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Result changeQuantity(@PathParam("username") String username, @PathParam("id") String id, @PathParam("quantity") int quantity) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		Result result=new Result();
		result.setResult(cartDao.changeQuantity(username, id, quantity));
		
		return result;
	}
	
	
	
}
