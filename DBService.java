package com.bds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pojo.Employe;

public class DBService {

	Connection con=null;
	public DBService() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
			+ "10mar25ad?user=root&password=root");
		}
		catch (Exception e) 
		{
			System.out.println("Error in loading driver and making connection");
		}
	}
	public boolean addEmploye(Employe pd)
	{
		try 
		{
			PreparedStatement ps = 
					con.prepareStatement("insert into Employe values(?,?,?)");
			ps.setInt(1, pd.getId());
			ps.setString(2, pd.getName());
			ps.setDouble(3, pd.getAge());
			int x = ps.executeUpdate();
			if(x>0)
				return true;
			else
				return false;
		}
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement");
			return false;
		}
	}
	public boolean updateEmploye(Employe pd)
	{
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("update Employe set pname = ?,price = ?"
					+ " where pid = ?");
			ps.setString(1, pd.getName());
			ps.setDouble(2, pd.getAge());
			ps.setInt(3, pd.getId());
			int x = ps.executeUpdate();
			if(x>0)
				return true;
			else
				return false;
		}
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement");
			return false;
		}
	}
	public boolean deleteEmploye(Employe pd)
	{
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("delete from Employe where pid = ?");
			ps.setInt(1, pd.getId());
			int x = ps.executeUpdate();
			if(x>0)
				return true;
			else
				return false;
		}
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement");
			return false;
		}
	}
	public Employe getEmploye(Employe pd)
	{
		Employe emp = new Employe();
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("select * from Employe where pid = ?");
			ps.setInt(1, emp.getId());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()==true)
			{
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
			}
			else
				return null;
		}
		catch (SQLException e1) 
		{
			System.out.println("Error in sql statement");
		}
		return emp;
	}
	public ArrayList<Employe> getAllEmploye()
	{
		ArrayList<Employe>lst = new ArrayList<>();
		try 
		{
			PreparedStatement ps = 
			con.prepareStatement("select * from Employe");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Employe e = new Employe();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setAge(rs.getInt("age"));
				lst.add(e);
			}
			
		}
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement");
		}
		return lst;
	}
	
	}

