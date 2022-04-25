package Bill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Bill.bean.addBillBean;
import com.jersy.dbconnect.dbConnection;

public class addBillDao {

	public static String addBillDetails(addBillBean rs) {

		

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select billId from bill where billId=?");
			ps1.setString(1, rs.getBillId());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				return "Already Exist";
			} else {
				
				
				
				
				PreparedStatement ps = con.prepareStatement("insert into bill values(?,?,?,?,?,?,?)");
				ps.setString(1, rs.getUserId());
				ps.setString(2, rs.getBillId());
				ps.setString(3, rs.getDate());
				ps.setFloat(4, rs.getArrears());
				ps.setFloat(5, rs.getAmount());
				ps.setFloat(6, rs.getTotalPayble());
				ps.setInt(7, rs.getEmpId());

				int i = ps.executeUpdate();

				if (i > 0) {
					return "Insert Succsessfully";
				} else {
					return "Insert Failed";
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


