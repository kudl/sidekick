package com.kudl.sidekick.ddd.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kudl.sidekick.ddd.infrastructure.jpa.converter.NameAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_item")
public class ProductItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	@Convert(converter = NameAttributeConverter.class)
	private Name name;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	protected ProductItem() {
	}

	public ProductItem(final Name name, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static ProductItem of(final Long productId, final Name name) {
		return new ProductItem(name, LocalDateTime.now(), LocalDateTime.now());
	}

	public Long getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public Product getProduct() {
		return product;
	}
}
