package com.kudl.sidekick.ddd.application;

import com.kudl.sidekick.ddd.domain.Product;
import com.kudl.sidekick.ddd.domain.ProductRepository;
import com.kudl.sidekick.ddd.view.CreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<Product> index() {
		return productRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Product show(Long productId) {
		return productRepository.findById(productId)
				.orElseThrow(IllegalStateException::new);
	}

	public Product create(CreateRequest createRequest) {
		Product product = Product.of(createRequest.getName(), createRequest.getContents());
		productRepository.save(product);
		return product;
	}

	public void destroy(Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(IllegalStateException::new);

		productRepository.delete(product);
	}
}
