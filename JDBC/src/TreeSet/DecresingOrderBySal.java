package TreeSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import JDBCAssignement2_UsingCollection.Emp;


public class DecresingOrderBySal {
	public static void main(String[] args) {
		
		Set <Emp> emps = new TreeSet<>();
		Statement st = null;
		ResultSet rs= null;
	 
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
			
			st = con.createStatement();
			
			rs = st.executeQuery("select * from emp");
			
			while(rs.next())
			{
				Emp e = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(6),rs.getInt(8));
				emps.add(e);
			}
			
			for(Emp e : emps)
				System.out.println(e);
			
			

		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
