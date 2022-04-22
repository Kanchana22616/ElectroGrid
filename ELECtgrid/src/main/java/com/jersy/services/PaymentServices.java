package com.jersy.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jersy.bean.PaymentInsertBean;
import com.jersy.dao.PaymentInsertDao;

public class PaymentServices {
	
	@Path("/payment")
	public class paymentServices {

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
	}

}
