package com.kudl.sidekick.ddd.view;

import com.kudl.sidekick.ddd.application.ProductService;
import com.kudl.sidekick.ddd.base.ProductBase;
import com.kudl.sidekick.ddd.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.kudl.sidekick.ddd.view.ProductConstants.BASE;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerProduct extends ProductBase {

	@Autowired MockMvc mockMvc;
	@MockBean ProductService productService;
	@Autowired ObjectMapper mapper;

	@Test
	void index() throws Exception {
		given(productService.index())
				.willReturn(getProducts());

		ResultActions actions = mockMvc.perform(get(BASE)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print());

		actions.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andDo(print());
	}

	@Test
	void show() throws Exception {
		given(productService.show(1L))
				.willReturn(getProduct1());

		mockMvc.perform(get(BASE + "/{productId}", 1L)
			.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andDo(print());
	}

	@Test
	void create() throws Exception {
		String name = "createName";
		String contents = "createContents";
		Product product = Product.of(name, contents);
		CreateRequest createRequest = new CreateRequest(name, contents);

		given(productService.create(createRequest))
			.willReturn(product);

		mockMvc.perform(post(BASE)
				.content(mapper.writeValueAsString(createRequest))
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isCreated())
			.andDo(print());
	}

	@Test
	void destroy() throws Exception {
		mockMvc.perform(delete(BASE + "/{productId}", 1L))
			.andDo(print())
			.andExpect(status().isNoContent());
	}
}