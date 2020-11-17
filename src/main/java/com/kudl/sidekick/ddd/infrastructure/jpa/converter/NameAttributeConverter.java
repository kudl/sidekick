package com.kudl.sidekick.ddd.infrastructure.jpa.converter;

import com.kudl.sidekick.ddd.domain.Name;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class NameAttributeConverter implements AttributeConverter<Name, String> {

	@Override
	public String convertToDatabaseColumn(Name attribute) {
		if (Objects.isNull(attribute)) {
			return null;
		}

		return attribute.toString();
	}

	@Override
	public Name convertToEntityAttribute(String dbData) {
		if (Objects.isNull(dbData)) {
			return null;
		}
		return Name.of(dbData);
	}
}
