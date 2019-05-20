package com.mashreq.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mashreq.RetailApplication;
import com.mashreq.util.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RetailApplication.class)
@ComponentScan(basePackages = "com.mashreq")
public class RetailControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webappCtx;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webappCtx).alwaysDo(MockMvcResultHandlers.print()).build();
		
	}
	
	@Test
	public void testCheckout() {
		
		try {
			String checkoutRequest = TestUtil.getJSONObjectStringByJSONFileName("employeeCheckout.json");
			
			ResultActions andExpect = this.mockMvc
					.perform(MockMvcRequestBuilders.multipart("/api/v1/checkout")
							.contentType("application/json")
							.content(checkoutRequest));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
