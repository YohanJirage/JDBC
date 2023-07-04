package Day1Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			// Step 1 : Loading Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2 : Establishing Connection with DB 
			String jdbcurl =  "jdbc:mysql://localhost:3306/yohandb";   // url create
			Connection con = DriverManager.getConnection(jdbcurl,"root","Yohan@0007");  // database username  & password
			
			// Step 3 : Creating the Statement 
			Statement stm = con.createStatement(); 
			
			// Step 4 : Executing the Statement
			ResultSet rs = stm.executeQuery("select * from emp");
			
			while(rs.next())
			{
				// if You are showing only data then 
				System.out.print("| "+rs.getString(1));	
				System.out.print("\t| "+rs.getString(2));
				System.out.print("\t| "+rs.getString(3));
				System.out.print("\t| "+rs.getString(4));
				System.out.print("\t| "+rs.getString(5));
				System.out.print("\t| "+rs.getString(6));
				System.out.print("\t| "+rs.getString(7)+" |");
				System.out.println();
				
			}
			
			rs.close();
			stm.close();
			con.close();
			
			
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Clas Not Found");
			e.printStackTrace();
			
		}
		catch(SQLException e)
		{
			System.out.println("DB Failed");
			e.printStackTrace();
		}
		finally {
	
			
		}
		
	}

	 
	

}
