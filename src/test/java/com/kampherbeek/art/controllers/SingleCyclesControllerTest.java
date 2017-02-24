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
public class SingleCyclesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void retrieveCycleValues() throws Exception {
        final String jsonParam = "{\"internalId\":3,\"startJdnr\":1234567.89,\"endJdnr\":1234867.89," +
                "\"calculationPreferences\":{\"flags\":[\"SWIEPH\",\"SPEED\"]},\"periodResultFormat\":\"JSON\"," +
                "\"singleCyclesMethod\":\"SPEED\",\"locale\":\"en\"}";
        this.mockMvc.perform(get("/singlecycles").param("json", jsonParam)).andDo(print()).
                andExpect(status().isOk()).andExpect(content().string(containsString("allRows")));

    }
}

