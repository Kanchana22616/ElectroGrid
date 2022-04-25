package com.jersy.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jersy.bean.enquiryDeleteBean;
import com.jersy.dbconnect.dbConnection;

public class enquiryDeleteDao {

	public static boolean enquiryDelete(enquiryDeleteBean enquiryDeleteBean) {

		//db connection
		Connection con = dbConnection.connect();

		try {

			//Query statement
			PreparedStatement ps = con.prepareStatement("DELETE FROM enquiry WHERE enquiryID=?");
			ps.setNString(1, enquiryDeleteBean.getEnquiryID());
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
