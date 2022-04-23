package com.jersy.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import Employee.Bean.DeleteEmployeeBean;
import Employee.Bean.InsertEmployeeBean;
import Employee.Bean.UpdateEmployeeBean;
import Employee.Bean.ViewEmployeeBean;
import Employee.Dao.DeleteEmployeeDao;
import Employee.Dao.InsertEmployeeDao;
import Employee.Dao.UpdateEmployeeDao;
import Employee.Dao.ViewAllEmployee;
import Employee.Dao.ViewEmployeeDao;


//root path 
@Path("/Employee")

public class EmployeeServices {

	// VIEW Employee path
		@Path("/view")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String viewEmployee(String s) throws JsonParseException, JsonMappingException, IOException {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				ViewEmployeeBean ViewEmployeeBean = objectMapper.readValue(s, ViewEmployeeBean.class);

				String result = ViewEmployeeDao.ViewEmployeeDao(ViewEmployeeBean);

				if (result.equals("failed")) {
					return "Incorrect request";
				} else {
					return result;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "fail1 request";
		}
		
		// Insert Employee path
				@Path("/insert")
				@POST
				@Consumes(MediaType.APPLICATION_JSON)
				@Produces(MediaType.APPLICATION_JSON)
				public String registerUser(String userdate) throws JsonParseException, JsonMappingException, IOException {

					String str = null;

					try {

						ObjectMapper mapper = new ObjectMapper();
						InsertEmployeeBean InsertEmployeeBean = mapper.readValue(userdate, InsertEmployeeBean.class);
						str = InsertEmployeeDao.InsertDao(InsertEmployeeBean);

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}


					return str;
				}


				// UPDATE Employee PART
				@Path("/update")
				@PUT
				@Consumes(MediaType.APPLICATION_JSON)
				@Produces(MediaType.APPLICATION_JSON)
				public String employeeUpdate(String s) {

					try {

						ObjectMapper objectMapper = new ObjectMapper();
						UpdateEmployeeBean UpdateEmployeeBean = objectMapper.readValue(s, UpdateEmployeeBean.class);

						if ( UpdateEmployeeDao.checkEmployee(UpdateEmployeeBean) == true
								&& UpdateEmployeeDao.changeEmployee(UpdateEmployeeBean) == true) {

							return "update successfully";

						} else {
							return "update failed";
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

					return "fail";
				}
				

				// delete Employee Path
				@Path("/delete")
				@DELETE
				@Consumes(MediaType.APPLICATION_JSON)
				@Produces(MediaType.APPLICATION_JSON)
				public String deleteUser(String s) {

					try {

						ObjectMapper objectMapper = new ObjectMapper();
						DeleteEmployeeBean DeleteEmployeeBean = objectMapper.readValue(s, DeleteEmployeeBean.class);

						if (DeleteEmployeeDao.DeleteEmployeeDao(DeleteEmployeeBean) == true) {

							return "user delete successfully";

						} else {
							return "remove failed";
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

					return "fail";
				}
				
				// display all the details
				@GET
				@Path("/employeeView")
				@Produces(MediaType.TEXT_HTML)
				public String readItems() {
					ViewAllEmployee r = new ViewAllEmployee();

					return r.ViewAllEmployee();
				}
				
}
