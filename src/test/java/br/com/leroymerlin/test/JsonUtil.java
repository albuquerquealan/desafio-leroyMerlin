package br.com.leroymerlin.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            String json = objectMapper.writeValueAsString(object);
            LOG.info("Converted json {} ", json);
            return json;
        } catch (JsonProcessingException ex) {
            LOG.error("Error to convert object, return an empty json", ex);
            return "{}";
        }
    }

}
