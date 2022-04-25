package Bill.dao;

import com.jersy.dbconnect.dbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class viewallBillDao {

	public static String viewallBillDao() {

		String output = "";

		try {

		Connection con = dbConnection.connect();


		if (con == null) {
			return "Error while connecting to the database for reading.";

		}

		// Prepare the html table to be displayed
		output = "<table border='1'><tr>"
				+ "<th>User ID</th>"
				+ "<th>Bill ID</th>"
				+ "<th>Date</th>"
				+ "<th>Arrears</th>"
				+ "<th>Amount</th>"
				+ "<th>Total Payble</th>"
				+ "<th>Emp Name</th>"
				+ " </tr>";

		String query = "select * from bill";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String userId = rs.getString(1);
			String billId = rs.getString(2);
			String date = rs.getString(3);
			Float arrears = rs.getFloat(4);
			Float amount = rs.getFloat(5);
			Float totalPayble = rs.getFloat(6);
			String empName = rs.getString(7);

			// Add into the html table
			output += "<tr><td>" + userId + "</td>";
			output += "<td>" + billId + "</td>";
			output += "<td>" + date + "</td>";
			output += "<td>" + arrears + "</td>";
			output += "<td>" + amount + "</td>";
			output += "<td>" + totalPayble + "</td>";
			output += "<td>" + empName + "</td>";
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
