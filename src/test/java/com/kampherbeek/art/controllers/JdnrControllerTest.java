package com.kampherbeek.art.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JdnrControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getJdnr() throws Exception {
        String jsonParam =
                "{\"year\":2016,\"month\":1,\"day\":2,\"hours\":20,\"minutes\":41,\"seconds\":0,\"gregorian\":true}";
        this.mockMvc.perform(get("/jdnr").param("json", jsonParam)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("jdnr")));
    }
}
