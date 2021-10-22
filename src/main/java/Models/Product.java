package Models;

import java.sql.*;

import com.users.DBConnection;

public class Product{
	private String id;
	private String title;
	private String ImageUrl;
	private double price;
	private String description;
	//public int qty;
	
	public Product() {
		
	}
	public Product(String id,String title, String ImageUrl, double price, String description) {
		this.id=id;
		this.title=title;
		this.ImageUrl=ImageUrl;
		this.price=price;
		this.description=description;
//		this.qty=qty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}