package com.kudl.sidekick.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.kudl.sidekick.common.SidekickConstant.URL.SIDEKIQ;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SidekickControllerTest {

	@Autowired
	private SidekickController sidekickController;
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(sidekickController)
				.build();
	}

	@Test
	public void getSidekiqTest() throws Exception {
		mockMvc.perform(get(SIDEKIQ)
			.accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/html;charset=UTF-8"))
			.andExpect(content().string("Get Sidekiq"));
	}

	@Test
	public void createSidekiqTest() throws Exception {
		mockMvc.perform(post(SIDEKIQ)
				.accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/html;charset=UTF-8"))
				.andExpect(content().string("Created Sidekiq"));
	}
}
