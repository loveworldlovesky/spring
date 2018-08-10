package com.example.demo.seckill.product.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.App;

import net.minidev.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class,webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ProductControllerTest {
	// 注入webApplicationContext
    @Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	// 设置mockMvc
	@Before
	public void setMockMvc() {
//		mockMvc = MockMvcBuilders.standaloneSetup(new ProductController()).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testProductSeckill() {
		try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("phoneNum", "18613879273");
            jsonObject.put("productNum", "NOKIA7P");
            mockMvc.perform(MockMvcRequestBuilders.post("/product/seckill")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonObject.toJSONString())
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInsert() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/product/insert"))
					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("userName", "liuys26");
//            jsonObject.put("userPw", "123");
//            jsonObject.put("cityCode", "801000");
//            jsonObject.put("userType", "0");
//            mockMvc.perform(MockMvcRequestBuilders.post("/api/login/auth")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(jsonObject.toJSONString())
//            ).andExpect(MockMvcResultMatchers.status().isOk())
//                    .andDo(MockMvcResultHandlers.print());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
