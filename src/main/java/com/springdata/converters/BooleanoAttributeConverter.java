package com.springdata.converters;

import com.springdata.enums.Booleano;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanoAttributeConverter implements AttributeConverter<Booleano, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Booleano attribute) {
        return attribute.getOpcao();
    }

    @Override
    public Booleano convertToEntityAttribute(Integer dbData) {
        return Booleano.getByOpcao(dbData);
    }
}
