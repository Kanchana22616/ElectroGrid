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

		String output = "";
		Connection con = dbConnection.connect();

		try {
			
			output = "<table border='1'><tr>"
					+ "<th>User ID</th>"
					+ "<th>Bill ID</th>"
					+ "<th>Date</th>"
					+ "<th>Arrears</th>"
					+ "<th>Amount</th>"
					+ "<th>Total Payble</th>"
					+ "<th>Emp Name</th>"
					+ " </tr>";


			PreparedStatement ps1 = con.prepareStatement("select b.userId, b.billId, b.date, b.arrears, b.amount, b.totalPayble, e.EmpName from bill b, employees e where e.EmpID = b.EmpID and b.billId = ? ");
			ps1.setString(1, rs.getBillId());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {

											
				String userId = rrs.getString(1);
				String billId = rrs.getString(2);
				String date = rrs.getString(3);
				Float arrears = rrs.getFloat(4);
				Float amount = rrs.getFloat(5);
				Float totalPayble = rrs.getFloat(6);
				String empName = rrs.getString(7);
				
				output += "<tr><td>" + userId + "</td>";
				output += "<td>" + billId + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + arrears + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + totalPayble + "</td>";
				output += "<td>" + empName + "</td>";


				output += "</table>";
				return "" + output;

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
