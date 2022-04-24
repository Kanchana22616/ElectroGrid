package com.jersy.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.JsonParseException;

import Sservices.Bean.DeleteServices;
import Sservices.Bean.InsertServices;
import Sservices.Bean.UpdateServices;
import Sservices.Bean.ViewServices;
import Sservices.Dao.AllViewServDao;
import Sservices.Dao.DeleteServicesDao;
import Sservices.Dao.InsertServicesDao;
import Sservices.Dao.UpdateServicesDao;
import Sservices.Dao.ViewServicesDao;


@Path("/SservicesServices")
public class SservicesServices {
	
	// Add a package 
		@Path("/addserv")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String registerUser(String userdate) throws JsonParseException, JsonMappingException, IOException {

			String str = null;


			try {

				ObjectMapper mapper = new ObjectMapper();
				InsertServices InsertServices = mapper.readValue(userdate, InsertServices.class);
				str = InsertServicesDao.insertservice(InsertServices);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}


			return str;
		}

		// View package details
				@Path("/view")
				@GET
				@Consumes(MediaType.APPLICATION_JSON)
				@Produces(MediaType.APPLICATION_JSON)
				public String viewEmployee(String s) throws JsonParseException, JsonMappingException, IOException {

					try {

						ObjectMapper objectMapper = new ObjectMapper();
						ViewServices viewServices = objectMapper.readValue(s, ViewServices.class);

						String result = ViewServicesDao.viewdao(viewServices);

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
				// delete package
				@Path("/delete")
				@POST
				@Consumes(MediaType.APPLICATION_JSON)
				@Produces(MediaType.APPLICATION_JSON)
				public String deleteUser(String s) {

					try {

						ObjectMapper objectMapper = new ObjectMapper();
						DeleteServices DeleteServices = objectMapper.readValue(s, DeleteServices.class);

						if (DeleteServicesDao.deleteUser(DeleteServices) == true) {

							return "user delete successfully";

						} else {
							return "remove failed";
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

					return "fail";
				}
				
				//Put method - update package details
				@Path("/update")
				@PUT
				@Consumes(MediaType.APPLICATION_JSON)
				@Produces(MediaType.APPLICATION_JSON)
				public String enquiryupdate(String s) {

					try {

						ObjectMapper objectMapper = new ObjectMapper();
						UpdateServices UpdateServices = objectMapper.readValue(s,  UpdateServices.class);

						if (UpdateServicesDao.checkeservID(UpdateServices) == true
								&& UpdateServicesDao.changeservDetails(UpdateServices) == true) {

							return "Changes done";

						} else {
							return "Changes failed";
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

					return "fail1";
				}
				
				
				
				// display all the details
				
				// get method
				//get 
				@GET
				@Path("/servread")
				@Produces(MediaType.TEXT_HTML)
				public String readItems() {
					AllViewServDao r = new AllViewServDao();

					return r.AllViewServDao();
				}
				
}
