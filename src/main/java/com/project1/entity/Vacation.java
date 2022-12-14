package com.project1.entity;



public class Vacation {
	private int id;
	private String hname;
	private String description;
	private String type;
	private String city;
	private String numberofdays;
	private String price;
	private String validTill;
	private String soldout;
	private String image;

	public Vacation() {
		super();
	}

	public Vacation(String hname, String description, String type, String city, String numberofdays, String price,
			String validTill, String soldout, String image) {
		super();
		this.hname = hname;
		this.description = description;
		this.type = type;
		this.city = city;
		this.numberofdays = numberofdays;
		this.price = price;
		this.validTill = validTill;
		this.soldout = soldout;
		this.image = image;
	}

	public Vacation(int id) {
		super();
		this.id = id;
	
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumberofdays() {
		return numberofdays;
	}

	public void setNumberofdays(String numberofdays) {
		this.numberofdays = numberofdays;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getSoldout() {
		return soldout;
	}

	public void setSoldout(String soldout) {
		this.soldout = soldout;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String file) {
		this.image = file;
	}

	@Override
	public String toString() {
		return "Vacation [id=" + id + ", hname=" + hname + ", description=" + description + ", type=" + type + ", city="
				+ city + ", numberofdays=" + numberofdays + ", price=" + price + ", validTill=" + validTill
				+ ", soldout=" + soldout + ", image=" + image + "]";
	}



	
}
