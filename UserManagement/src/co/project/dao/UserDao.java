package co.project.dao;

import java.sql.*;
import java.util.*;

import co.project.model.User;
import co.project.util.ConnectionFactory;

public class UserDao
{
	private Connection connection=null;
	
	public UserDao() {
		connection = ConnectionFactory.getConnection();		
	}
	
	
	public void addUser(User user)
	{
		try {
			PreparedStatement pst=connection.prepareStatement("insert into users(firstname,lastname,dob,email) values(?,?,?,?)");
			
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setDate(3, new java.sql.Date(user.getDob().getTime()));
			pst.setString(4, user.getEmail());
			pst.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteUser(int userId)
	{
		try {
			PreparedStatement pst=connection.prepareStatement("delete from users where userid=?");
			
			pst.setInt(1, userId);
			pst.executeUpdate();			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void updateUser(User user)
	{
		try {
			PreparedStatement pst=connection.prepareStatement("update users set firstname=?, lastname=?,dob=?,email=? where userid=?");
			
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setDate(3, new java.sql.Date(user.getDob().getTime()));
			pst.setString(4, user.getEmail());
			pst.setInt(5, user.getUid());
			pst.executeUpdate();			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<User> getAllUsers() 
	{
		List<User> users=new ArrayList<User>();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from users");
			while(rs.next()) {
				User user=new User();
				user.setUid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				users.add(user);				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	public User getUserById(int userId)		//to get 1 user by the id
	{
		User user = new User();
		try {
			PreparedStatement pst = connection.prepareStatement("select * from users where userid=?");
			pst.setInt(1, userId);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				user.setUid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));				
			}			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}	
		
}
