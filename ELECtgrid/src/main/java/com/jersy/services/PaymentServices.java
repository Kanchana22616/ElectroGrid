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

import com.jersy.bean.PaymentDeleteBean;
import com.jersy.bean.PaymentInsertBean;
import com.jersy.bean.PaymentRetrieveBean;
import com.jersy.bean.PaymentUpdateBean;
import com.jersy.dao.PaymentDeleteDao;
import com.jersy.dao.PaymentInsertDao;
import com.jersy.dao.PaymentRetrieveDao;
import com.jersy.dao.PaymentUpdateDao;

import com.jersy.dao.PaymentViewAllDao;

	
	@Path("/payment")
	public class PaymentServices {

		// make payment
		@Path("/insert")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String insertPayment(String p) throws JsonParseException, JsonMappingException, IOException {

			String str = null;


			try {

				ObjectMapper mapper = new ObjectMapper();
				PaymentInsertBean pDetails = mapper.readValue( p, PaymentInsertBean.class);
				str = PaymentInsertDao.insertPaymentDetails(pDetails);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}


			return str;
		}
		
		

		    //delete
		
			@Path("/delete")
			@DELETE
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
			public String deletePaymentD(String s) {

				try {

					ObjectMapper objectMapper = new ObjectMapper();
					PaymentDeleteBean deleteP = objectMapper.readValue(s, PaymentDeleteBean.class);

					if (PaymentDeleteDao.deletePayment(deleteP) == true) {

						return "payment details delete successfully";

					} else {
						return "deletion failed";
					}

				} catch (Exception e) {
					// TODO: handle exception
				}

				return "fail";
			}
			
			
			//update
			@Path("/update")
			@PUT
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
			public String updatePayment(String s) {

				try {

					ObjectMapper objectMapper = new ObjectMapper();
					PaymentUpdateBean updateD = objectMapper.readValue(s, PaymentUpdateBean.class);

					if( PaymentUpdateDao.updatePayment(updateD) == true && PaymentUpdateDao.checkPayment(updateD)) {

						return "update details successfully";

					} else {
						return "update failed";
					}

				} catch (Exception e) {
					// TODO: handle exception
				}

				return "fail";
			}
			
			//search function
			
			@Path("/view")
			@POST
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
			public String loginUser(String s) throws JsonParseException, JsonMappingException, IOException {

				try {

					ObjectMapper objectMapper = new ObjectMapper();
					PaymentRetrieveBean cD = objectMapper.readValue(s, PaymentRetrieveBean.class);

					String result = PaymentRetrieveDao.showDetails(cD);

				
						return result;

				} catch (Exception e) {
					e.printStackTrace();
				}
				return "fail";
			}
			
			// display all the details
			
		
			//get 
			@GET
			@Path("/viewAll")
			@Produces(MediaType.TEXT_HTML)
			public String readItems() {
				PaymentViewAllDao r = new PaymentViewAllDao();

				return r.payentViewAll();
			}


			
			
	}


