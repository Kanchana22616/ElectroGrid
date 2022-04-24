package Sservices.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import com.jersy.dbconnect.DbConnection;

import Sservices.Bean.ViewServices;


public class ViewServicesDao {

	public static String viewdao(ViewServices rs) {


		Connection con = DbConnection.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select * from servicemanagement where packageID=?");
			ps1.setInt(1, rs.getPackageID());
		
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("packageID", rrs.getInt(1));
				jsonObject.put("packageType", rrs.getString(2));
				jsonObject.put("packageUnitPrice", rrs.getFloat(3));
				jsonObject.put("PackageInstruction", rrs.getString(4));
				jsonObject.put("services", rrs.getString(5));
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(jsonObject);
				return "" + jsonArray;
//				PreparedStatement ps2 = con.prepareStatement("update servicemanagement set status = ? where package ID = ?");
//				ps2.setString(1, "online");
//				ps2.setNString(2, rs.getPackageID());
//				int i = ps2.executeUpdate();
//
//				if (i > 0) {
//
//					return "" + jsonArray;
//				}

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
