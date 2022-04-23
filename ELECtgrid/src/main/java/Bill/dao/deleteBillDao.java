package Bill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bill.bean.deleteBillBean;
import com.jersy.dbconnect.dbConnection;

public class deleteBillDao {
	
	public static boolean deleteBillDetails(deleteBillBean deleteBillBean) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM bill WHERE billId=?");
			ps.setNString(1, deleteBillBean.getBillId());
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
