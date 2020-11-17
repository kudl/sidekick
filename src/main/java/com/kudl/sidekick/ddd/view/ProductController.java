package com.kudl.sidekick.ddd.view;

import com.kudl.sidekick.ddd.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.kudl.sidekick.ddd.view.ProductConstants.BASE;

@RequestMapping(BASE)
@RestController
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity index() {
		return new ResponseEntity(productService.index(), HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	public ResponseEntity show(@PathVariable Long productId) {
		return new ResponseEntity(productService.show(productId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity create(@RequestBody CreateRequest createRequest) {
		return new ResponseEntity(productService.create(createRequest), HttpStatus.CREATED);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity destroy(@PathVariable Long productId) {
		productService.destroy(productId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
