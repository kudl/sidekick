package com.kudl.sidekick.ddd.infrastructure.jpa.converter;

import com.kudl.sidekick.ddd.domain.Hide;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class HideAttributeConverter implements AttributeConverter<Hide, Boolean> {

	@Override
	public Boolean convertToDatabaseColumn(Hide attribute) {
		if (Objects.isNull(attribute)) {
			return null;
		}

		return attribute.toBoolean();
	}

	@Override
	public Hide convertToEntityAttribute(Boolean dbData) {
		if (Objects.isNull(dbData)) {
			return null;
		}

		return Hide.of(dbData);
	}
}
