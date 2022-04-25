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
		String output = "";
		try {
			// Prepare the html table to be displayed here 
			output = "<table border='1'><tr>"
					+ "<th>EmpID</th>"
					+ "<th> EmpName</th>"
					+ "<th>EmpAge</th>"
					+ "<th>EmpDept</th>"
					+ "<th>EmpDOB</th>"
					+ "<th>EmpEmail</th>"
					+ "<th>ContactNUm</th> </tr>";
			PreparedStatement ps1 = con.prepareStatement("select * from Employee where EmpID=?");
			ps1.setInt(1, rs.getEmpID());
		
			ResultSet rrs = ps1.executeQuery();     //get the out put using sql

			if (rrs.next()) {

					//API link overall attribute
				//JSONObject jsonObject = new JSONObject();
				int empID = rrs.getInt(1);      //set up data as become table 
				String empName = rrs.getString(2);
				int empAge = rrs.getInt(3);
				String empDept = rrs.getString(4);
				String empDOB = rrs.getString(5);
				String empEmail = rrs.getString(6);
				String contractNum = rrs.getString(7);

				// Add into the html table
				output += "<tr><td>" + empID + "</td>";
				output += "<td>" + empName + "</td>";
				output += "<td>" + empAge + "</td>";
				output += "<td>" + empDept + "</td>";
				output += "<td>" + empDOB + "</td>";
				output += "<td>" + empEmail + "</td>";
				output += "<td>" + contractNum + "</td>";		;
				//JSONArray jsonArray = new JSONArray();
				//jsonArray.add(jsonObject);
				output += " </table>"; 
				return "" + output;    //taking the out put request
				
			

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
