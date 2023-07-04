package JDBCAssignement2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AcceptEmpnoShowDetails {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
		
		PreparedStatement ps = con.prepareStatement("select * from emp where empno = ?");
		System.out.println("ENTER EMPNO");
		ps.setInt(1, scan.nextInt());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			System.out.println(rs.getString(1)+" ");
			System.out.println(rs.getString(2)+" ");
			System.out.println(rs.getString(3)+" ");
			System.out.println(rs.getString(4)+" ");
			System.out.println(rs.getString(5)+" ");
			System.out.println(rs.getString(6)+" ");
			System.out.println(rs.getString(7)+" ");
			System.out.println(rs.getString(8)+" ");
		}
		else
		{
			System.out.println("EMPLOYEE NOT FOUND");
		}
		
	}

}
