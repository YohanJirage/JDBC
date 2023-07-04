package Day1Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateSal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl = "jdbc:mysql://localhost:3306/yohandb";
		Connection con = DriverManager.getConnection(jdbcurl,"root","Yohan@0007");
		
		PreparedStatement st = con.prepareStatement("update emp set sal = ? where empno = ?");
		st.setInt(1, 25000); // sal 
		st.setFloat(2,555);  // empno
		int n = st.executeUpdate();
		
		System.out.println(n);
		
		st.close();
		con.close();
		
	}

}
