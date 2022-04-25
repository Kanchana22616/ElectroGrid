package Sservices.Dao;
import java.sql.PreparedStatement;
import com.jersy.dbconnect.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import Sservices.Bean.UpdateServices;

public class UpdateServicesDao {

	public static boolean checkeservID(UpdateServices UpdateServices) {

		Connection con = DbConnection.connect();

		try {

			//check the Query statement 
			PreparedStatement ps = con.prepareStatement("select * from servicemanagement where packageID=?");
			ps.setInt(1, UpdateServices.getPackageID());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
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
	
		//Update details according to the packageID 
		public static boolean changeservDetails(UpdateServices UpdateServices) {

			Connection con =  DbConnection.connect();

			try {

						PreparedStatement ps = con.prepareStatement("update servicemanagement set packageType=? , packageUnitPrice=? , PackageInstruction=? , services=? where packageID=?");
						ps.setNString(1, UpdateServices.getNewpackageType());
						ps.setFloat(2, UpdateServices.getNewpackageUnitPrice());
						ps.setNString(3, UpdateServices.getNewPackageInstruction());
						ps.setNString(4, UpdateServices.getNewservices());
						ps.setInt(5, UpdateServices.getPackageID());
	
						
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
