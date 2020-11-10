package br.com.leroymerlin.test.util;

import br.com.leroymerlin.test.util.exception.ConverterException;

public class UtilProduct {

    public static Boolean convertNumberToBoolean(Double s) throws ConverterException {
        if (s == 0) {
            return Boolean.FALSE;
        } else if (s == 1) {
            return Boolean.TRUE;
        }
        throw new ConverterException("Could not convert string to boolean");
    }
}
