package com.jersy.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jersy.bean.PaymentDeleteBean;
import com.jersy.bean.PaymentInsertBean;
import com.jersy.dao.PaymentDeleteDao;
import com.jersy.dao.PaymentInsertDao;


	
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
		
		

	/*	//delete
		
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
			*/
	}


