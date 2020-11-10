package br.com.leroymerlin.test.util;

import br.com.leroymerlin.test.util.exception.ConverterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UtilProductTest {

    @Test
    void convertStringToBoolean_with_success() throws ConverterException {
        Double s = 0d;
        Boolean result = UtilProduct.convertNumberToBoolean(s);
        assertFalse(result);
    }

    @Test
    void convertStringToBoolean_with_throws_converter_exception() {
        Double s = 88d;
        assertThrows(ConverterException.class, () -> UtilProduct.convertNumberToBoolean(s));
    }

}