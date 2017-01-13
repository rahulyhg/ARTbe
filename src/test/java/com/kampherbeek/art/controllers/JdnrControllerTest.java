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

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JdnrControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getJdnr() throws Exception {
        String jsonParam =
                "{\"simpleDateTime\":{\"simpleDate\":{\"year\":2016,\"month\":1,\"day\":2,\"gregorian\":true},\"simpleTime\":{\"hour\":20,\"minute\":41,\"second\":0}}}";
        this.mockMvc.perform(get("/jdnr").param("json", jsonParam)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("jdnr")));
    }
}
