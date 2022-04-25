package Bill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bill.bean.updateBillBean;
import com.jersy.dbconnect.dbConnection;

public class updateBillDao {
	
	public static boolean checkBillID(updateBillBean updateBillBean) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("select * from bill where billId=? ");
			ps.setNString(1, updateBillBean.getBillId());
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

	public static boolean updateBillDetails(updateBillBean updateBillBean) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("update bill set date=? , arrears=? , amount=? , totalPayble=? where billId=?");
			ps.setNString(1, updateBillBean.getNewdate());
			ps.setFloat(2, updateBillBean.getNewarrears());
			ps.setFloat(3, updateBillBean.getNewamount());
			ps.setFloat(4, updateBillBean.getNewtotalPayble());
			ps.setNString(5, updateBillBean.getBillId());
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



