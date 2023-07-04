package TreeSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

public class AverageSalDept {

	public static void main(String[] args) {
		
		Set<Department> dept = new TreeSet<>(); 
		 
		Statement st = null;
		ResultSet rs= null;
	 
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
			
			st = con.createStatement();
			
		
			
			 String query = "SELECT d.deptno, d.dname, AVG(e.sal) average_salary"
			 		+ " FROM emp e JOIN dept d ON e.deptno = d.deptno "
			 		+ " GROUP BY d.deptno ";
			 		
			
			rs = st.executeQuery(query);
			
			while(rs.next())
			{
				Department d = new Department(rs.getInt(1), rs.getString(2), rs.getFloat(3));
//				System.out.print(rs.getString(1)+"  ");
//				System.out.print(rs.getString(2)+"  ");
//				System.out.print(rs.getString(3)+"  ");
//				System.out.println();
				dept.add(d);
				
			}
			
			for(Department d : dept)
			{
				System.out.println(d);
			}

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
