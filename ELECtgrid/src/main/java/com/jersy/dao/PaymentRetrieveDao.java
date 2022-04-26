package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dbconnect.DbConnection;
import com.jersy.bean.PaymentRetrieveBean;



public class PaymentRetrieveDao {
	
	public static String showDetails(PaymentRetrieveBean pr) {

		String output = "";
		Connection con = DbConnection.connect();

		try {
			output = 
					"<table border='1'><tr><th>Card Payment Details</th></tr>"
					+ "<tr>"
					+ "<th>Card Type</th>"
					+ "<th>Card Number</th>"
					+ "<th>Exp Month</th>"
					+ "<th>Exp Year</th>"
					+ "<th>CVV</th>"
				    + "</tr>";
			
			PreparedStatement ps1 = con.prepareStatement("select * from payment where accountNumber=? ");
			ps1.setString(1, pr.getAccountNumber());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				
				
				String cardType = rrs.getString(4);
				String cardNumber = rrs.getString(5);
				String expMonth= rrs.getString(6);
				String expYear = rrs.getString(7);
				int cvv = rrs.getInt(8);
				


				output += "<tr><td>" + cardType + "</td>";
				output += "<td>" + cardNumber + "</td>";
				output += "<td>" + expMonth + "</td>";
				output += "<td>" + expYear + "</td>";
				output += "<td>" + cvv + "</td>";
				



				output += "</table>";
				return "" + output;


		
//				
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("accountType", rrs.getString(4));
//				jsonObject.put("cardNumber", rrs.getString(5));
//				jsonObject.put("expMonth", rrs.getString(6));
//				jsonObject.put("expYear", rrs.getString(7));
//				jsonObject.put("cvv", rrs.getInt(8));
//				JSONArray jsonArray = new JSONArray();
//				jsonArray.add(jsonObject);
//
//				
//				return "" + jsonArray;

			} else {

				return "failed";

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "fail";

	}

}
