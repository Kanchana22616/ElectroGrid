package com.jersy.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.JsonParseException;

import Sservices.Bean.DeleteServices;
import Sservices.Bean.InsertServices;
import Sservices.Bean.ViewServices;
import Sservices.Dao.DeleteServicesDao;
import Sservices.Dao.InsertServicesDao;
import Sservices.Dao.ViewServicesDao;


@Path("/SservicesServices")
public class SservicesServices {
	
	// register a user
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

		// VIEW Employee path
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
				// delete user
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
}
