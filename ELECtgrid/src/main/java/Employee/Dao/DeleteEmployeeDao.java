package Employee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.jersy.dbconnect.dbConnection;

import Employee.Bean.DeleteEmployeeBean;

public class DeleteEmployeeDao {


	public static boolean DeleteEmployeeDao(DeleteEmployeeBean DeleteEmployeeBean) {

		Connection con = dbConnection.connect(); //db connect line

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM Employee WHERE EmpID=?"); //sql query code for filtering data
			ps.setInt(1, DeleteEmployeeBean.getEmpID());  //catch up only emp id keys .
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
