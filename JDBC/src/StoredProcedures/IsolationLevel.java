package StoredProcedures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IsolationLevel {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
//		Class.forName("com.mysql.cj.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver() );  // both are for creating class object
		
		Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
		
		System.out.println("Connection Established "+con);

		System.out.println("Default Isolation level : "+con.getTransactionIsolation());
		
		con.setTransactionIsolation(8);
		
		System.out.println("Modified Isolation level : "+con.getTransactionIsolation());
		
	
	}

}
