
package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jersy.bean.enquiryViewBean;
import com.jersy.dbconnect.dbConnection;

public class enquiryViewDao {

	public static String enquiryViewDao(enquiryViewBean rs) {
		
		String output = "";

		Connection con = dbConnection.connect();

		try {

			output = "<table border='1'><tr>"
					+ "<th>Enquiry ID</th>"
					+ "<th>E-mail</th>"
					+ "<th>User name</th>"
					+ "<th>User's Contact number</th>"
					+ "<th>Enquiry Type</th>"
					+ "<th>Enquiry Details</th>" + "</tr>";
			
			
			PreparedStatement ps1 = con.prepareStatement("select * from enquiry where enquiryID=?");
			ps1.setString(1, rs.getEnquiryID());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {


//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("enquiryID", rrs.getString(1));
//				jsonObject.put("email", rrs.getString(2));
//				jsonObject.put("name", rrs.getString(3));
//				jsonObject.put("contact", rrs.getString(4));
//				jsonObject.put("enquiryType", rrs.getString(5));
//				jsonObject.put("enquiryDetails", rrs.getString(5));
//				JSONArray jsonArray = new JSONArray();
//				jsonArray.add(jsonObject);
//				return "" + jsonArray;
				
				
				String enquiryID = rrs.getString(1);
				String email = rrs.getString(2);
				String name= rrs.getString(3);
				String contact = rrs.getString(4);
				String type = rrs.getString(5);
				String details = rrs.getString(6);
								
				
				output += "<tr><td>" + enquiryID + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + name + "</td>";
				output += "<td>" + contact + "</td>";
				output += "<td>" + type + "</td>";
				output += "<td>" + details + "</td>";

				output += "</table>";
				return "" + output;
			} else {

				return "failed";

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "fail1";

	}

}