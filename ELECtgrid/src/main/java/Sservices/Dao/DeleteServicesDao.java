package Sservices.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Sservices.Bean.DeleteServices;
import com.jersy.dbconnect.DbConnection;

public class DeleteServicesDao {
	
	public static boolean deleteUser(DeleteServices DeleteServices) {

		Connection con = DbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM servicemanagement WHERE packageID=?");
			ps.setNString(1, DeleteServices.getPackageID());
			int i = ps.executeUpdate();

			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

}
}
