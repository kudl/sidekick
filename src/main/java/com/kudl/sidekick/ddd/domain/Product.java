package com.kudl.sidekick.ddd.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.ImmutableList;
import com.kudl.sidekick.ddd.infrastructure.jpa.converter.ContentsAttributeConverter;
import com.kudl.sidekick.ddd.infrastructure.jpa.converter.HideAttributeConverter;
import com.kudl.sidekick.ddd.infrastructure.jpa.converter.NameAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@Convert(converter = NameAttributeConverter.class)
	private Name name;

	@Column
	@Convert(converter = ContentsAttributeConverter.class)
	private Contents contents;

	@Column
	@Convert(converter = HideAttributeConverter.class)
	private Hide hide;

	@JsonManagedReference
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductItem> productItems;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime updatedAt;

	protected Product() {

	}

	private Product(String name, String contents) {
		this.name = Name.of(name);
		this.contents = Contents.of(contents);
		this.hide = Hide.of(false);
	}

	public Product(Long id, Name name, Contents contents, Hide hide, List<ProductItem> productItems, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.name = name;
		this.contents = contents;
		this.hide = hide;
		this.productItems = productItems;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static Product of(String name, String contents) {
		return new Product(name, contents);
	}

	public Long getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public Contents getContents() {
		return contents;
	}

	public Hide getHide() {
		return hide;
	}

	public List<ProductItem> getProductItems() {
		return ImmutableList.copyOf(productItems);
	}

	public void addItem(final ProductItem item) {
		checkNotNull(item);
		final Optional<ProductItem> repeated = productItems.stream()
				.filter(i -> i.getName().equals(item.getName()))
				.findAny();

		productItems.add(repeated.map(i -> {
			productItems.remove(i);
			return new ProductItem(i.getName(), LocalDateTime.now(), LocalDateTime.now());
		}).orElse(item));
	}
}
