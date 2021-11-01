package com.Testing.TestingUserDetailsAPI;

import java.sql.SQLException;
import java.util.*;

import com.users.CartDao;

import Models.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("plp")
public class PLPEndpoint {

	@Path("/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Product testApi() {
		Product p=new Product();
		p.setId("101");
		p.setTitle("Apple");
		p.setImageUrl("Image");
		p.setPrice(2000);
		p.setDescription("Description");
		
		return p;
	}
	
	@Path("/product/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
		ProductsDao productsDao=new ProductsDao();
		Product product=productsDao.getProduct(id);
		return product;
	}
	
	@Path("/getAllIds")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> getAllIds() throws ClassNotFoundException, SQLException {
		ProductsDao productsDao=new ProductsDao();
		ArrayList<String> ids=new ArrayList<>();
		ids=productsDao.getAllIds();
		return ids;
	}
	
	@Path("/getAsList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Product> getAsList() throws ClassNotFoundException, SQLException {
		ProductsDao productsDao=new ProductsDao();
		ArrayList<Product> products=new ArrayList<>();
		products=productsDao.getAsList();
		return products;
	}
	
	@Path("/getAsMap")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Product> getAsMap() throws ClassNotFoundException, SQLException {
		ProductsDao productsDao=new ProductsDao();
		HashMap<String, Product> map=new HashMap<>();
		
		map=productsDao.getAsMap();
		return map;
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

	
}
