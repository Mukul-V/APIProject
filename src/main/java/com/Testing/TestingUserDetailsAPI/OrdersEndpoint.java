package com.Testing.TestingUserDetailsAPI;

import java.util.ArrayList;

import com.users.OrdersDao;

import Models.Order;
import Models.OrderTotal;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("orders")
public class OrdersEndpoint {

	@Path("/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "Working";
	}
	
	@Path("/getAllOrders/{username}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Order> getAllOrders(@PathParam("username") String username) throws ClassNotFoundException{
		OrdersDao ordersDao=new OrdersDao();
		ArrayList<Order> orderList=ordersDao.getAllOrders(username);
		return orderList;
	}

	@Path("/getOrders/{username}/{orderId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Order> getAllOrders(@PathParam("username") String username, @PathParam("orderId") String orderId) throws ClassNotFoundException{
		OrdersDao ordersDao=new OrdersDao();
		ArrayList<Order> orderList=ordersDao.getOrders(username, orderId);
		return orderList;
	}
	
	@Path("/getOrderIds/{username}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> getOrderIds(@PathParam("username") String username) throws ClassNotFoundException{
		OrdersDao ordersDao=new OrdersDao();
		ArrayList<String> orderIdList=ordersDao.getOrderIds(username);
		return orderIdList;
	}
	
	@Path("/orderTotal/{username}/{orderId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public OrderTotal getOrderTotal(@PathParam("username") String username, @PathParam("orderId") String orderId) throws ClassNotFoundException{
		OrdersDao ordersDao=new OrdersDao();
		OrderTotal orderTotal=ordersDao.getOrderTotal(username, orderId);
		return orderTotal;
	}
	
	@Path("/addOrder/{username}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Result addOrder(Order order, @PathParam("username") String username) throws ClassNotFoundException{
		Result result=new Result();
		OrdersDao ordersDao=new OrdersDao();
		result.setResult(ordersDao.addOrder(username, order));
		return result;
	}
	
	@Path("/addOrderTotal/{username}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Result addOrderTotal(OrderTotal orderTotal, @PathParam("username") String username) throws ClassNotFoundException{
		Result result=new Result();
		OrdersDao ordersDao=new OrdersDao();
		result.setResult(ordersDao.addOrderTotal(username, orderTotal));
		return result;
	}
}
