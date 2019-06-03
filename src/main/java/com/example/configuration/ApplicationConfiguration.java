package com.example.configuration;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class ApplicationConfiguration {

    @Bean
    public ObjectMapper getObjectMapper() {
        final ObjectMapper MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        /* 
        //If you need date in ISO8601 format in json serialization/deserialization, do following changes
        //JavaTimeModule javaTimeModule = new JavaTimeModule();
        //MAPPER.registerModule(javaTimeModule);
        //MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        */
        /* JsonView related switch
        MAPPER.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        */
        return MAPPER;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }
}
