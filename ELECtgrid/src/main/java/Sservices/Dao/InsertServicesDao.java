package Sservices.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jersy.dbconnect.DbConnection;

import Sservices.Bean.InsertServices;


public class InsertServicesDao {
	
	public static String insertservice(InsertServices rs) {

		//DB connection

		Connection con = DbConnection.connect();

		try {
			//catching the package ID  in table
			PreparedStatement ps1 = con.prepareStatement("select packageID from servicemanagement where packageID=?");
			ps1.setInt(1, rs.getPackageID());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				return "Already Exist";
			} else {

				//Inserting query
				PreparedStatement ps = con.prepareStatement("insert into servicemanagement values(?,?,?,?,?)");
				ps.setInt(1, rs.getPackageID());
				ps.setString(2, rs.getPackageType());
				ps.setFloat(3, rs.getPackageUnitPrice());
				ps.setString(4, rs.getPackageInstruction());
				ps.setString(5, rs.getServices());
				
				int i = ps.executeUpdate();
				//System.out.println("hellooo");

				if (i > 0) {
					return "success";
				} else {
					return "failed";
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return "fail";

	}


}
