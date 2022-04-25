package Employee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.jersy.dbconnect.dbConnection;

import Employee.Bean.UpdateEmployeeBean;

public class UpdateEmployeeDao {

	public static boolean checkEmployee(UpdateEmployeeBean UpdateEmployeeBean) {

		Connection con = dbConnection.connect();  //db connect line 

		try {

			PreparedStatement ps = con.prepareStatement("select * from Employee where EmpID=?"); //catch up empID and then can update feilds
			ps.setInt(1,UpdateEmployeeBean.getEmpID());
			
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

	//employee change values  part in   setup
	public static boolean changeEmployee(UpdateEmployeeBean UpdateEmployeeBean) {

		Connection con = dbConnection.connect();     //db connect line 

		try {
            //all update field are here can change 1 or more 
			PreparedStatement ps = con.prepareStatement("update Employee set  EmpName=? , EmpAge = ? , EmpDept= ? , EmpDOB =? , EmpEmail = ? , ContractNum = ? where EmpId=?");
			ps.setInt(7,UpdateEmployeeBean.getEmpID());
			ps.setString(1, UpdateEmployeeBean.getNewempName());
			ps.setInt(2, UpdateEmployeeBean.getNewempAge());
			ps.setString(3, UpdateEmployeeBean.getNewempDept());
			ps.setString(4, UpdateEmployeeBean.getNewempDOB());
			ps.setString(5, UpdateEmployeeBean.getNewempEmail());
			ps.setString(6, UpdateEmployeeBean.getNewcontractNum());
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
