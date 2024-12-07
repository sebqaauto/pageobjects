package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper {
	
	List<String> userDetails = new ArrayList<>();
	
	// mysql library should be added to POM
	
	String sqlQuery1 = "SELECT * FROM STUDENTSINFO";
	
	public void fetchDBData1() throws SQLException, ClassNotFoundException {
		
		// 1) Class for instantiation of the Driver Object 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2) Establish the Connection to the Database 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/COLLEGE", "root", "password");
		
		// 3) Create a Statement to run the sql query 
		Statement statement = connection.createStatement();
		
		// 4) Execute the query and save its result in ResultSet object
		ResultSet result = statement.executeQuery(sqlQuery1);
		
		// 5) Retrieve the data from the ResultSet object 
		while(result.next()) {
			System.out.print(result.getInt(1)+ "  ");
			System.out.print(result.getString(2)+ "  ");
			System.out.print(result.getInt(3)+ "  ");
			System.out.print(result.getString(4)+ "  ");
			System.out.print(result.getInt(5)+ "  ");
			System.out.println();
		}
	}
	
	String sqlQuery2 = "SELECT email FROM INDIANTEAM";
	//SELECT email FROM INDIANTEAM where email ='PANT@bcci2411.com
	
	public List<String> fetchDBData2() throws SQLException, ClassNotFoundException {
		
		// 1) Class for instantiation of the Driver Object 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2) Establish the Connection to the Database 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/COLLEGE", "root", "password");
		
		// 3) Create a Statement to run the sql query 
		Statement statement = connection.createStatement();
		
		// 4) Execute the query and save its result in ResultSet object
		ResultSet result = statement.executeQuery(sqlQuery2);
		
		// 5) Retrieve the data from the ResultSet object 
		int counter = 0;
		while(result.next()) {
				userDetails.add(result.getString(1));
				userDetails.add(result.getString(2));
				userDetails.add(result.getString(3));
				userDetails.add(result.getString(4));
				userDetails.add(result.getString(5));
				System.out.print(result.getString(1)+ "  ");
				System.out.print(result.getString(2)+ "  ");
				System.out.print(result.getString(3)+ "  ");
				System.out.print(result.getString(4)+ "  ");
				System.out.print(result.getString(5)+ "  ");
				System.out.println();
		}
		return userDetails;
	}
	
	
public Object[] fetchDBData3() throws SQLException, ClassNotFoundException {
	Object[] userInfo = new Object[5];
		// 1) Class for instantiation of the Driver Object 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2) Establish the Connection to the Database 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/COLLEGE", "root", "password");
		
		// 3) Create a Statement to run the sql query 
		Statement statement = connection.createStatement();
		
		// 4) Execute the query and save its result in ResultSet object
		ResultSet result = statement.executeQuery(sqlQuery2);
		
		// 5) Retrieve the data from the ResultSet object 
		int counter = 0;
		while(result.next()) {
				userInfo[0]= result.getString(1);
				userInfo[1]= result.getString(2);
				userInfo[2]= result.getString(3);
				userInfo[3]= result.getString(4);
				userInfo[4]= result.getString(5);
				System.out.print(result.getString(1)+ "  ");
				System.out.print(result.getString(2)+ "  ");
				System.out.print(result.getString(3)+ "  ");
				System.out.print(result.getString(4)+ "  ");
				System.out.print(result.getString(5)+ "  ");
				System.out.println();
		}
		return userInfo;
	}
}
