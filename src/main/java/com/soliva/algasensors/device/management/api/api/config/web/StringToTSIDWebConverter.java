package com.soliva.algasensors.device.management.api.api.config.web;

import io.hypersistence.tsid.TSID;
import org.springframework.core.convert.converter.Converter;

public class StringToTSIDWebConverter implements Converter<String, TSID> {

    @Override
    public TSID convert(String source) {
        return TSID.from(source);
    }
}
