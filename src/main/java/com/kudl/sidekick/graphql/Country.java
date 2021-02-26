package com.kudl.sidekick.graphql;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GraphQLQuery(name = "id", description = "Country id")
	private Long id;

	@GraphQLQuery(name = "name", description = "Country name")
	private String name;

	@Column
	@GraphQLQuery(name = "hide", description = "Country hide")
	private Boolean hide;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Boolean getHide() {
		return hide;
	}

	@Override
	public String toString() {
		return "Country{" +
				"id=" + id +
				", name='" + name + '\'' +
				", hide=" + hide +
				'}';
	}
}
