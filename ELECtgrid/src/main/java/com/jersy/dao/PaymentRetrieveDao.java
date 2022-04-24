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


		Connection con = DbConnection.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select * from payment where email=? ");
			ps1.setString(1, pr.getEmail());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("accountType", rrs.getString(4));
				jsonObject.put("cardNumber", rrs.getString(5));
				jsonObject.put("expMonth", rrs.getString(6));
				jsonObject.put("expYear", rrs.getString(7));
				jsonObject.put("cvv", rrs.getInt(8));
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(jsonObject);

				
				return "" + jsonArray;

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
