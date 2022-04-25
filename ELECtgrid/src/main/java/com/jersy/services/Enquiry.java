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


import com.jersy.bean.enquiryAddBean;
import com.jersy.dao.enquiryAddDao;

import com.jersy.bean.enquiryViewBean;
import com.jersy.dao.enquiryViewDao;

import com.jersy.bean.enquiryUpdateBean;
import com.jersy.dao.enquiryUpdateDao;

import com.jersy.bean.enquiryDeleteBean;
import com.jersy.dao.enquiryDeleteDao;

import com.jersy.dao.enquiryViewAllDao;

//Root path
@Path("/enquiry")
public class Enquiry {

	// enquiryAdd
	//Post
	@Path("/enquiryAdd")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String enquiryAdd(String userdate) throws JsonParseException, JsonMappingException, IOException {

		String str = null;

		try {

			ObjectMapper mapper = new ObjectMapper();
			enquiryAddBean userBean = mapper.readValue(userdate, enquiryAddBean.class);
			str = enquiryAddDao.addDao(userBean);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		return str;
	}
	
//	Search by inquiry ID 
	
//	Get method 
	@Path("/enquirySearch")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String enquiryView(String s) throws JsonParseException, JsonMappingException, IOException {

		try {

			ObjectMapper objectMapper = new ObjectMapper();
			enquiryViewBean enquiryViewBean = objectMapper.readValue(s, enquiryViewBean.class);

			String result = enquiryViewDao.enquiryViewDao(enquiryViewBean);

			if (result.equals("failed")) {
				return "EnquiryID is incorrect";
			} else {
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	// enquiry update
	//Put method
	@Path("/enquiryupdate")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String enquiryupdate(String s) {

		try {

			ObjectMapper objectMapper = new ObjectMapper();
			enquiryUpdateBean enquiryUpdateBean = objectMapper.readValue(s, enquiryUpdateBean.class);

			if (enquiryUpdateDao.checkenquiryID(enquiryUpdateBean) == true
					&& enquiryUpdateDao.changeDetails(enquiryUpdateBean) == true) {

				return "Changes done";

			} else {
				return "Changes failed";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "fail1";
	}
	
//	enquiryDelete
	//Delete method
	
	@Path("/enquiryDelete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String enquiryDelete(String s) {

		try {

			ObjectMapper objectMapper = new ObjectMapper();
			enquiryDeleteBean enquiryDeleteBean = objectMapper.readValue(s, enquiryDeleteBean.class);

			if (enquiryDeleteDao.enquiryDelete(enquiryDeleteBean) == true) {

				return "Enquiry deleted successfully";

			} else {
				return "Enquiry deletion failed";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "fail";
	}
	
	
	// display all the details
	
	// get method
	//get 
	@GET
	@Path("/enquiryread")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		enquiryViewAllDao r = new enquiryViewAllDao();

		return r.enquiryViewAllDao();
	}


}