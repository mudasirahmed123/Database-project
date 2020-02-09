

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

	Statement stmt=null;
	public Database() {
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
					//JOptionPane.showMessageDialog(null,"Driver Loaded Success");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			
				stmt=con.createStatement();

		} catch (Exception e) {
				
			System.out.println("Driver not Loaded Success");
				
				e.printStackTrace();
			}//connect with mysql server	
		}
}
