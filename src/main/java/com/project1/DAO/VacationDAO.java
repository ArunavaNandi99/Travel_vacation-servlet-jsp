package com.project1.DAO;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.project1.entity.Cart;
import com.project1.entity.Vacation;

public class VacationDAO {
	private Connection con;

	FileInputStream fileInputStream = null;

	public VacationDAO(Connection con) {
		this.con = con;
	}

	public boolean addVacation(Vacation vacation) {

		boolean f = false;

		try {
			String sql = "insert into vacation(hname,description,type,city,numberofdays,price,validtill,soldout,image) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, vacation.getHname());
			ps.setString(2, vacation.getDescription());
			ps.setString(3, vacation.getType());
			ps.setString(4, vacation.getCity());
			ps.setString(5, vacation.getNumberofdays());
			ps.setString(6, vacation.getPrice());
			ps.setString(7, vacation.getValidTill());
			ps.setString(8, vacation.getSoldout());
			ps.setString(9, vacation.getImage());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Vacation> searchLocation(Vacation vacation) {

		List<Vacation> vacationList = new ArrayList<Vacation>();

		Vacation va = null;

		try {
			String sql = "select * from vacation where city = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, vacation.getCity());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				va = new Vacation();

				va.setId(rs.getInt("id"));
				va.setHname(rs.getString("hname"));
				va.setDescription(rs.getString("description"));
				va.setType(rs.getString("type"));
				va.setCity(rs.getString("city"));
				va.setNumberofdays(rs.getString("numberofdays"));
				va.setPrice(rs.getString("price"));
				va.setValidTill(rs.getString("validTill"));
				va.setSoldout(rs.getString("soldout"));
				va.setImage(rs.getString("image"));

				vacationList.add(va);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return vacationList;

	}

	public Vacation searchVacation(Vacation vacation) {
		
		try {
			String sql = "select * from vacation where id =?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, vacation.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				vacation.setId(rs.getInt("id"));
				vacation.setHname(rs.getString("hname"));
				vacation.setDescription(rs.getString("description"));
				vacation.setType(rs.getString("type"));
				vacation.setCity(rs.getString("city"));
				vacation.setPrice(rs.getString("price"));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacation;
	}

	public List<Vacation> allVacation() throws Exception {
		List<Vacation> vacations = new ArrayList<>();

		try {
			String sql = " select * from vacation ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Vacation vacation = new Vacation();
				vacation.setId(rs.getInt("id"));
				vacation.setCity(rs.getString("city"));
				vacation.setImage(rs.getString("image"));

				vacations.add(vacation);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return vacations;

	}
	
	public int getTotalCartPrice(ArrayList<Cart> shoppingCart) {
		
		int sum = 0;
		try {
			if(shoppingCart.size()>0) {
				for (Cart item : shoppingCart) {
					String sql = "select price from vacation where id =?";
					PreparedStatement pst  = this.con.prepareStatement(sql);
					pst.setInt(1, item.getVid());
					ResultSet rs  = pst.executeQuery();
					
					while (rs.next()) {
						sum+=rs.getInt("price");
					}
					
				}
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sum;
		
	}

	

}
