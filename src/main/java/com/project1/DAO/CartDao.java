package com.project1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project1.entity.Cart;


public class CartDao {

	private Connection con;

	public CartDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addCart(Cart c) {
		boolean f = false;

		try {
			String sql = "insert into cart(uid,vid,hname,description,type,city,price,totalPrice) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, c.getUid());
			ps.setInt(2, c.getVid());
			ps.setString(3, c.getHname());
			ps.setString(4, c.getDescription());
			ps.setString(5, c.getType());
			ps.setString(6, c.getCity());
			ps.setString(7, c.getPrice());
			ps.setInt(8, c.getTotalPrice());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public List<Cart>  getVacationByUser(int userId) {
		List<Cart> list=  new ArrayList<Cart>();
		Cart c = null;
		int totalPrice = 0;
		
		
		try { 
			
			String sql = "select * from cart where uid=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs  = ps.executeQuery();
			while (rs.next()) {
				c = new Cart();
				c.setCid(rs.getInt("cid"));				
				c.setHname(rs.getString("hname"));
				c.setDescription(rs.getString("description"));
				c.setCity(rs.getString("city"));;
				c.setType(rs.getString("type"));
				c.setPrice(rs.getString("price"));
				
				totalPrice = totalPrice+rs.getInt("totalPrice");
				c.setTotalPrice(totalPrice);
				
				
				
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}
