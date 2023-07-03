package com.springdata.converters;

import org.springframework.core.convert.converter.Converter;

import com.springdata.enums.Booleano;

public class BooleanoConverter implements Converter<String, Booleano> {

    @Override
    public Booleano convert(String source) {
        return Booleano.getByBoolean(Boolean.parseBoolean(source));
    }
}
