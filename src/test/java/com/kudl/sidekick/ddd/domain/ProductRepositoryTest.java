package com.kudl.sidekick.ddd.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

	ProductRepository productRepository;

	public ProductRepositoryTest(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Test
	public void findOneTest() {
		Long productId = 1L;

		Product product = productRepository.findById(productId)
				.orElseThrow(IllegalStateException::new);

		assertThat(productId).isEqualTo(product.getId());
	}
}