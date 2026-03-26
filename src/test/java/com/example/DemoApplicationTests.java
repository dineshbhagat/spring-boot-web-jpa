package com.example;

import tools.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper MAPPER;

    @Test
    public void noParamGetShouldReturnDefaultMessage() throws Exception {

        Map<String, String> map = Maps.newHashMap();
        map.put("a", "Hello World!");
        String resp = this.mockMvc.perform(get("/health_check")).andDo(print()).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(MAPPER.writeValueAsString(map), resp);
    }

    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        String resp = this.mockMvc.perform(get("/health_check"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("hello worlds:" + resp);
    }

}
