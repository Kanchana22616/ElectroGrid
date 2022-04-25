package Sservices.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jersy.dbconnect.DbConnection;
public class AllViewServDao {

	public static String AllViewServDao() {

		String output = "";

		try {

			//database connection
		Connection con = DbConnection.connect();


		if (con == null) {
			return "Error while connecting to the database for reading.";

		}

		// Prepare the html table to be displayed
		output = "<table border='1'><tr>"
				+ "<th>package ID</th>"
				+ "<th>package Type</th>"
				+ "<th>package Unit Price</th>"
				+ "<th>Package Instruction</th>"
				+ "<th>services</th> "
				+ "<th>empId</th> </tr>";
			

		//Query statement for select all in table
		String query = "select * from servicemanagement";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String packageID = rs.getString(1);
			String packageType = rs.getString(2);
			String packageUprice = rs.getString(3);
			String Instruction = rs.getString(4);
			String services = rs.getString(5);
			String empId = rs.getString(6);
	

			// Add into the html table
			output += "<tr><td>" + packageID + "</td>";
			output += "<td>" + packageType + "</td>";
			output += "<td>" + packageUprice + "</td>";
			output += "<td>" + Instruction + "</td>";
			output += "<td>" + services + "</td>";
			output += "<td>" + empId + "</td>";
		

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
