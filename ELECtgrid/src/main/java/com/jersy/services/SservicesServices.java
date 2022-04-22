package com.jersy.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.JsonParseException;

import Sservices.Bean.InsertServices;
import Sservices.Dao.InsertServicesDao;


@Path("/service")
public class SservicesServices {
	
	// register a user
		@Path("/register")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String registerUser(String userdate) throws JsonParseException, JsonMappingException, IOException {

			String str = null;

//			JsonParser jsonParser = new JsonParser();
//			JsonElement jasElement = jsonParser.parse(userdate);
//			if (jasElement.isJsonObject()) {
	//
//				JsonObject jsonObject = jasElement.getAsJsonObject();
	//
//				UserBean userBean = new UserBean(jsonObject.get("name").getAsString(),
//						jsonObject.get("email").getAsString(), jsonObject.get("pass").getAsString(),
//						jsonObject.get("mobile").getAsString());
//				str = UserDao.registerDao(userBean);
	//
//			}

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


}
