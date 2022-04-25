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

import Bill.bean.addBillBean;
import Bill.bean.deleteBillBean;
import Bill.bean.updateBillBean;
import Bill.bean.viewBillBean;
import Bill.dao.addBillDao;
import Bill.dao.deleteBillDao;
import Bill.dao.updateBillDao;
import Bill.dao.viewBillDao;
import Bill.dao.viewallBillDao;

	@Path("/bills")
	public class BillServices {
		
		// add a bill
		@Path("/addBill")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String addabill(String userdate) throws JsonParseException, JsonMappingException, IOException {
	
			String str = null;
	
	
			try {
	
				ObjectMapper mapper = new ObjectMapper();
				addBillBean addBillBean = mapper.readValue(userdate, addBillBean.class);
				str = addBillDao.addBillDetails(addBillBean);
	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	
	
			return str;
		}

		
	
	    //view bill
		@Path("/viewBill")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String viewabill(String s) throws JsonParseException, JsonMappingException, IOException {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				viewBillBean viewBillBean = objectMapper.readValue(s, viewBillBean.class);

				String result = viewBillDao.viewBillDetails(viewBillBean);

				if (result.equals("failed")) {
					return "Bill Id Incorrect";
				} else {
					return result;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "fail";
		}

		
		
		// update bill details
		@Path("/updateBill")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String updateabill(String s) {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				updateBillBean updateBillBean = objectMapper.readValue(s, updateBillBean.class);

				if (updateBillDao.checkBillID(updateBillBean) == true
						&& updateBillDao.updateBillDetails(updateBillBean) == true) {

					return "Update Bill Details Successfully";

				} else {
					return "Update Bill Details Failed";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "fail";
		}	


		
		// delete bill
		@Path("/deleteBill")
		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteabill(String s) {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				deleteBillBean deleteBillBean = objectMapper.readValue(s, deleteBillBean.class);

				if (deleteBillDao.deleteBillDetails(deleteBillBean) == true) {

					return "Bill Delete Successfully";

				} else {
					return "Bill Delete failed";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "fail";
		}
		
		
		// display all the bill details
		@GET
		@Path("/viewallBill")
		@Produces(MediaType.TEXT_HTML)
		public String readItems() {
			viewallBillDao r = new viewallBillDao();

			return r.viewallBillDao();
		}
		
	
	
}
