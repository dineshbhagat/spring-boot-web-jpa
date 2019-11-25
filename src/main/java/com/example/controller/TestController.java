package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
Ref: https://lankydan.dev/2017/03/11/passing-data-transfer-objects-with-get-in-spring-boot
*/
@RestController
public class TestController {

    /**
        When you have multiple queryParam, you can have one of the implementation as below.
        curl -X GET 'http://localhost:8080/test?s=a&deliveryMethod=2' -H 'Content-Type: application/json'
        or
        curl -X GET 'http://localhost:8080/test?deliveryMethod=2' -H 'Content-Type: application/json'
    */
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String test(Test test) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(test));
        return objectMapper.writeValueAsString(test);
    }

}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Test {
    private Integer deliveryMethod;
    private String s;
}
