package Day1Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/yohandb";
			con = DriverManager.getConnection(url,"root","Yohan@0007");
			st = con.createStatement();
			
			 rs = st.executeQuery("select * from emp");
			while(rs.next())
			{
				System.out.print(rs.getString(1)+" : ");
				System.out.print(rs.getString(2)+" : ");
				System.out.print(rs.getString(6)+" : ");
				System.out.print(rs.getString(5));
				System.out.println();
			}
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				st.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				 
				e.printStackTrace();
			}
			
		}

	}

}
