package com.jersy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jersy.dbconnect.dbConnection;

public class enquiryViewAllDao {
	
	public static String enquiryViewAllDao() {

		String output = "";

		try {

			//db connection
		Connection con = dbConnection.connect();


		if (con == null) {
			return "Error while connecting to the database for reading.";

		}

		// Prepare the html table to be displayed
		output = "<table border='1'><tr>"
				+ "<th>Enquiry ID</th>"
				+ "<th>E-mail</th>"
				+ "<th>User name</th>"
				+ "<th>User's Contact number</th>"
				+ "<th>Enquiry Type</th>"
				+ "<th>Enquiry Details</th> </tr>";

		//Quarry statement for select all in table
		String query = "select * from enquiry";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String enquiryID = rs.getString(1);
			String email = rs.getString(2);
			String name = rs.getString(3);
			String contact = rs.getString(4);
			String type = rs.getString(5);
			String details = rs.getString(6);

			// Add into the html table
			output += "<tr><td>" + enquiryID + "</td>";
			output += "<td>" + email + "</td>";
			output += "<td>" + name + "</td>";
			output += "<td>" + contact + "</td>";
			output += "<td>" + type + "</td>";
			output += "<td>" + details + "</td>";

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
