package StoredProcedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateSal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
		 
		 DatabaseMetaData dbmd = con.getMetaData();
		 
		 dbmd.getDriverMajorVersion();
		 
		 CallableStatement cs = con.prepareCall("{call updateSal(?,?)}");
		 
		 System.out.println("Enter the Employee Id");
		 cs.setInt(1,scan.nextInt());
		 System.out.println("Enter Percentage");
		 cs.setInt(2,scan.nextInt());
		 int n=  cs.executeUpdate();
		 
		 if(n>0)
			 System.out.println("Update Successfully");
		 else
			 System.out.println("EMPLOYEE NOT FOUND");
		 


	}

}
