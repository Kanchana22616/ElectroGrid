package Employee.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jersy.dbconnect.dbConnection;
public class ViewAllEmployee {
	
	public static String ViewAllEmployee() {

		String output = "";

		try {

		Connection con = dbConnection.connect();


		if (con == null) {
			return "Error while connecting to the database for reading.";

		}

		// Prepare the html table to be displayed here 
		output = "<table border='1'><tr>"
				+ "<th>EmpID</th>"
				+ "<th> EmpName</th>"
				+ "<th>EmpAge</th>"
				+ "<th>EmpDept</th>"
				+ "<th>EmpDOB</th>"
				+ "<th>EmpEmail</th>"
				+ "<th>ContactNUm</th> </tr>";

		String query = "select * from employee"; // using sql quary data retrival 
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			int empID = rs.getInt(1);      //set up data as become table 
			String empName = rs.getString(2);
			int empAge = rs.getInt(3);
			String empDept = rs.getString(4);
			String empDOB = rs.getString(5);
			String empEmail = rs.getString(6);
			String contractNum = rs.getString(7);

			// Add into the html table
			output += "<tr><td>" + empID + "</td>";
			output += "<td>" + empName + "</td>";
			output += "<td>" + empAge + "</td>";
			output += "<td>" + empDept + "</td>";
			output += "<td>" + empDOB + "</td>";
			output += "<td>" + empEmail + "</td>";
			output += "<td>" + contractNum + "</td>";		;

	}
		con.close();

		// Complete the html table
		output += "</table>";

	} catch (Exception e) {
		output = "Error while reading the items.";
		System.err.println(e.getMessage());
	}
	return output;

}
	
	
	
	
	
	

}

