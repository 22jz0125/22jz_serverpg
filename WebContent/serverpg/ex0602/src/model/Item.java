package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"imageUrl", "stock"})
public class Item implements Serializable {
	private String name;
	private int price;
	private String description;
	private String imageUrl;
	private int stock;
	
	public Item() {
		this.name = "革財布";
		this.price = 10000;
		this.description = "かわいくてかっこいい";
		this.imageUrl = "assets/img/saifu.png";
		this.stock = 9;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public int getStock() {
		return stock;
	}
	
	
	
}
