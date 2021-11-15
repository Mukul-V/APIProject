package com.UserDetails.ECommerceAPI;

import java.sql.SQLException;

import com.google.gson.Gson;
import com.users.UserDao;

import Models.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("users")
public class UsersEndpoint {

	@Path("/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User test(){
		return new User("Saurabh", "saurabh", "123456", "blue");
	}
	
	@Path("/login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public User login(SignIn data) throws ClassNotFoundException, SQLException{
		UserDao userDao=new UserDao();
		User user=userDao.signIn(data.username, data.password);
		return user;
	}
	
	@Path("/signUp")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Result signUp(User user) throws ClassNotFoundException, SQLException{
		UserDao userDao=new UserDao();
		Result result=new Result();
		result.setResult(userDao.signUp(user));
		return result;
	}
	
	
	

	
}
