package Employee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.jersy.dbconnect.dbConnection;

import Employee.Bean.InsertEmployeeBean;

public class InsertEmployeeDao {


	public static String InsertDao(InsertEmployeeBean rs) {

		

		Connection con = dbConnection.connect();  //db connect line

		try {

			PreparedStatement ps1 = con.prepareStatement("select EmpID from Employee where EmpID=?"); //SQL query for selected EmpId
			ps1.setInt(1, rs.getEmpID());
			ResultSet rrs = ps1.executeQuery();
			
			
				//if same id input then get error msg
			if (rrs.next()) {
				return "Already Exist EmpID";
			} else {

				
				PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?,?, ?,?, ?)"); //insert data feild for table
				ps.setInt(1, rs.getEmpID()); //all data base field fix in order to
				ps.setString(2, rs.getEmpName());
				ps.setInt(3, rs.getEmpAge());
				ps.setString(4, rs.getEmpDept());
				ps.setString(5, rs.getEmpDOB());
				ps.setString(6, rs.getEmpEmail());
				ps.setString(7, rs.getContractNum());

				int i = ps.executeUpdate();

				if (i > 0) {
					return "success rquest";
				} else {
					return "failed rquest";
				}

			}
        //try carch handler
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
		return "fail rquest";

	}
}
