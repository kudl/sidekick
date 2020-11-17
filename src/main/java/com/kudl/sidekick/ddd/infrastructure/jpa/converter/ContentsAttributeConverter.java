package com.kudl.sidekick.ddd.infrastructure.jpa.converter;

import com.kudl.sidekick.ddd.domain.Contents;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class ContentsAttributeConverter implements AttributeConverter<Contents, String> {

	@Override
	public String convertToDatabaseColumn(Contents attribute) {
		if (Objects.isNull(attribute)) {
			return null;
		}

		return attribute.toString();
	}

	@Override
	public Contents convertToEntityAttribute(String dbData) {
		if (Objects.isNull(dbData)) {
			return null;
		}
		return Contents.of(dbData);

	}
}
