package com.jersy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dbconnect.DbConnection;

public class PaymentViewAllDao {
	
	public static String payentViewAll() {

		String output = "";

		try {

			//db connection
		Connection con = DbConnection.connect();


		if (con == null) {
			return "Error while connecting to the database for reading.";

		}

		// Prepare the html table to be displayed
		output = "<table border='1'><tr>"
				+ "<th>Account Number</th>"
				+ "<th>Amount</th>"
				+ "<th>Email</th>"
				+ "<th>Card Type</th>"
				+ "<th>Card Number</th>"
				+ "<th>Exp Month</th>"
				+ " <th>Exp Year</th>"
				+ "<th>CVV</th></tr>";

		//Quarry statement for select all in table
		String query = "select * from payment";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String accountNumber = rs.getString(1);
			float amount = rs.getFloat(2);
			String email = rs.getString(3);
			String accountType = rs.getString(4);
			String cardNumber = rs.getString(5);
			String expMonth = rs.getString(6);
			String expYear = rs.getString(7);
			String cvv = rs.getString(8);
			

			// Add into the html table
			output += "<tr><td>" + accountNumber + "</td>";
			output += "<td>" + amount + "</td>";
			output += "<td>" + email + "</td>";
			output += "<td>" + accountType + "</td>";
			output += "<td>" + cardNumber + "</td>";
			output += "<td>" + expMonth + "</td>";
			output += "<td>" + expYear + "</td>";
			output += "<td>" + cvv + "</td>";

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
