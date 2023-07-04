package StoredProcedures;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment56 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yohandb","root","Yohan@0007");
		 
//		 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//		 CallableStatement cs = con.prepareCall("{call updateSal(?,?)}",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 
		 System.out.println("Connection Establish");
		 PreparedStatement st = con.prepareStatement("select * from emp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 
		 ResultSet rs = st.executeQuery();
		 
		 float sal = 0;
		 float usal = 0;
		 
		 while(rs.next())
		 {
			 sal = rs.getFloat(6);
			 
			 if(sal < 1000) 
			 {
				 
				 usal = (float)(sal+(sal*0.02));
				 
				 rs.updateFloat(6, usal);
				 
				 rs.updateRow();
			 }
			 else if(sal >= 1000 && sal < 5000)
			 {
				 usal = (float)(sal+(sal*0.05));
				 rs.updateFloat(6, usal);
				 rs.updateRow();
			 }
			 else if(sal >= 5000 && sal < 10000 )
			 {
				 usal = (float)(sal+(sal*0.08));
				 rs.updateFloat(6, usal);
				 rs.updateRow();
			 }
			 else
			 {
				 usal = (float)(sal+(sal*0.1));
				 rs.updateFloat(6, usal);
				 rs.updateRow();
			 }
		 }
	}

}

