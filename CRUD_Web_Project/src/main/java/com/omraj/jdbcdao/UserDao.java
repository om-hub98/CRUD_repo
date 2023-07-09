	package com.omraj.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.omraj.model.User;

public class UserDao {
		private Connection conn;
		public UserDao(Connection conn) {
			this.conn = conn;
		}

		public boolean insertData(User user) throws SQLException {
			boolean check = false;
			try {
				Statement st=conn.createStatement();
				st.execute("alter table signup auto_increment = 1");
				
				String query = "insert into signup(firstname,lastname,username,password) values (?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(query);
				
				//System.out.println("DB = "+user.getFirstname());
				stmt.setString(1, user.getFirstname());
				stmt.setString(2, user.getLastname());
				stmt.setString(3, user.getUserName());
				stmt.setString(4, user.getPassword());
				
				int value = stmt.executeUpdate();
				if (value > 0) {
					check = true;
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return check;

		}
		public List<User> fetchAllData() {
			List<User> list=new ArrayList<>();
			
			try {
				String query="select * from signup";
				PreparedStatement ps=conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					User user=new User();
					user.setId(rs.getInt("id"));
				    user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setUserName(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					list.add(user);
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public User fetchUserById(int id) {
			User user=new User();
			
			try {
				String query="select * from signup where id=?";
				PreparedStatement stmt=conn.prepareStatement(query);
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
					user.setId(rs.getInt("id"));
				    user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setUserName(rs.getString("username"));
					user.setPassword(rs.getString("password"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return user;
			
		}
		
		public boolean updateData(User user)  {
			boolean check=false;
			try {
				String query="update signup set firstname=?,lastname=?,username=?,password=? where id=?";
				PreparedStatement stmt=conn.prepareStatement(query);
				
				
				stmt.setString(1,user.getFirstname());
				stmt.setString(2,user.getLastname());
				stmt.setString(3,user.getUserName());
				stmt.setString(4,user.getPassword());
				stmt.setInt(5,user.getId());
				
				int value=stmt.executeUpdate();
				
				if(value >0) {
					check=true;
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
			return check;
			
		}
		
		public boolean deleteUser(int id) {
			boolean check=false;
			try {
				String query="delete from signup where id=?";
				PreparedStatement stmt=conn.prepareStatement(query);
				stmt.setInt(1,id);
				
				int value=stmt.executeUpdate();
				if(value==1) {
					check=true;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return check;
		}
		
		public boolean fetchLoginData(User user){
			boolean check=false;
			try {
				String query="select username,password from signup where username=? and password=?";
				PreparedStatement st=conn.prepareStatement(query);
				st.setString(1,user.getUserName());
				st.setString(2, user.getPassword());
				
				ResultSet rs=st.executeQuery();
				check=rs.next();		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return check;
			
		}
}
