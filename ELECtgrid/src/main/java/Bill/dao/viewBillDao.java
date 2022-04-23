package Bill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Bill.bean.viewBillBean;
import com.jersy.dbconnect.dbConnection;

public class viewBillDao {

	public static String viewBillDetails(viewBillBean rs) {


		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select * from bill where billId=? ");
			ps1.setString(1, rs.getBillId());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("userId", rrs.getString(1));
				jsonObject.put("billId", rrs.getString(2));
				jsonObject.put("date", rrs.getString(3));
				jsonObject.put("arrears", rrs.getFloat(4));
				jsonObject.put("mobile", rrs.getFloat(5));
				jsonObject.put("totalPayble", rrs.getFloat(6));
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(jsonObject);
				return "" + jsonArray;
				
//				PreparedStatement ps2 = con.prepareStatement("update user set status = ? where email = ?");
//				ps2.setString(1, "online");
//				ps2.setNString(2, rs.getEmail());
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
