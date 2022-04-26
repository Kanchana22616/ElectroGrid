package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbconnect.DbConnection;
import com.jersy.bean.PaymentUpdateBean;

public class PaymentUpdateDao {
	
	
	public static boolean checkPayment(PaymentUpdateBean update) {

		Connection con = DbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("select * from payment where accountNumber=? ");
			ps.setNString(1, update.getAccountNumber());
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
	
	public static boolean updatePayment(PaymentUpdateBean updateD) {

		Connection con = DbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("update payment set cardType=?,cardNumber=?,expMonth=?,expYear=?,cvv=? where accountNumber=?");
			ps.setNString(6, updateD.getAccountNumber());
			ps.setNString(1, updateD.getCardTypeN());
			ps.setNString(2, updateD.getCardNumberN());
			ps.setNString(3, updateD.getExpMonthN());
			ps.setNString(4, updateD.getExpYearN());
			ps.setNString(5, Integer.toString(updateD.getCvvN()));
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
