package StoredProcedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;





public class ProcedureForSelectAll {

	public static void main(String[] args) throws ClassNotFoundException, SQLException , Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
		 
		 DatabaseMetaData dbmd = con.getMetaData();
		 
		 dbmd.getDriverMajorVersion();
		 System.out.println(dbmd.getDriverMajorVersion());
		 CallableStatement cs = con.prepareCall("{call getEmps()}");
		 
		 ResultSet rs =  cs.executeQuery();
		 
		 ResultSetMetaData rsmd = rs.getMetaData();
		 
		 while(rs.next())
		 {
			 for(int i = 1; i <= rsmd.getColumnCount() ; i++)
			 {
				 System.out.print((rs.getString(i)+" : "));
			 }
			 System.out.println();
		 }

	}

}
