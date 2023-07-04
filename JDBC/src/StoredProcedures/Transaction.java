package StoredProcedures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaction {

	public static void main(String[] args)  
	{
		Scanner scan = new Scanner(System.in);
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb", "root","Yohan@0007");
			
			con.setAutoCommit(false);
			System.out.println("ENTER UID");
			int uid = scan.nextInt();
			
			scan.nextLine();
			System.out.println("ENTER NAME");
			String name =scan.nextLine();
			
			System.out.println("ENTER CONTACT");
			String contact = scan.nextLine();
			
			System.out.println("ENTER EMAIL");
			String email = scan.nextLine();
			
			
			System.out.println("ENTER CITY");
			String city = scan.nextLine();
			
			System.out.println("ENTER SSC marck");
			float ssc = scan.nextFloat();
			System.out.println("ENTER HSC marck");
			float  hsc = scan.nextFloat();
			
			
			
			PreparedStatement ps1 = con.prepareStatement("insert into users1 values(?,?,?,?,?)");
			
			ps1.setInt(1, uid);
			
			ps1.setString(2, name);
			
			ps1.setString(3, contact);
			
			ps1.setString(4, email);
			
			ps1.setString(5, city);
			
			ps1.executeUpdate();
			
			PreparedStatement ps2 = con.prepareStatement("insert into education values(?,?,?)");
			
			ps2.setInt(1, uid);
			
			ps2.setFloat(2, ssc);
			
			ps2.setFloat(3, hsc);
			
			ps2.executeUpdate();
			
			con.commit();
			
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			
			try {
				System.out.println("Going To rollback");
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		try {
			System.out.println("Going To Commit");
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
