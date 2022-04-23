package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dbconnect.DbConnection;
import com.jersy.bean.PaymentUpdateBean;

public class PaymentUpdateDao {
	
	public static boolean updatePayment(PaymentUpdateBean updateD) {

		Connection con = DbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("update payment set cardType=?,cardNumber=?,expMonth=?,expYear=?,cvv=? where email=?");
			ps.setNString(1, updateD.getCardType());
			ps.setNString(2, updateD.getCardNumber());
			ps.setNString(3, updateD.getExpMonth());
			ps.setNString(4, updateD.getExpYear());
			ps.setNString(5, Integer.toString(updateD.getCvv()));
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
