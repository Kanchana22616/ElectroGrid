package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dbconnect.DbConnection;
import com.jersy.bean.PaymentInsertBean;

public class PaymentInsertDao {
	
	public static String insertPaymentDetails(PaymentInsertBean payment) {
		
		Connection conn = DbConnection.connect();

		try {

				PreparedStatement ps = conn.prepareStatement("insert into payment values(?,?,?,?,?,?,?,?)");
				ps.setString(1, payment.getAccountNumber());
				ps.setString(2,Float.toString(payment.getAmount()));
				ps.setString(3, payment.getEmail());
				ps.setString(4, payment.getCardType());
				ps.setString(5, payment.getAccountNumber());
				ps.setString(6, payment.getExpMonth());
				ps.setString(7, payment.getExpYear());
				ps.setString(8,Integer.toString(payment.getCvv()));
				int i = ps.executeUpdate();

				if (i > 0) {
					return "success";
				} else {
					return "failed";
				}

			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return "fail";

	}

}
