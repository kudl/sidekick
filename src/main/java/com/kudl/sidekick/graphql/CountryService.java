package com.kudl.sidekick.graphql;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@GraphQLApi
@RequiredArgsConstructor
public class CountryService {

	private final CountryRepository countryRepository;

	@GraphQLQuery(name = "countries")
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}

	@GraphQLQuery(name = "country")
	public Country getCountryById(@GraphQLArgument(name = "id") final Long id) {
		return countryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Country not found"));
	}

	@GraphQLMutation(name = "saveCountry")
	public Country saveCountry(@GraphQLArgument(name = "country") final Country country) {
		return countryRepository.save(country);
	}

	@GraphQLMutation(name = "deleteCountry")
	public void deleteCountry(@GraphQLArgument(name = "id") final Long id) {
		countryRepository.deleteById(id);
	}

	@GraphQLQuery(name = "isShow")
	public boolean isShow(@GraphQLContext final Country country) {
		final List<Country> countries = countryRepository.findAllByName(country.getName());
		return countries.size() > 0;
	}
}
