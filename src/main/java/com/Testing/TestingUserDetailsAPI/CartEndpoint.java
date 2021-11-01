package com.Testing.TestingUserDetailsAPI;

import java.sql.SQLException;
import java.util.ArrayList;

import com.users.CartDao;

import Models.Cart;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("cart")
public class CartEndpoint {

	@Path("/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "Working";
	}
	

	@Path("/addToCart/{username}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Result addToCart(@PathParam("username") String username, @PathParam("id") String id) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		boolean result=cartDao.addToCart(username, id);
		
		Result result_=new Result();
		result_.setResult(result);
		
		return result_;
	}
	

	@Path("/removeFromCart/{username}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Result removeFromCart(@PathParam("username") String username, @PathParam("id") String id) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		boolean result=cartDao.removeFromCart(username, id);
		
		Result result_=new Result();
		result_.setResult(result);
		
		return result_;
	}
	

	@Path("/isPresent/{username}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Result isPresentInCart(@PathParam("username") String username, @PathParam("id") String id) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		boolean result=cartDao.isPresentInCart(username, id);
		Result result_=new Result();
		result_.setResult(result);
		
		return result_;
	}
	


	

	@Path("/itemsCount/{username}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static int itemsCount(@PathParam("username") String username) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		int result=cartDao.itemsCount(username);
		
		return result;
	}
	
	
	@Path("/getCart/{username}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<Cart> getCart(@PathParam("username") String username) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		ArrayList<Cart> cart=cartDao.getCart(username);
		
		return cart;
	}
	
	@Path("/getCart/{username}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Cart getCart(@PathParam("username") String username, @PathParam("id") String id) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		Cart cart=cartDao.getCartItem(username, id);
		
		return cart;
	}

	
	@Path("/itemCount/{username}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static int itemCount(@PathParam("username") String username, @PathParam("id") String id) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		int result=cartDao.itemCount(username, id);
		
		return result;
	}

	
	@Path("/increaseQuantity/{username}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Result increaseQuantity(@PathParam("username") String username, @PathParam("id") String id) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		Result result=new Result();
		result.setResult(cartDao.increaseQuantity(username, id));
		
		return result;
	}
	
	@Path("/decreaseQuantity/{username}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Result decreaseQuantity(@PathParam("username") String username, @PathParam("id") String id) throws ClassNotFoundException, SQLException {
		CartDao cartDao=new CartDao();
		Result result=new Result();
		result.setResult(cartDao.decreaseQuantity(username, id));
		
		return result;
	}
}
