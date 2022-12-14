package com.project1.entity;

public class Cart {
	private int cid;
	private int uid;
	private int vid;
	private String hname;
	private String description;
	private String type;
	private String city;
	private String price;
	private int totalPrice;

	public Cart() {
		super();
	}

	public Cart(int cid, int uid, int vid, String hname, String description, String type, String city, String price,
			int totalPrice) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.vid = vid;
		this.hname = hname;
		this.description = description;
		this.type = type;
		this.city = city;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", uid=" + uid + ", vid=" + vid + ", hname=" + hname + ", description="
				+ description + ", type=" + type + ", city=" + city + ", price=" + price + ", totalPrice=" + totalPrice
				+ "]";
	}

}
