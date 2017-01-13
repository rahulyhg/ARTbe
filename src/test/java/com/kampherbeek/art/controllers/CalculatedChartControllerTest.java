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
public class CalculatedChartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCalculatedChart() throws Exception {
        final String jsonParam = "{\"simpleDateTime\":{\"simpleDate\":{\"year\":2002,\"month\":3,\"day\":15,\"gregorian\":true},\"simpleTime\":{\"hour\":13,\"minute\":54,\"second\":43}},\"location\":{\"longitude\":18.17,\"latitude\":55.44},\"flagValue\":258,\"houseSystemId\":12,\"bodyIds\":[0,1]}\n";
        this.mockMvc.perform(get("/calculatedchart").param("json", jsonParam)).andDo(print()).
                andExpect(status().isOk()).andExpect(content().string(containsString("bodySetPositionResponse")));
    }
}

