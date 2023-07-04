package JDBCAssignement2_UsingCollection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class DecresingOrderOfSalUsingLambda {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Set<Emp> sal = new TreeSet<>(new Comparator<Emp>() { @Override
		public int compare(Emp o1, Emp o2) {
			if(o1.getSal() > o2.getSal())
				return -1;
			else if(o1.getSal() < o2.getSal())
				return 1;
			else 
			return o1.getEmpno() - o2.getEmpno();
		}
		});
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
		 
		 
		 Statement st = con.createStatement();
		 
		 ResultSet rs = st.executeQuery("select * from emp");
		 
		 while(rs.next())
		 {
			 Emp e = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(6), rs.getInt(8));
			 sal.add(e);	
		 }
		 
		 for(Emp e : sal)
				System.out.println(e);
		 
		 
		 rs.close();
			st.close();
			con.close();

	}

}
