package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dbconnect.DbConnection;
import com.jersy.bean.PaymentDeleteBean;

public class PaymentDeleteDao {
	
	public static boolean deletePayment(PaymentDeleteBean deleteP) {

		Connection con = DbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM payment WHERE accountNumber=?");
			ps.setNString(1, deleteP.getAccountNumber());
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
