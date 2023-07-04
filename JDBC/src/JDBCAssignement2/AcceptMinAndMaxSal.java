package JDBCAssignement2;



 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AcceptMinAndMaxSal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
		
		PreparedStatement ps = con.prepareStatement("select * from emp where sal between ? and ?");
		System.out.println("ENTER MIN SAL");
		ps.setInt(1, scan.nextInt());
		
		System.out.println("ENTER MAX SAL");
		ps.setInt(2, scan.nextInt());
		

		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.print(rs.getString(1)+" ");
			System.out.print(rs.getString(2)+" ");
			System.out.print(rs.getString(3)+" ");
			System.out.print(rs.getString(4)+" ");
			System.out.print(rs.getString(5)+" ");
			System.out.print(rs.getString(6)+" ");
			System.out.print(rs.getString(7)+" ");
			System.out.print(rs.getString(8)+" ");
			System.out.println();
		}
		
		rs.close();
		ps.close();
		con.close();
		
	}

}
