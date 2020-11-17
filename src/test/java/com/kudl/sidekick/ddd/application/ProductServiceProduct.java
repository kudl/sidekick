package com.kudl.sidekick.ddd.application;

import com.kudl.sidekick.ddd.base.ProductBase;
import com.kudl.sidekick.ddd.domain.Product;
import com.kudl.sidekick.ddd.domain.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ProductServiceProduct extends ProductBase {

	@Autowired ProductService productService;
	@MockBean ProductRepository productRepository;

	@Test
	void index() {
		given(productRepository.findAll())
				.willReturn(getProducts());

		List<Product> products = productService.index();

		assertThat(getProducts().size()).isEqualTo(products.size());
	}

	@Test
	void show() {
		long productId = 1L;
		given(productRepository.findById(productId))
				.willReturn(Optional.of(getProduct1()));

		Product product = productService.show(productId);

		assertThat(productId).isEqualTo(product.getId());
	}
}