package com.jersy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.validation.constraints.Null;

import com.jersy.bean.enquiryUpdateBean;
import com.jersy.dbconnect.dbConnection;

public class enquiryUpdateDao {

	public static boolean checkenquiryID(enquiryUpdateBean enquiryUpdateBean) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("select * from enquiry where enquiryID=?");
			ps.setNString(1, enquiryUpdateBean.getEnquiryID());
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

	public static boolean changeDetails(enquiryUpdateBean enquiryUpdateBean) {
		String s1 = enquiryUpdateBean.getNewType();
		Connection con = dbConnection.connect();
//		,enquiryType?,enquiryDetails=?
		try {
			
			if(s1.equals("powercut") || s1.equals("billissue")) {

					PreparedStatement ps = con.prepareStatement("update enquiry set email=? , name=? , contact=? , enquiryType=? , enquiryDetails=? where enquiryID=?");
					ps.setNString(6, enquiryUpdateBean.getEnquiryID());
					ps.setNString(1, enquiryUpdateBean.getNewemail());
					ps.setNString(2, enquiryUpdateBean.getNewname());
					ps.setNString(3, enquiryUpdateBean.getNewcontact());
					ps.setNString(4, enquiryUpdateBean.getNewType());
					ps.setNString(5, enquiryUpdateBean.getNewOther());
					
					int i = ps.executeUpdate();
		
					if (i > 0) {
						return true;
					} else {
						return false;
					}
			}else {
				return false;
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

}
