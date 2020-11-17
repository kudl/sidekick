package com.kudl.sidekick.ddd.base;

import com.kudl.sidekick.ddd.domain.Contents;
import com.kudl.sidekick.ddd.domain.Hide;
import com.kudl.sidekick.ddd.domain.Name;
import com.kudl.sidekick.ddd.domain.Product;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ProductBase {

	Product product1;
	Product product2;
	List<Product> products;

	public Product getProduct1() {
		return product1;
	}

	public Product getProduct2() {
		return product2;
	}

	public List<Product> getProducts() {
		return products;
	}

	@BeforeEach
	void setUp() {
		product1 = mockProduct(1L, "NameTest1", "ContentsTest1");
		product2 = mockProduct(2L, "NameTest2", "ContentsTest2");
		products = Arrays.asList(product1, product2);
	}

	private Product mockProduct(Long id, String name, String contents) {
		return new Product(id, Name.of(name), Contents.of(contents), Hide.of(false), Arrays.asList(),
				LocalDateTime.now(), LocalDateTime.now());
	}
}
