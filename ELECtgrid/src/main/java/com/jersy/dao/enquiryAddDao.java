
package com.jersy.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Random;

import com.jersy.bean.enquiryAddBean;
import com.jersy.dbconnect.dbConnection;

import sun.print.PSPrinterJob.PluginPrinter;
public class enquiryAddDao {


	public static String addDao(enquiryAddBean rs) {

//		int otp = new Random().nextInt(345);
		String s1 = rs.getEnquiryType();

		Connection con = dbConnection.connect();
		
		try {

			PreparedStatement ps1 = con.prepareStatement("select enquiryID from enquiry where enquiryID=?");
			ps1.setString(1, rs.getEnquiryID());
			ResultSet rrs = ps1.executeQuery();
			
			
			PreparedStatement ps2 = con.prepareStatement("select email from user where email=?");
			ps2.setString(1, rs.getEmail() ); 
			ResultSet rrs1 = ps2.executeQuery();
			 
			
			//check entered id already exit or not
			if (rrs1.next()) {
				
				if (rrs.next()) {
					
					return "InquiryID is already exist";
					
				} else {
					
					if(s1.equals("powercut") || s1.equals("billissue")) {
						
						
						PreparedStatement ps = con.prepareStatement("insert into enquiry values(?,?,?,?, ?, ?)");
						ps.setString(1, rs.getEnquiryID());
						ps.setString(2, rs.getEmail());
						ps.setString(3, rs.getName());
						ps.setString(4, rs.getContact());
						ps.setString(5, rs.getEnquiryType());
						ps.setString(6, rs.getEnquiryDetails());
		
						int i = ps.executeUpdate();
		
						if (i > 0) {
							return "success";
						} else {
							return "failed";
						}
					
					}else {
						return "type not passed correctly";
					}

				}
				
				
				
				
			}else{
				//check enter inquiry type powercut or billissue
				return "E-mail is not Registered as user !";
				
			} 
			
			
			
//			else {
//
//				return "E-mail is not Registered as user !";
//				
//			}

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
		return "fail1";

	}

}