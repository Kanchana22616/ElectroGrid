package Employee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jersy.dbconnect.dbConnection;

import Employee.Bean.ViewEmployeeBean;



public class ViewEmployeeDao {

	public static String ViewEmployeeDao(ViewEmployeeBean rs) {


		Connection con = dbConnection.connect();   //conneting data base table 

		try {

			PreparedStatement ps1 = con.prepareStatement("select * from Employee where EmpID=?");
			ps1.setInt(1, rs.getEmpID());
		
			ResultSet rrs = ps1.executeQuery();     //get the out put using sql

			if (rrs.next()) {

					//API link overall attribute
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("EmpID", rrs.getInt(1));
				jsonObject.put("EmpName", rrs.getString(2));
				jsonObject.put("EmpAge", rrs.getInt(3));
				jsonObject.put("EmpDept", rrs.getString(4));
				jsonObject.put("EmpDOB", rrs.getString(5));
				jsonObject.put("EmpEmail", rrs.getString(6));
				jsonObject.put("ContractNum", rrs.getString(7));
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(jsonObject);
				
				return "" + jsonArray;    //taking the out put request
				
			

			} else {

				return "Failed the request ";

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "Failed the request ";

	}
}
