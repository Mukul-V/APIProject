package com.Testing.TestingUserDetailsAPI;

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
	
	@Path("/handler/{handle}/{id}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Cart getCartItem(@PathParam("handle") String handle, @PathParam("id") String id  ,User user) {
		  
		CartDao cartDao=new CartDao();
		Cart cart=null;
				
		try {
			cart = cartDao.getCartItem(user.username, id);
			
			if(handle.equals(Increment)) {	
				cart.increaseQuantity(user.username, id);
			}
			else if(handle.equals(Decrement)) {
				cart.decreaseQuantity(user.username, id);
			}
			else if(handle.equals(Delete)){
				cartDao.removeFromCart(user.username, id);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
}
