package org.acme.config.config;

import org.acme.config.model.Computer;
import org.eclipse.microprofile.config.spi.Converter;

public class ComputerConfigConverter implements Converter<Computer> {
    @Override
    public Computer convert(String value) {
        return new Computer(value.split(","));
    }
}
